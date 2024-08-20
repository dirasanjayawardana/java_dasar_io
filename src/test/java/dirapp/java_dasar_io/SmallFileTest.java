package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SmallFileTest {
    // untuk menulis file dengan ukuran kecil bisa menggunakan class Files
    // cara ini tidak disarankan untuk menulis file berukuran besar, karena isi file dikirimkan ke parameter, sehingga akan memakan memory yang besar
    // Files.write(path, bytes) --> untuk menulis file dengan data bytes[]
    // Files.write(path, string) --> untuk menulis file dengan data String
    // Files.readAllBytes(path) --> untuk membaca file menjadi data bytes[]
    // Files.readString(path) --> untuk membaca file menjadi data String


    @Test
    void writeSmallFile() throws IOException {
        Path path1 = Path.of("small1.txt");
        byte[] bytes = "Hello World".getBytes();
        Files.write(path1, bytes);
        Assertions.assertTrue(Files.exists(path1));

        Path path2 = Path.of("small2.txt");
        Files.writeString(path2, "Hello World");
        Assertions.assertTrue(Files.exists(path2));
    }


    @Test
    void readSmallFile() throws IOException {
        Path path1 = Path.of("small1.txt");
        byte[] bytes = Files.readAllBytes(path1);
        String content1 = new String(bytes);
        Assertions.assertEquals("Hello World", content1);

        Path path2 = Path.of("small2.txt");
        String content2 = Files.readString(path2);
        Assertions.assertEquals("Hello World", content2);
    }
}