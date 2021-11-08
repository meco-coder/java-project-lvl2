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
        String expected1 = readFile("result_file1_file2_stylish.txt");
        String actual1 = Differ.generate(getFilePathToString("file1.json"), getFilePathToString("file2.json"));
        Assertions.assertEquals(expected1, actual1);

        String expected2 = readFile("result_file1_file2_stylish.txt");
        String actual2 = Differ.generate(getFilePathToString("file1.json"), getFilePathToString("file2.json"),
                "stylish");
        Assertions.assertEquals(expected2, actual2);

        String expected3 = readFile("result_file1_file2_plain.txt");
        String actual3 = Differ.generate(getFilePathToString("file1.json"), getFilePathToString("file2.json"),
                "plain");
        Assertions.assertEquals(expected3, actual3);

        String expected4 = readFile("result_file1_file2_json.txt");
        String actual4 = Differ.generate(getFilePathToString("file1.json"), getFilePathToString("file2.json"),
                "json");
        Assertions.assertEquals(expected4, actual4);

        String expected5 = readFile("result_file3_file4_stylish.txt");
        String actual5 = Differ.generate(getFilePathToString("file3.json"), getFilePathToString("file4.json"));
        Assertions.assertEquals(expected5, actual5);

        String expected6 = readFile("result_file3_file4_stylish.txt");
        String actual6 = Differ.generate(getFilePathToString("file3.json"), getFilePathToString("file4.json"),
                "stylish");
        Assertions.assertEquals(expected6, actual6);

        String expected7 = readFile("result_file3_file4_plain.txt");
        String actual7 = Differ.generate(getFilePathToString("file3.json"), getFilePathToString("file4.json"),
                "plain");
        Assertions.assertEquals(expected7, actual7);

        String expected8 = readFile("result_file3_file4_json.txt");
        String actual8 = Differ.generate(getFilePathToString("file3.json"), getFilePathToString("file4.json"),
                "json");
        Assertions.assertEquals(expected8, actual8);

        String expected9 = readFile("result_file5_file6_stylish.txt");
        String actual9 = Differ.generate(getFilePathToString("file5.json"), getFilePathToString("file6.json"));
        Assertions.assertEquals(expected9, actual9);

        String expected10 = readFile("result_file5_file6_stylish.txt");
        String actual10 = Differ.generate(getFilePathToString("file5.json"), getFilePathToString("file6.json"),
                "stylish");
        Assertions.assertEquals(expected10, actual10);

        String expected11 = readFile("result_file5_file6_plain.txt");
        String actual11 = Differ.generate(getFilePathToString("file5.json"), getFilePathToString("file6.json"),
                "plain");
        Assertions.assertEquals(expected11, actual11);

        String expected12 = readFile("result_file5_file6_json.txt");
        String actual12 = Differ.generate(getFilePathToString("file5.json"), getFilePathToString("file6.json"),
                "json");
        Assertions.assertEquals(expected12, actual12);
    }

    @Test
    public void differTestYml() throws IOException {
        String expected1 = readFile("result_file1_file2_stylish.txt");
        String actual1 = Differ.generate(getFilePathToString("file1.yml"), getFilePathToString("file2.yml"));
        Assertions.assertEquals(expected1, actual1);

        String expected2 = readFile("result_file1_file2_stylish.txt");
        String actual2 = Differ.generate(getFilePathToString("file1.yml"), getFilePathToString("file2.yml"),
                "stylish");
        Assertions.assertEquals(expected2, actual2);

        String expected3 = readFile("result_file1_file2_plain.txt");
        String actual3 = Differ.generate(getFilePathToString("file1.yml"), getFilePathToString("file2.yml"),
                "plain");
        Assertions.assertEquals(expected3, actual3);

        String expected4 = readFile("result_file1_file2_json.txt");
        String actual4 = Differ.generate(getFilePathToString("file1.yml"), getFilePathToString("file2.yml"),
                "json");
        Assertions.assertEquals(expected4, actual4);

        String expected5 = readFile("result_file3_file4_stylish.txt");
        String actual5 = Differ.generate(getFilePathToString("file3.yml"), getFilePathToString("file4.yml"));
        Assertions.assertEquals(expected5, actual5);

        String expected6 = readFile("result_file3_file4_stylish.txt");
        String actual6 = Differ.generate(getFilePathToString("file3.yml"), getFilePathToString("file4.yml"),
                "stylish");
        Assertions.assertEquals(expected6, actual6);

        String expected7 = readFile("result_file3_file4_plain.txt");
        String actual7 = Differ.generate(getFilePathToString("file3.yml"), getFilePathToString("file4.yml"),
                "plain");
        Assertions.assertEquals(expected7, actual7);

        String expected8 = readFile("result_file3_file4_json.txt");
        String actual8 = Differ.generate(getFilePathToString("file3.yml"), getFilePathToString("file4.yml"),
                "json");
        Assertions.assertEquals(expected8, actual8);

        String expected9 = readFile("result_file5_file6_stylish.txt");
        String actual9 = Differ.generate(getFilePathToString("file5.yml"), getFilePathToString("file6.yml"));
        Assertions.assertEquals(expected9, actual9);

        String expected10 = readFile("result_file5_file6_stylish.txt");
        String actual10 = Differ.generate(getFilePathToString("file5.yml"), getFilePathToString("file6.yml"),
                "stylish");
        Assertions.assertEquals(expected10, actual10);

        String expected11 = readFile("result_file5_file6_plain.txt");
        String actual11 = Differ.generate(getFilePathToString("file5.yml"), getFilePathToString("file6.yml"),
                "plain");
        Assertions.assertEquals(expected11, actual11);

        String expected12 = readFile("result_file5_file6_json.txt");
        String actual12 = Differ.generate(getFilePathToString("file5.yml"), getFilePathToString("file6.yml"),
                "json");
        Assertions.assertEquals(expected12, actual12);
    }
}
