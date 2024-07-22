package org.chromium.ui.mojom;

import org.chromium.ax.mojom.Role;
import org.chromium.blink.mojom.CssSampleId;
import org.chromium.blink.mojom.WebFeature;

public final class KeyboardCode {
  public static final int A = 65;
  public static final int ACCEPT = 30;
  public static final int ADD = 107;
  public static final int ALTGR = 225;
  public static final int APPS = 93;
  public static final int ASSISTANT = 153;
  public static final int ATTN = 246;
  public static final int B = 66;
  public static final int BACK = 8;
  public static final int BRIGHTNESS_DOWN = 216;
  public static final int BRIGHTNESS_UP = 217;
  public static final int BROWSER_BACK = 166;
  public static final int BROWSER_FAVORITES = 171;
  public static final int BROWSER_FORWARD = 167;
  public static final int BROWSER_HOME = 172;
  public static final int BROWSER_REFRESH = 168;
  public static final int BROWSER_SEARCH = 170;
  public static final int BROWSER_STOP = 169;
  public static final int C = 67;
  public static final int CAPITAL = 20;
  public static final int CLEAR = 12;
  public static final int COMMAND = 91;
  public static final int COMPOSE = 230;
  public static final int CONTROL = 17;
  public static final int CONVERT = 28;
  public static final int CRSEL = 247;
  public static final int D = 68;
  public static final int DBE_DBCSCHAR = 244;
  public static final int DBE_SBCSCHAR = 243;
  public static final int DECIMAL = 110;
  public static final int DELETE_KEY = 46;
  public static final int DIVIDE = 111;
  public static final int DOWN = 40;
  public static final int E = 69;
  public static final int END = 35;
  public static final int EREOF = 249;
  public static final int ESCAPE = 27;
  public static final int EXECUTE = 43;
  public static final int EXSEL = 248;
  public static final int F = 70;
  public static final int F1 = 112;
  public static final int F10 = 121;
  public static final int F11 = 122;
  public static final int F12 = 123;
  public static final int F13 = 124;
  public static final int F14 = 125;
  public static final int F15 = 126;
  public static final int F16 = 127;
  public static final int F17 = 128;
  public static final int F18 = 129;
  public static final int F19 = 130;
  public static final int F2 = 113;
  public static final int F20 = 131;
  public static final int F21 = 132;
  public static final int F22 = 133;
  public static final int F23 = 134;
  public static final int F24 = 135;
  public static final int F3 = 114;
  public static final int F4 = 115;
  public static final int F5 = 116;
  public static final int F6 = 117;
  public static final int F7 = 118;
  public static final int F8 = 119;
  public static final int F9 = 120;
  public static final int FINAL = 24;
  public static final int G = 71;
  public static final int H = 72;
  public static final int HANGUL = 21;
  public static final int HANJA = 25;
  public static final int HELP = 47;
  public static final int HOME = 36;
  public static final int I = 73;
  public static final int INSERT = 45;
  private static final boolean IS_EXTENSIBLE = true;

  public static final int f4J = 74;
  public static final int JUNJA = 23;
  public static final int K = 75;
  public static final int KANA = 21;
  public static final int KANJI = 25;
  public static final int KBD_BRIGHTNESS_DOWN = 218;
  public static final int KBD_BRIGHTNESS_UP = 232;
  public static final int L = 76;
  public static final int LCONTROL = 162;
  public static final int LEFT = 37;
  public static final int LMENU = 164;
  public static final int LSHIFT = 160;
  public static final int LWIN = 91;
  public static final int M = 77;
  public static final int MAX_VALUE = 254;
  public static final int MEDIA_LAUNCH_APP1 = 182;
  public static final int MEDIA_LAUNCH_APP2 = 183;
  public static final int MEDIA_LAUNCH_MAIL = 180;
  public static final int MEDIA_LAUNCH_MEDIA_SELECT = 181;
  public static final int MEDIA_NEXT_TRACK = 176;
  public static final int MEDIA_PLAY_PAUSE = 179;
  public static final int MEDIA_PREV_TRACK = 177;
  public static final int MEDIA_STOP = 178;
  public static final int MENU = 18;
  public static final int MIN_VALUE = 0;
  public static final int MODECHANGE = 31;
  public static final int MULTIPLY = 106;
  public static final int N = 78;
  public static final int NEXT = 34;
  public static final int NONAME = 252;
  public static final int NONCONVERT = 29;
  public static final int NUMLOCK = 144;
  public static final int NUMPAD0 = 96;
  public static final int NUMPAD1 = 97;
  public static final int NUMPAD2 = 98;
  public static final int NUMPAD3 = 99;
  public static final int NUMPAD4 = 100;
  public static final int NUMPAD5 = 101;
  public static final int NUMPAD6 = 102;
  public static final int NUMPAD7 = 103;
  public static final int NUMPAD8 = 104;
  public static final int NUMPAD9 = 105;
  public static final int NUM_0 = 48;
  public static final int NUM_1 = 49;
  public static final int NUM_2 = 50;
  public static final int NUM_3 = 51;
  public static final int NUM_4 = 52;
  public static final int NUM_5 = 53;
  public static final int NUM_6 = 54;
  public static final int NUM_7 = 55;
  public static final int NUM_8 = 56;
  public static final int NUM_9 = 57;
  public static final int O = 79;
  public static final int OEM_1 = 186;
  public static final int OEM_102 = 226;
  public static final int OEM_2 = 191;
  public static final int OEM_3 = 192;
  public static final int OEM_4 = 219;
  public static final int OEM_5 = 220;
  public static final int OEM_6 = 221;
  public static final int OEM_7 = 222;
  public static final int OEM_8 = 223;
  public static final int OEM_CLEAR = 254;
  public static final int OEM_COMMA = 188;
  public static final int OEM_MINUS = 189;
  public static final int OEM_PERIOD = 190;
  public static final int OEM_PLUS = 187;
  public static final int P = 80;
  public static final int PA1 = 253;
  public static final int PACKET = 231;
  public static final int PAUSE = 19;
  public static final int PLAY = 250;
  public static final int POWER = 152;
  public static final int PRINT = 42;
  public static final int PRIOR = 33;
  public static final int PROCESSKEY = 229;
  public static final int Q = 81;
  public static final int R = 82;
  public static final int RCONTROL = 163;
  public static final int RETURN = 13;
  public static final int RIGHT = 39;
  public static final int RMENU = 165;
  public static final int RSHIFT = 161;
  public static final int RWIN = 92;
  public static final int S = 83;
  public static final int SCROLL = 145;
  public static final int SELECT = 41;
  public static final int SEPARATOR = 108;
  public static final int SHIFT = 16;
  public static final int SLEEP = 95;
  public static final int SNAPSHOT = 44;
  public static final int SPACE = 32;
  public static final int SUBTRACT = 109;
  public static final int T = 84;
  public static final int TAB = 9;
  public static final int U = 85;
  public static final int UNKNOWN = 0;
  public static final int UP = 38;
  public static final int V = 86;
  public static final int VOLUME_DOWN = 174;
  public static final int VOLUME_MUTE = 173;
  public static final int VOLUME_UP = 175;
  public static final int W = 87;
  public static final int WLAN = 151;
  public static final int X = 88;
  public static final int Y = 89;
  public static final int Z = 90;
  public static final int ZOOM = 251;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 0:
      case 8:
      case 9:
      case 12:
      case 13:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 23:
      case 24:
      case 25:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
      case 65:
      case 66:
      case 67:
      case 68:
      case 69:
      case 70:
      case 71:
      case 72:
      case 73:
      case 74:
      case 75:
      case 76:
      case 77:
      case 78:
      case 79:
      case 80:
      case 81:
      case 82:
      case 83:
      case 84:
      case 85:
      case 86:
      case 87:
      case 88:
      case 89:
      case 90:
      case 91:
      case 92:
      case 93:
      case 95:
      case 96:
      case 97:
      case 98:
      case 99:
      case 100:
      case 101:
      case 102:
      case 103:
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
      case 109:
      case 110:
      case 111:
      case 112:
      case 113:
      case 114:
      case 115:
      case 116:
      case 117:
      case 118:
      case 119:
      case 120:
      case 121:
      case 122:
      case 123:
      case 124:
      case 125:
      case 126:
      case 127:
      case 128:
      case 129:
      case 130:
      case 131:
      case 132:
      case 133:
      case 134:
      case 135:
      case 144:
      case 145:
      case 151:
      case 152:
      case 153:
      case 160:
      case 161:
      case 162:
      case 163:
      case 164:
      case 165:
      case 166:
      case 167:
      case 168:
      case 169:
      case 170:
      case 171:
      case 172:
      case 173:
      case 174:
      case 175:
      case 176:
      case 177:
      case 178:
      case 179:
      case 180:
      case 181:
      case 182:
      case 183:
      case 186:
      case 187:
      case 188:
      case 189:
      case 190:
      case 191:
      case 192:
      case 216:
      case 217:
      case 218:
      case 219:
      case 220:
      case 221:
      case 222:
      case 223:
      case 225:
      case 226:
      case 229:
      case 230:
      case 231:
      case 232:
      case 243:
      case 244:
      case 246:
      case 247:
      case 248:
      case 249:
      case 250:
      case 251:
      case 252:
      case PA1 /* 253 */:
      case 254:
        return true;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 10:
      case 11:
      case 14:
      case 15:
      case 22:
      case 26:
      case 58:
      case 59:
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
      case 94:
      case 136:
      case 137:
      case 138:
      case 139:
      case 140:
      case 141:
      case 142:
      case 143:
      case 146:
      case 147:
      case 148:
      case 149:
      case 150:
      case 154:
      case 155:
      case 156:
      case 157:
      case 158:
      case 159:
      case 184:
      case 185:
      case 193:
      case Role.MATH_ML_OVER /* 194 */:
      case 195:
      case 196:
      case 197:
      case 198:
      case 199:
      case 200:
      case 201:
      case 202:
      case 203:
      case 204:
      case 205:
      case Role.MATH_ML_TEXT /* 206 */:
      case Role.MATH_ML_UNDER /* 207 */:
      case 208:
      case 209:
      case 210:
      case 211:
      case 212:
      case WebFeature.HTML_ELEMENT_INNER_TEXT /* 213 */:
      case WebFeature.HTML_ELEMENT_OUTER_TEXT /* 214 */:
      case 215:
      case CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH /* 224 */:
      case CssSampleId.ALIAS_WEBKIT_COLUMNS /* 227 */:
      case 228:
      case 233:
      case 234:
      case 235:
      case CssSampleId.FLEX_FLOW /* 236 */:
      case 237:
      case CssSampleId.FLEX_SHRINK /* 238 */:
      case CssSampleId.FLEX_WRAP /* 239 */:
      case 240:
      case 241:
      case CssSampleId.GRID_TEMPLATE_COLUMNS /* 242 */:
      case CssSampleId.GRID_COLUMN_END /* 245 */:
      default:
        return false;
    }
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    return value;
  }

  private KeyboardCode() {}
}
