package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileTest {
    // class File digunakan untuk mengakses file (cara lama, sejak java 1.0, cara baru menggunakan class Path)
    // new File("path/lokasi/file.ext") --> untuk membuat object File dari file yang sudah ada, bukan membuat file baru
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
  void createFile() {
    File file = new File("file.txt");

    Assertions.assertEquals("file.txt", file.getName());
    Assertions.assertFalse(file.exists()); // cek apakah file.txt ada
  }


  @Test
  void createFileExists() {
    File file = new File("src/main/resources/application.properties");

    Assertions.assertEquals("application.properties", file.getName());
    Assertions.assertTrue(file.exists());
  }
}