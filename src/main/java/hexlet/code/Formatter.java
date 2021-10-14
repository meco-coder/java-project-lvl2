package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

public class Formatter {
    public static void add(Object key, Object value, String format) throws JsonProcessingException {
        switch (format) {
            case "plain":
                PlainFormatter.add(key, value);
                break;
            case "json":
                JsonFormatter.differJson(key, value);
                break;
            default:
                StylishFormatter.add(key, value);
        }
    }

    public static void unchanged(Object key, Object value, String format) {
        if (format.equals("stylish")) {
            StylishFormatter.unchanged(key, value);
        }
    }

    public static void changed(Object key, Object valueFile1, Object valueFile2, String format)
            throws JsonProcessingException {
        switch (format) {
            case "plain":
                PlainFormatter.updated(key, valueFile1, valueFile2);
                break;
            case "json":
                JsonFormatter.differJson(key, valueFile1);
                JsonFormatter.differJson(key, valueFile2);
                break;
            default:
                StylishFormatter.change(key, valueFile1, valueFile2);

        }
    }

    public static void remove(Object key, Object value, String format) throws JsonProcessingException {
        switch (format) {
            case "plain":
                PlainFormatter.remove(key);
                break;
            case "json":
                JsonFormatter.differJson(key, value);
                break;
            default:
                StylishFormatter.remove(key, value);
        }
    }

    public static String getResult(String format) {
        String result = "";
        switch (format) {
            case "plain":
                result = PlainFormatter.getResult();
                break;
            case "json":
                result = JsonFormatter.getResult();
                break;
            default:
                result = StylishFormatter.getResult();
        }
        return result;
    }

}
