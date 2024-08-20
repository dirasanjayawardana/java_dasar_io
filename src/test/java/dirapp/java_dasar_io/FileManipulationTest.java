package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManipulationTest {
    // ketika membuat Path atau File, bukan berarti langsung membuat file, hanya membuat object Path atau object File saja
    // untuk melakukan manipulasi file menggunakan
    // Files.createFile(path) --> membuat file
    // Files.delete(path) / Files.deleteIfExist(path) --> menghapus file / jika ada
    // Files.copy(source, target) --> menyalin file
    // Files.move(source, target) --> memindahkan file
    // Files.createDirectory(path) --> membuat satu folder
    // Files.createDirectories(path) --> membuat banyak jika tidak ada folder
    // Files.newDirectoryStream(path) --> membaca semua isi file di directory
    // Files.isDirectory(path) --> mengecek sebuah path apakah sebuah directory


    @Test
    void fileManipulation() throws IOException {
        Path path = Path.of("file.txt");
        Files.createFile(path);
        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }


    @Test
    void directoryManipulation() throws IOException {
        Path path = Path.of("contoh");
        Files.createDirectory(path);
        Assertions.assertTrue(Files.isDirectory(path));
        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }
}