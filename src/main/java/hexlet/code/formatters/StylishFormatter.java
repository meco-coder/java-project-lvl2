package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StylishFormatter {
    public static String stylishFormat(Map<String, Map<String, List<Object>>> diff) {
        final StringBuilder resultDiff = new StringBuilder("{\n");
        final Set<String> keys = diff.keySet();
        for (String key : keys) {
            final String keyFromValue = String.join("", diff.get(key).keySet());
            switch (keyFromValue) {
                case "add" -> resultDiff.append("  + ").append(key).append(": ").append(diff.get(key).get("add").get(0))
                        .append("\n");
                case "changed" -> resultDiff.append("  - ").append(key).append(": ")
                        .append(diff.get(key).get("changed").get(0))
                        .append("\n")
                        .append("  + ").append(key).append(": ").append(diff.get(key).get("changed").get(1))
                        .append("\n");
                case "removed" -> resultDiff.append("  - ").append(key).append(": ")
                        .append(diff.get(key).get("removed").get(0))
                        .append("\n");
                case "unchanged" -> resultDiff.append("    ").append(key).append(": ")
                        .append(diff.get(key).get("unchanged").get(0))
                        .append("\n");
                default -> throw new RuntimeException();
            }
        }
        resultDiff.append("}");
        return resultDiff.toString();
    }
}
