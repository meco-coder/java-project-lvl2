package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

public class Formatter {
    public static void add(Object key, Object value, String format) throws JsonProcessingException {
        switch (format) {
            case "stylish":
                StylishFormatter.add(key, value);
                break;
            case "plain":
                PlainFormatter.add(key, value);
                break;
            case "json":
                JsonFormatter.differJson(key, value);
                break;
        }
    }

    public static void unchanged(Object key, Object value, String format) {
        StylishFormatter.unchanged(key, value);
    }

    public static void changed(Object key, Object value1, Object value2, String format) throws JsonProcessingException {
        switch (format) {
            case "stylish":
                StylishFormatter.change(key, value1, value2);
                break;
            case "plain":
                PlainFormatter.updated(key, value1, value2);
                break;
            case "json":
                JsonFormatter.differJson(key, value1);
                JsonFormatter.differJson(key, value2);
                break;
        }
    }

    public static void remove(Object key, Object value, String format) throws JsonProcessingException {
        switch (format) {
            case "stylish":
                StylishFormatter.remove(key, value);
                break;
            case "plain":
                PlainFormatter.remove(key);
                break;
            case "json":
                JsonFormatter.differJson(key, value);
                break;
        }
    }

    public static String getResult(String format) {
        String result = "";
        if (format.equals("stylish")) {
            result = StylishFormatter.getResult();
        } else if (format.equals("plain")) {
            result = PlainFormatter.getResult();
        } else if (format.equals("json")) {
            result = JsonFormatter.getResult();
        }
        return result;
    }

}
