package hexlet.code;


import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<String> {
    private static String result = "";

    @Option(names = {"-f", "--format"}, defaultValue = "stylish", paramLabel = "format",
            description = "output format [default: stylish]")
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filePath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filePath2;


    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.out.println(result);
        System.exit(exitCode);
    }

    @Override
    public final String call() throws Exception {
        if (format.equals("stylish")) {
            result = Differ.generate(filePath1, filePath2);

        }
        result = Differ.generate(filePath1, filePath2, format);
        return null;
    }
}
