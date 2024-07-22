package org.chromium.content.browser.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewStructure;
import java.util.ArrayList;
import java.util.Arrays;
import org.chromium.content.browser.RenderCoordinatesImpl;

public class ViewStructureBuilder {
  private RenderCoordinatesImpl mRenderCoordinates;

  public ViewStructureBuilder(RenderCoordinatesImpl renderCoordinates) {
    this.mRenderCoordinates = renderCoordinates;
  }

  private void populateViewStructureNode(
      ViewStructure node,
      String text,
      boolean hasSelection,
      int selStart,
      int selEnd,
      int color,
      int bgcolor,
      float size,
      boolean bold,
      boolean italic,
      boolean underline,
      boolean lineThrough,
      String className,
      int childCount) {
    node.setClassName(className);
    node.setChildCount(childCount);
    if (hasSelection) {
      node.setText(text, selStart, selEnd);
    } else {
      node.setText(text);
    }
    if (size >= 0.0d) {
      int style = (lineThrough ? 8 : 0) | (bold ? 1 : 0) | (italic ? 2 : 0) | (underline ? 4 : 0);
      node.setTextStyle(size, color, bgcolor, style);
    }
  }

  private void setViewStructureNodeBounds(
      ViewStructure node,
      boolean isRootNode,
      int parentRelativeLeft,
      int parentRelativeTop,
      int width,
      int height,
      int unclippedLeft,
      int unclippedTop,
      int unclippedWidth,
      int unclippedHeight,
      int pageAbsoluteLeft,
      int pageAbsoluteTop,
      int pageAbsoluteWidth,
      int pageAbsoluteHeight) {
    Rect boundsInParent =
        new Rect(
            parentRelativeLeft,
            parentRelativeTop,
            parentRelativeLeft + width,
            parentRelativeTop + height);
    if (isRootNode) {
      boundsInParent.offset(0, (int) this.mRenderCoordinates.getContentOffsetYPix());
    }
    node.setDimens(boundsInParent.left, boundsInParent.top, 0, 0, width, height);
    Bundle extras = node.getExtras();
    extras.putInt(AccessibilityNodeInfoBuilder.EXTRAS_KEY_UNCLIPPED_LEFT, unclippedLeft);
    extras.putInt(AccessibilityNodeInfoBuilder.EXTRAS_KEY_UNCLIPPED_TOP, unclippedTop);
    extras.putInt(AccessibilityNodeInfoBuilder.EXTRAS_KEY_UNCLIPPED_WIDTH, unclippedWidth);
    extras.putInt(AccessibilityNodeInfoBuilder.EXTRAS_KEY_UNCLIPPED_HEIGHT, unclippedHeight);
    extras.putInt(AccessibilityNodeInfoBuilder.EXTRAS_KEY_PAGE_ABSOLUTE_LEFT, pageAbsoluteLeft);
    extras.putInt(AccessibilityNodeInfoBuilder.EXTRAS_KEY_PAGE_ABSOLUTE_TOP, pageAbsoluteTop);
    extras.putInt(AccessibilityNodeInfoBuilder.EXTRAS_KEY_PAGE_ABSOLUTE_WIDTH, pageAbsoluteWidth);
    extras.putInt(AccessibilityNodeInfoBuilder.EXTRAS_KEY_PAGE_ABSOLUTE_HEIGHT, pageAbsoluteHeight);
  }

  protected void setViewStructureNodeHtmlInfo(
      ViewStructure node, String htmlTag, String cssDisplay, String[][] htmlAttributes) {
    ViewStructure.HtmlInfo.Builder htmlBuilder = node.newHtmlInfoBuilder(htmlTag);
    if (htmlBuilder != null) {
      htmlBuilder.addAttribute("display", cssDisplay);
      for (String[] attr : htmlAttributes) {
        htmlBuilder.addAttribute(attr[0], attr[1]);
      }
      node.setHtmlInfo(htmlBuilder.build());
    }
  }

  protected void setViewStructureNodeHtmlMetadata(ViewStructure node, String[] metadataStrings) {
    Bundle extras = node.getExtras();
    extras.putStringArrayList("metadata", new ArrayList<>(Arrays.asList(metadataStrings)));
  }

  private void commitViewStructureNode(ViewStructure node) {
    node.asyncCommit();
  }

  private ViewStructure addViewStructureNodeChild(ViewStructure node, int index) {
    return node.asyncNewChild(index);
  }
}
