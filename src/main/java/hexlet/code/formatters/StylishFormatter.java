package hexlet.code.formatters;

public class StylishFormatter {
    private static StringBuilder result = new StringBuilder("{ \n");
    public static void add (Object key,Object value) {
        result.append(" + ").append(key).append(": ").append(value).append("\n");
    }
    public static void unchanged (Object key, Object value) {
        result.append("   ").append(key).append(": ").append(value).append("\n");
    }
    public static void change (Object key, Object value1, Object value2) {
        result.append(" - ").append(key).append(": ").append(value1).append("\n")
                        .append(" + ").append(key).append(": ").append(value2).append("\n");
    }
    public static void remove (Object key,Object value) {
        result.append(" - ").append(key).append(": ").append(value).append("\n");
    }
    public static String getResult () {
        result.append("}");
        return result.toString();
    }
}
