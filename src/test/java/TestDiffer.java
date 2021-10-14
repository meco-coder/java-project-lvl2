import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDiffer {
    private static String stringResultFile1File2Stylish;
    private static String stringResultFile3File4Stylish;
    private static String stringResultFile5File6Stylish;
    private static String stringResultFile1File2Plain;
    private static String stringResultFile3File4Plain;
    private static String stringResultFile5File6Plain;
    private static String stringResultFile1File2Json;
    private static String stringResultFile3File4Json;
    private static String stringResultFile5File6Json;

    @BeforeAll
    public static void inputTest() throws IOException {
        Path pathResult = Paths.get("src", "test", "resources", "fixtures", "result_file1_file2_stylish.txt")
                .toAbsolutePath()
                .normalize();
        stringResultFile1File2Stylish = Files.readString(pathResult).trim();
        Path filePath1 = Paths.get("src", "test", "resources", "fixtures", "result_file3_file4_stylish.txt")
                .toAbsolutePath()
                .normalize();
        stringResultFile3File4Stylish = Files.readString(filePath1).trim();
        Path filePath2 = Paths.get("src", "test", "resources", "fixtures", "result_file5_file6_stylish.txt")
                .toAbsolutePath()
                .normalize();
        stringResultFile5File6Stylish = Files.readString(filePath2).trim();

        Path filePath3 = Paths.get("src", "test", "resources", "fixtures", "result_file1_file2_plain.txt")
                .toAbsolutePath()
                .normalize();
        stringResultFile1File2Plain = Files.readString(filePath3).trim();
        Path filePath4 = Paths.get("src", "test", "resources", "fixtures", "result_file3_file4_plain.txt")
                .toAbsolutePath()
                .normalize();
        stringResultFile3File4Plain = Files.readString(filePath4).trim();
        Path filePath5 = Paths.get("src", "test", "resources", "fixtures", "result_file5_file6_plain.txt")
                .toAbsolutePath()
                .normalize();
        stringResultFile5File6Plain = Files.readString(filePath5).trim();
        Path filePath6 = Paths.get("src", "test", "resources", "fixtures", "result_file1_file2_json.txt")
                .toAbsolutePath()
                .normalize();
        stringResultFile1File2Json = Files.readString(filePath6).trim();
        Path filePath7 = Paths.get("src", "test", "resources", "fixtures", "result_file3_file4_json.txt")
                .toAbsolutePath()
                .normalize();
        stringResultFile3File4Json = Files.readString(filePath7).trim();
        Path filePath8 = Paths.get("src", "test", "resources", "fixtures", "result_file5_file6_json.txt")
                .toAbsolutePath()
                .normalize();
        stringResultFile5File6Json = Files.readString(filePath8).trim();

    }

    @Test
    public void differTestJson() throws IOException {
        Assertions.assertEquals(stringResultFile1File2Stylish, Differ.generate("file1.json", "file2.json"));
        Assertions.assertEquals(stringResultFile1File2Stylish, Differ.generate("file1.json", "file2.json", "stylish"));
        Assertions.assertEquals(stringResultFile1File2Plain, Differ.generate("file1.json", "file2.json", "plain"));
        Assertions.assertEquals(stringResultFile1File2Json, Differ.generate("file1.json", "file2.json", "json"));
        Assertions.assertEquals(stringResultFile3File4Stylish, Differ.generate("file3.json", "file4.json"));
        Assertions.assertEquals(stringResultFile3File4Stylish, Differ.generate("file3.json", "file4.json", "stylish"));
        Assertions.assertEquals(stringResultFile3File4Plain, Differ.generate("file3.json", "file4.json", "plain"));
        Assertions.assertEquals(stringResultFile3File4Json, Differ.generate("file3.json", "file4.json", "json"));
        Assertions.assertEquals(stringResultFile5File6Stylish, Differ.generate("file5.json", "file6.json"));
        Assertions.assertEquals(stringResultFile5File6Stylish, Differ.generate("file5.json", "file6.json", "stylish"));
        Assertions.assertEquals(stringResultFile5File6Plain, Differ.generate("file5.json", "file6.json", "plain"));
        Assertions.assertEquals(stringResultFile5File6Json, Differ.generate("file5.json", "file6.json", "json"));
    }

    @Test
    public void differTestYml() throws IOException {
        Assertions.assertEquals(stringResultFile1File2Stylish, Differ.generate("file1.yml", "file2.yml"));
        Assertions.assertEquals(stringResultFile1File2Stylish, Differ.generate("file1.yml", "file2.yml", "stylish"));
        Assertions.assertEquals(stringResultFile1File2Plain, Differ.generate("file1.yml", "file2.yml", "plain"));
        Assertions.assertEquals(stringResultFile1File2Json, Differ.generate("file1.yml", "file2.yml", "json"));
        Assertions.assertEquals(stringResultFile3File4Stylish, Differ.generate("file3.yml", "file4.yml"));
        Assertions.assertEquals(stringResultFile3File4Stylish, Differ.generate("file3.yml", "file4.yml", "stylish"));
        Assertions.assertEquals(stringResultFile3File4Plain, Differ.generate("file3.yml", "file4.yml", "plain"));
        Assertions.assertEquals(stringResultFile3File4Json, Differ.generate("file3.yml", "file4.yml", "json"));
        Assertions.assertEquals(stringResultFile5File6Stylish, Differ.generate("file5.yml", "file6.yml"));
        Assertions.assertEquals(stringResultFile5File6Stylish, Differ.generate("file5.yml", "file6.yml", "stylish"));
        Assertions.assertEquals(stringResultFile5File6Plain, Differ.generate("file5.yml", "file6.yml", "plain"));
        Assertions.assertEquals(stringResultFile5File6Json, Differ.generate("file5.yml", "file6.yml", "json"));
    }
}
