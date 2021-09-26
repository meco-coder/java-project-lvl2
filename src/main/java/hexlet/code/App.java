package hexlet.code;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "checksum 4.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<String> {

    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private String format = "json";

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    Path filePath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    Path filePath2;


    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public String call() throws Exception {// your business logic goes here...
        filePath1 = Paths.get("file1.json").toAbsolutePath().normalize();
        filePath2 = Paths.get("file2.json").toAbsolutePath().normalize();
        String data1 = Files.readString(filePath1).trim();
        String data2 = Files.readString(filePath2).trim();
        System.out.println(Differ.generate(data1, data2));
        return null;
    }

}

//public class App {
//    public static void main(String[] args) throws IOException {
//        Path filePath1 = Paths.get("file1.json").toAbsolutePath().normalize();
//        String data1 = Files.readString(filePath1).trim();
//        ObjectMapper mapper = new ObjectMapper();
//        TreeMap<Object, Object> map
//                = mapper.readValue(data1, new TypeReference<>() {
//        });
//
//        Path filePath2 = Paths.get("file2.json").toAbsolutePath().normalize();
//        String data2 = Files.readString(filePath2).trim();
//        ObjectMapper mapper2 = new ObjectMapper();
//        TreeMap<Object, Object> map2
//                = mapper2.readValue(data2, new TypeReference<>() {
//        });
//        StringBuilder result = new StringBuilder("{ \n");
//        Set<Map.Entry<Object, Object>> file1 = map.entrySet();
//        Set<Map.Entry<Object, Object>> file2 = map2.entrySet();
//        for (Map.Entry<Object, Object> file11 : file1) {
//            Object key = file11.getKey();
//            Object value = file11.getValue();
//            if (map2.containsKey(key) && map2.containsValue(value)) {
//                result.append("   ").append(key).append(": ").append(value).append("\n");
//            } else if (map2.containsKey(key) && !map2.containsValue(value)) {
//                result.append(" - ").append(key).append(": ").append(value).append("\n")
//                        .append(" + ").append(key).append(": ").append(map2.get(key)).append("\n");
//            } else {
//                result.append(" - ").append(key).append(": ").append(value).append("\n");
//            }
//        }
//
//        for (Map.Entry<Object, Object> file22 : file2) {
//            Object key = file22.getKey();
//            Object value = file22.getValue();
//            if (!map.containsKey(key)) {
//                result.append(" + ").append(key).append(": ").append(value).append("\n");
//            }
//        }
//        result.append("}");
//        System.out.println(result);
//    }
//}