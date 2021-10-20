package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.ArrayList;
import java.util.Map;

public class Formatter {

    public static String format(Map<String, Map<String, ArrayList<Object>>> resultDifferFile1AndFile2, String format)
            throws JsonProcessingException {
        String result = "";
        switch (format) {
            case "plain":
                result = PlainFormatter.plainFormat(resultDifferFile1AndFile2);
                break;
            case "json":
                result = JsonFormatter.jsonFormat(resultDifferFile1AndFile2);
                break;
            default:
                result = StylishFormatter.jsonFormat(resultDifferFile1AndFile2);
        }
        return result;
    }

}
