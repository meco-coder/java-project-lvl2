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
        return switch (format) {
            case "plain" -> PlainFormatter.plainFormat(diff);
            case "json" -> JsonFormatter.jsonFormat(diff);
            case "stylish" -> StylishFormatter.stylishFormat(diff);
            default -> throw new RuntimeException();
        };
    }

}
