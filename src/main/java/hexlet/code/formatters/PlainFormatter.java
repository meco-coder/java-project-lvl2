package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class PlainFormatter {
    private static StringBuilder result = new StringBuilder();

    public static String plainFormat(Map<String, Map<String, ArrayList<Object>>> resultDifferFile1AndFile2) {
        Set<String> result1 = resultDifferFile1AndFile2.keySet();
        for (String key : result1) {
            if (resultDifferFile1AndFile2.get(key).containsKey("add")) {
                add(key, resultDifferFile1AndFile2.get(key).get("add").get(0));
            } else if (resultDifferFile1AndFile2.get(key).containsKey("changed")) {
                changed(key, resultDifferFile1AndFile2.get(key).get("changed").get(0), resultDifferFile1AndFile2
                        .get(key).get("changed").get(1));
            } else if (resultDifferFile1AndFile2.get(key).containsKey("removed")) {
                removed(key);
            }
        }
        String resultToString = result.toString().trim();
        result = new StringBuilder();
        return resultToString;
    }

    public static void add(Object key, Object value) {
        if (value instanceof Collection || value instanceof Map) {
            result.append("Property ").append("'").append(key).append("' ").append("was added with value: ")
                    .append("[complex value]").append("\n");
        } else if (value instanceof String) {
            result.append("Property ").append("'").append(key).append("' ").append("was added with value: ")
                    .append("'").append(value).append("'").append("\n");
        } else {
            result.append("Property ").append("'").append(key).append("' ").append("was added with value: ")
                    .append(value).append("\n");
        }
    }

    public static void changed(Object key, Object valueFile1, Object valueFile2) {
        if (valueFile1 == null) {
            if (valueFile2 instanceof Map || valueFile2 instanceof Collection) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append((Object) null).append(" to ").append("[complex value]").append("\n");
            } else if (valueFile2 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append((Object) null).append(" to ").append("'").append(valueFile2).append("'").append("\n");
            } else {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append((Object) null).append(" to ").append(valueFile2).append("\n");
            }
        }
        if (valueFile2 == null) {
            if (valueFile1 instanceof Map || valueFile1 instanceof Collection) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("[complex value]").append(" to ").append((Object) null).append("\n");
            } else if (valueFile1 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("'").append(valueFile1).append("'").append(" to ").append((Object) null).append("\n");
            } else {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append(valueFile1).append(" to ").append((Object) null).append("\n");
            }
        }
        if (valueFile1 != null && valueFile2 != null) {
            if ((valueFile1 instanceof Map || valueFile1 instanceof Collection)
                    && (valueFile2 instanceof Map || valueFile2 instanceof Collection)) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("[complex value]").append(" to ").append("[complex value]").append("\n");
            } else if (valueFile1 instanceof String && valueFile2 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("'").append(valueFile1).append("'").append(" to ").append("'").append(valueFile2)
                        .append("'")
                        .append("\n");
            } else if ((valueFile1 instanceof Map || valueFile1 instanceof Collection)
                    && valueFile2 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("[complex value]").append(" to ").append("'").append(valueFile2).append("'")
                        .append("\n");
            } else if (valueFile1 instanceof Map || valueFile1 instanceof Collection) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("[complex value]").append(" to ").append(valueFile2).append("\n");
            } else if ((valueFile2 instanceof Map || valueFile2 instanceof Collection)
                    && valueFile1 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("'").append(valueFile1).append("'").append(" to ").append("[complex value]")
                        .append("\n");
            } else if (valueFile2 instanceof Map || valueFile2 instanceof Collection) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append(valueFile1).append(" to ").append("[complex value]").append("\n");
            } else if (valueFile1 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("'").append(valueFile1).append("'").append(" to ").append(valueFile2).append("\n");
            } else if (valueFile2 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append(valueFile1).append(" to ").append("'").append(valueFile2).append("'").append("\n");
            } else {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append(valueFile1).append(" to ").append(valueFile2).append("\n");
            }
        }
    }

    public static void removed(Object key) {
        result.append("Property ").append("'").append(key).append("' ").append("was removed").append("\n");
    }
}
