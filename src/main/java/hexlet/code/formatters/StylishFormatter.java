package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class StylishFormatter {
    public static String stylishFormat(Map<String, Map<String, ArrayList<Object>>> resultDiffer) {
        StringBuilder resultDiff = new StringBuilder("{\n");
        Set<String> keys = resultDiffer.keySet();
        for (String key : keys) {
            if (resultDiffer.get(key).containsKey("add")) {
                resultDiff.append("  + ").append(key).append(": ").append(resultDiffer.get(key).get("add").get(0))
                        .append("\n");
            } else if (resultDiffer.get(key).containsKey("unchanged")) {
                resultDiff.append("    ").append(key).append(": ").append(resultDiffer.get(key).get("unchanged").get(0))
                        .append("\n");
            } else if (resultDiffer.get(key).containsKey("changed")) {
                resultDiff.append("  - ").append(key).append(": ").append(resultDiffer.get(key).get("changed").get(0))
                        .append("\n")
                        .append("  + ").append(key).append(": ").append(resultDiffer.get(key).get("changed").get(1))
                        .append("\n");
            } else {
                resultDiff.append("  - ").append(key).append(": ").append(resultDiffer.get(key).get("removed").get(0))
                        .append("\n");
            }
        }
        resultDiff.append("}");
        return resultDiff.toString();
    }
}
