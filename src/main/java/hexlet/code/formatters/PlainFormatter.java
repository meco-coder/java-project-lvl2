package hexlet.code.formatters;

import java.util.Collection;
import java.util.Map;

public class PlainFormatter {
    private static String resultToString;
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

    public static void updated(Object key, Object value1, Object value2) {
        if (value1 == null) {
            if (value2 instanceof Map || value2 instanceof Collection) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append((Object) null).append(" to ").append("[complex value]").append("\n");
            } else if (value2 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append((Object) null).append(" to ").append("'").append(value2).append("'").append("\n");
            } else {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append((Object) null).append(" to ").append(value2).append("\n");
            }
        }
        if (value2 == null) {
            if (value1 instanceof Map || value1 instanceof Collection) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("[complex value]").append(" to ").append((Object) null).append("\n");
            } else if (value1 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("'").append(value1).append("'").append(" to ").append((Object) null).append("\n");
            } else {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append(value1).append(" to ").append((Object) null).append("\n");
            }
        }
        if (value1 != null && value2 != null) {
            if ((value1 instanceof Map || value1 instanceof Collection)
                    && (value2 instanceof Map || value2 instanceof Collection)) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("[complex value]").append(" to ").append("[complex value]").append("\n");
            } else if (value1 instanceof String && value2 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("'").append(value1).append("'").append(" to ").append("'").append(value2).append("'")
                        .append("\n");
            } else if ((value1 instanceof Map || value1 instanceof Collection) && value2 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("[complex value]").append(" to ").append("'").append(value2).append("'").append("\n");
            } else if (value1 instanceof Map || value1 instanceof Collection) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("[complex value]").append(" to ").append(value2).append("\n");
            } else if ((value2 instanceof Map || value2 instanceof Collection) && value1 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("'").append(value1).append("'").append(" to ").append("[complex value]").append("\n");
            } else if (value2 instanceof Map || value2 instanceof Collection) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append(value1).append(" to ").append("[complex value]").append("\n");
            } else if (value1 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append("'").append(value1).append("'").append(" to ").append(value2).append("\n");
            } else if (value2 instanceof String) {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append(value1).append(" to ").append("'").append(value2).append("'").append("\n");
            } else {
                result.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                        .append(value1).append(" to ").append(value2).append("\n");
            }
        }
    }

    public static void remove(Object key) {
        result.append("Property ").append("'").append(key).append("' ").append("was removed").append("\n");
    }

    public static String getResult() {
        resultToString = result.toString().trim();
        result = new StringBuilder();
        return resultToString;
    }

}
