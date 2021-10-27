import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDiffer {


    public static String getFilePathToString(String file) {
        return Paths.get("src/test/resources/fixtures/" + file).toAbsolutePath()
                .normalize()
                .toString();
    }

    public static String readFile(String file) throws IOException {
        Path path = Paths.get(getFilePathToString(file));
        return Files.readString(path).trim();
    }


    @Test
    public void differTestJson() throws IOException {
        Assertions.assertEquals(readFile("result_file1_file2_stylish.txt"),
                Differ.generate(getFilePathToString("file1.json"), getFilePathToString("file2.json")));
        Assertions.assertEquals(readFile("result_file1_file2_stylish.txt"),
                Differ.generate(getFilePathToString("file1.json"), getFilePathToString("file2.json"),
                        "stylish"));
        Assertions.assertEquals(readFile("result_file1_file2_plain.txt"),
                Differ.generate(getFilePathToString("file1.json"), getFilePathToString("file2.json"), "plain"));
        Assertions.assertEquals(readFile("result_file1_file2_json.txt"),
                Differ.generate(getFilePathToString("file1.json"), getFilePathToString("file2.json"), "json"));
        Assertions.assertEquals(readFile("result_file3_file4_stylish.txt"),
                Differ.generate(getFilePathToString("file3.json"), getFilePathToString("file4.json")));
        Assertions.assertEquals(readFile("result_file3_file4_stylish.txt"),
                Differ.generate(getFilePathToString("file3.json"), getFilePathToString("file4.json"),
                        "stylish"));
        Assertions.assertEquals(readFile("result_file3_file4_plain.txt"),
                Differ.generate(getFilePathToString("file3.json"), getFilePathToString("file4.json"), "plain"));
        Assertions.assertEquals(readFile("result_file3_file4_json.txt"),
                Differ.generate(getFilePathToString("file3.json"), getFilePathToString("file4.json"), "json"));
        Assertions.assertEquals(readFile("result_file5_file6_stylish.txt"),
                Differ.generate(getFilePathToString("file5.json"), getFilePathToString("file6.json")));
        Assertions.assertEquals(readFile("result_file5_file6_stylish.txt"),
                Differ.generate(getFilePathToString("file5.json"), getFilePathToString("file6.json"), "stylish"));
        Assertions.assertEquals(readFile("result_file5_file6_plain.txt"),
                Differ.generate(getFilePathToString("file5.json"), getFilePathToString("file6.json"), "plain"));
        Assertions.assertEquals(readFile("result_file5_file6_json.txt"),
                Differ.generate(getFilePathToString("file5.json"), getFilePathToString("file6.json"), "json"));
    }

    @Test
    public void differTestYml() throws IOException {
        Assertions.assertEquals(readFile("result_file1_file2_stylish.txt"),
                Differ.generate(getFilePathToString("file1.yml"), getFilePathToString("file2.yml")));
        Assertions.assertEquals(readFile("result_file1_file2_stylish.txt"),
                Differ.generate(getFilePathToString("file1.yml"), getFilePathToString("file2.yml"), "stylish"));
        Assertions.assertEquals(readFile("result_file1_file2_plain.txt"),
                Differ.generate(getFilePathToString("file1.yml"), getFilePathToString("file2.yml"), "plain"));
        Assertions.assertEquals(readFile("result_file1_file2_json.txt"),
                Differ.generate(getFilePathToString("file1.yml"), getFilePathToString("file2.yml"), "json"));
        Assertions.assertEquals(readFile("result_file3_file4_stylish.txt"),
                Differ.generate(getFilePathToString("file3.yml"), getFilePathToString("file4.yml")));
        Assertions.assertEquals(readFile("result_file3_file4_stylish.txt"),
                Differ.generate(getFilePathToString("file3.yml"), getFilePathToString("file4.yml"), "stylish"));
        Assertions.assertEquals(readFile("result_file3_file4_plain.txt"),
                Differ.generate(getFilePathToString("file3.yml"), getFilePathToString("file4.yml"), "plain"));
        Assertions.assertEquals(readFile("result_file3_file4_json.txt"),
                Differ.generate(getFilePathToString("file3.yml"), getFilePathToString("file4.yml"), "json"));
        Assertions.assertEquals(readFile("result_file5_file6_stylish.txt"),
                Differ.generate(getFilePathToString("file5.yml"), getFilePathToString("file6.yml")));
        Assertions.assertEquals(readFile("result_file5_file6_stylish.txt"),
                Differ.generate(getFilePathToString("file5.yml"), getFilePathToString("file6.yml"), "stylish"));
        Assertions.assertEquals(readFile("result_file5_file6_plain.txt"),
                Differ.generate(getFilePathToString("file5.yml"), getFilePathToString("file6.yml"), "plain"));
        Assertions.assertEquals(readFile("result_file5_file6_json.txt"),
                Differ.generate(getFilePathToString("file5.yml"), getFilePathToString("file6.yml"), "json"));
    }
}
