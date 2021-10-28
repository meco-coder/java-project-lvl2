package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(Map<String, Map<String, List<Object>>> diff, String format)
            throws JsonProcessingException {
        final String result;
        switch (format) {
            case "plain":
                result = PlainFormatter.plainFormat(diff);
                break;
            case "json":
                result = JsonFormatter.jsonFormat(diff);
                break;
            case "stylish":
                result = StylishFormatter.stylishFormat(diff);
                break;
            default:
                throw new RuntimeException();
        }
        return result;
    }

}
