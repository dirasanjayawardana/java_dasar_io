package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathTest {
    // sejak java 7.0, class Path bisa digunakan untuk mengakses resource, sebagai pengganti class File
    // Path adalah interface, untuk membuat Path menggunakan static method Path.of("pathName")
    // bisa menggunakan absolute atau relative pathName
    // absolute --> menyebutkan file dari posisi folder awal (D:\Programming\java\file.txt)
    // relative --> menyebutkan file dari posisi saat menjalankan aplikasinya (../resources/file.txt)

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
    void createPath() {
        Path path = Path.of("file.txt");

        Assertions.assertEquals("file.txt", path.toString());
        Assertions.assertFalse(path.isAbsolute());
    }


    // class Files digunakan untuk mendapatkan informasi dari Path
    @Test
    void usingFiles() {
        Path path = Path.of("pom.xml");

        Assertions.assertEquals("pom.xml", path.toString());
        Assertions.assertFalse(path.isAbsolute());
        Assertions.assertTrue(Files.exists(path));
    }
}
