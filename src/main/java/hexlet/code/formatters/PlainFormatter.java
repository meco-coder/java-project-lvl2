package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class PlainFormatter {

    public static String plainFormat(Map<String, Map<String, ArrayList<Object>>> diff) {
        StringBuilder resultDiff = new StringBuilder();
        Set<String> keys = diff.keySet();
        for (String key : keys) {
            if (diff.get(key).containsKey("add")) {
                resultDiff.append(add(key, diff.get(key).get("add").get(0)));
            } else if (diff.get(key).containsKey("changed")) {
                resultDiff.append(changed(key, diff.get(key).get("changed").get(0), diff
                        .get(key).get("changed").get(1)));
            } else if (diff.get(key).containsKey("removed")) {
                resultDiff.append(removed(key));
            }
        }
        return resultDiff.toString().trim();
    }

    public static StringBuilder add(Object key, Object value) {
        StringBuilder resultAdd = new StringBuilder();
        value = filterValue(value);
        return resultAdd.append("Property ").append("'").append(key).append("' ").append("was added with value: ")
                .append(value).append("\n");
    }

    public static StringBuilder changed(Object key, Object valueFile1, Object valueFile2) {
        StringBuilder resultChanged = new StringBuilder();
        valueFile1 = filterValue(valueFile1);
        valueFile2 = filterValue(valueFile2);
        return resultChanged.append("Property ").append("'").append(key).append("' ").append("was updated. From ")
                .append(valueFile1).append(" to ").append(valueFile2).append("\n");
    }

    public static StringBuilder removed(Object key) {
        StringBuilder resultRemoved = new StringBuilder();
        return resultRemoved.append("Property ").append("'").append(key).append("' ").append("was removed")
                .append("\n");
    }

    public static Object filterValue(Object value) {
        if (value instanceof Collection || value instanceof Map) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value;
    }
}
