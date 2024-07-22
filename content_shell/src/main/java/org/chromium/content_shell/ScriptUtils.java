package org.chromium.content_shell;

import org.json.JSONArray;
import org.json.JSONObject;

public class ScriptUtils {
    public static String getScript(String eventType, boolean success, Object obj) {
        String successString = "'success': " + success + ",";
        String javascriptCommand = "";

        if (obj instanceof String) {
            javascriptCommand = "window.dispatchEvent(new CustomEvent('" + eventType + "', {detail: { " + successString + " 'data':  `" + obj + "`}}))";
        } else if (obj instanceof Boolean || obj instanceof Integer || obj instanceof Long || obj instanceof Short || obj instanceof Number) {
            javascriptCommand = "window.dispatchEvent(new CustomEvent('" + eventType + "', {detail: { " + successString + " 'data':  " + obj + "}}))";
        } else {
            String toJson;
            if (obj instanceof JSONObject || obj instanceof JSONArray) {
                toJson = obj.toString();
            } else {
//                String json = GsonUtils.toJson(obj);
//                toJson = JSONObject.quote(json);
                toJson = "";
            }
            javascriptCommand = "window.dispatchEvent(new CustomEvent('" + eventType + "', {" + successString + " detail: {'data':  `" + toJson + "`}}))";
        }

        return javascriptCommand;
    }
}