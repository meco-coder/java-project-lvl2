package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlainFormatter {

    private static final String ADD_TEMPLATE = "Property '%s' was added with value: %s\n";
    private static final String CHANGED_TEMPLATE = "Property '%s' was updated. From %s to %s\n";
    private static final String REMOVED_TEMPLATE = "Property '%s' was removed\n";

    public static String plainFormat(Map<String, Map<String, List<Object>>> diff) {
        final StringBuilder resultDiff = new StringBuilder();
        final Set<String> keys = diff.keySet();
        for (String key : keys) {
            final String keyFromValue = String.join("", diff.get(key).keySet());
            resultDiff.append(formatDiff(keyFromValue, key, diff));
        }
        return resultDiff.toString().trim();
    }

    public static StringBuilder add(Object key, Object value) {
        final StringBuilder resultAdd = new StringBuilder();
        return resultAdd.append(String.format(ADD_TEMPLATE, key, stringifyValue(value)));
    }

    public static StringBuilder changed(Object key, Object valueFile1, Object valueFile2) {
        final StringBuilder resultChanged = new StringBuilder();
        return resultChanged.append(String.format(CHANGED_TEMPLATE, key, stringifyValue(valueFile1),
                stringifyValue(valueFile2)));
    }

    public static StringBuilder removed(Object key) {
        final StringBuilder resultRemoved = new StringBuilder();
        return resultRemoved.append(String.format(REMOVED_TEMPLATE, key));
    }

    public static Object stringifyValue(Object value) {
        if (value instanceof Collection || value instanceof Map) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return value;
    }

    public static StringBuilder formatDiff(String keyFromValue, String key,
                                           Map<String, Map<String, List<Object>>> diff) {
        final StringBuilder resultFormatDiff = new StringBuilder();
        switch (keyFromValue) {
            case "add" -> {
                return resultFormatDiff.append(add(key, diff.get(key).get("add").get(0)));
            }
            case "changed" -> {
                return resultFormatDiff.append(changed(key, diff.get(key).get("changed").get(0),
                        diff.get(key).get("changed").get(1)));
            }
            case "removed" -> {
                return resultFormatDiff.append(removed(key));
            }
            case "unchanged" -> {
                return resultFormatDiff;
            }
            default -> throw new RuntimeException();
        }
    }
}
