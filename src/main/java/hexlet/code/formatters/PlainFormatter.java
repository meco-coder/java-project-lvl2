package hexlet.code.formatters;

import java.util.Collection;
import java.util.Map;

public class PlainFormatter {
    private static StringBuilder result = new StringBuilder();

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

    public static void updated(Object key, Object valueFile1, Object valueFile2) {
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
                        .append("'").append(valueFile1).append("'").append(" to ").append("'").append(valueFile2).append("'")
                        .append("\n");
            } else if ((valueFile1 instanceof Map || valueFile1 instanceof Collection) && valueFile2 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("[complex value]").append(" to ").append("'").append(valueFile2).append("'").append("\n");
            } else if (valueFile1 instanceof Map || valueFile1 instanceof Collection) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("[complex value]").append(" to ").append(valueFile2).append("\n");
            } else if ((valueFile2 instanceof Map || valueFile2 instanceof Collection) && valueFile1 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("'").append(valueFile1).append("'").append(" to ").append("[complex value]").append("\n");
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

    public static void remove(Object key) {
        result.append("Property ").append("'").append(key).append("' ").append("was removed").append("\n");
    }

    public static String getResult() {
        String resultToString = result.toString().trim();
        result = new StringBuilder();
        return resultToString;
    }

}
