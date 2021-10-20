package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class StylishFormatter {
    public static String jsonFormat(Map<String, Map<String, ArrayList<Object>>> resultDiffer) {
        StringBuilder result = new StringBuilder("{\n");
        Set<String> result1 = resultDiffer.keySet();
        for (String key : result1) {
            if (resultDiffer.get(key).containsKey("add")) {
                result.append("  + ").append(key).append(": ").append(resultDiffer.get(key).get("add").get(0))
                        .append("\n");
            } else if (resultDiffer.get(key).containsKey("unchanged")) {
                result.append("    ").append(key).append(": ").append(resultDiffer.get(key).get("unchanged").get(0))
                        .append("\n");
            } else if (resultDiffer.get(key).containsKey("changed")) {
                result.append("  - ").append(key).append(": ").append(resultDiffer.get(key).get("changed").get(0))
                        .append("\n")
                        .append("  + ").append(key).append(": ").append(resultDiffer.get(key).get("changed").get(1))
                        .append("\n");
            } else {
                result.append("  - ").append(key).append(": ").append(resultDiffer.get(key).get("removed").get(0))
                        .append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
