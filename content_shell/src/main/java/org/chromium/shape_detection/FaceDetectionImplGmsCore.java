package org.chromium.shape_detection;

import android.graphics.PointF;
import android.util.SparseArray;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.system.MojoException;
import org.chromium.shape_detection.mojom.FaceDetection;
import org.chromium.shape_detection.mojom.FaceDetectionResult;
import org.chromium.shape_detection.mojom.FaceDetectorOptions;
import org.chromium.shape_detection.mojom.Landmark;
import org.chromium.skia.mojom.BitmapN32;

public class FaceDetectionImplGmsCore implements FaceDetection {

  private static final int MAX_EULER_Z = 15;
  private static final int MAX_FACES = 32;
  private static final String TAG = "FaceDetectionImpl";
  private final FaceDetector mFaceDetector;
  private final boolean mFastMode;
  private final int mMaxFaces;

  public FaceDetectionImplGmsCore(FaceDetectorOptions options) {
    FaceDetector.Builder builder = new FaceDetector.Builder(ContextUtils.getApplicationContext());
    int min = Math.min(options.maxDetectedFaces, 32);
    this.mMaxFaces = min;
    boolean z = options.fastMode;
    this.mFastMode = z;
    try {
      builder.setMode(z ? 0 : 1);
      builder.setLandmarkType(1);
      if (min == 1) {
        builder.setProminentFaceOnly(true);
      }
      this.mFaceDetector = builder.build();
    } catch (IllegalArgumentException e) {
      Log.e(TAG, "Unexpected exception " + e);
      throw new AssertionError();
    }
  }

  @Override
  public void detect(BitmapN32 bitmapData, FaceDetection.Detect_Response callback) {
    Landmark landmark;
    if (!this.mFaceDetector.isOperational()) {
      Log.e(TAG, "FaceDetector is not operational");
      FaceDetectorOptions options = new FaceDetectorOptions();
      options.fastMode = this.mFastMode;
      options.maxDetectedFaces = this.mMaxFaces;
      FaceDetectionImpl detector = new FaceDetectionImpl(options);
      detector.detect(bitmapData, callback);
      return;
    }
    Frame frame = BitmapUtils.convertToFrame(bitmapData);
    Landmark mojoLandmark = null;
    if (frame == null) {
      Log.e(TAG, "Error converting Mojom Bitmap to Frame");
      callback.call(new FaceDetectionResult[0]);
      return;
    }
    SparseArray<Face> faces = this.mFaceDetector.detect(frame);
    FaceDetectionResult[] faceArray = new FaceDetectionResult[faces.size()];
    int i = 0;
    while (i < faces.size()) {
      faceArray[i] = new FaceDetectionResult();
      Face face = faces.valueAt(i);
      PointF corner = face.getPosition();
      faceArray[i].boundingBox = new RectF();
      faceArray[i].boundingBox.x = corner.x;
      faceArray[i].boundingBox.y = corner.y;
      faceArray[i].boundingBox.width = face.getWidth();
      faceArray[i].boundingBox.height = face.getHeight();
      List<com.google.android.gms.vision.face.Landmark> landmarks = face.getLandmarks();
      ArrayList<Landmark> mojoLandmarks = new ArrayList<>(landmarks.size());
      int j = 0;
      while (j < landmarks.size()) {
        com.google.android.gms.vision.face.Landmark landmark2 = landmarks.get(j);
        int landmarkType = landmark2.getType();
        if (landmarkType != 4 && landmarkType != 10 && landmarkType != 0 && landmarkType != 6) {
          landmark = null;
        } else {
          Landmark mojoLandmark2 = new Landmark();
          mojoLandmark2.locations = new org.chromium.gfx.mojom.PointF[1];
          mojoLandmark2.locations[0] = new org.chromium.gfx.mojom.PointF();
          mojoLandmark2.locations[0].x = landmark2.getPosition().x;
          mojoLandmark2.locations[0].y = landmark2.getPosition().y;
          if (landmarkType == 4) {
            mojoLandmark2.type = 1;
            landmark = null;
          } else if (landmarkType == 10) {
            mojoLandmark2.type = 1;
            landmark = null;
          } else if (landmarkType == 0) {
            landmark = null;
            mojoLandmark2.type = 0;
          } else {
            landmark = null;
            if (landmarkType != 6) {
              throw new AssertionError();
            }
            mojoLandmark2.type = 2;
          }
          mojoLandmarks.add(mojoLandmark2);
        }
        j++;
        mojoLandmark = landmark;
      }
      Landmark landmark3 = mojoLandmark;
      faceArray[i].landmarks =
          (Landmark[]) mojoLandmarks.toArray(new Landmark[mojoLandmarks.size()]);
      i++;
      mojoLandmark = landmark3;
    }
    callback.call(faceArray);
  }

  @Override
  public void close() {
    this.mFaceDetector.release();
  }

  @Override
  public void onConnectionError(MojoException e) {
    close();
  }
}
