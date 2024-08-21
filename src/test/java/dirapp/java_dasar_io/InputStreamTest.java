package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputStreamTest {
  // InputStream merupakan base interface untuk membaca Resource, menggunakan numeric data
  // jika ingin membaca text, maka harus konversi ke data numeric terlebih dahulu
  // InputStream cocok untuk membaca data non Text, seperti gambar, vidio, dll
  // stream.read() --> setiap karakter dibaca satu persatu, per satu byte
  // stream.read(bytes) --> karakter dibaca per size bytes, tidak satu persatu, sehingga lebih efisien
  // method read() akan return -1 jika sudah tidak ada data yg bisa dibaca lagi


  @Test
  void read() {
    Path path = Path.of("pom.xml");
    try (InputStream stream = Files.newInputStream(path)) {
      StringBuilder builder = new StringBuilder();
      int data;
      int counter = 0;

      // stream.read() --> setiap karakter dibaca satu persatu, per satu byte, kemudian dimasukkan ke dalam builder
      // method read() akan return -1 jika sudah tidak ada data yg bisa dibaca lagi
      while ((data = stream.read()) != -1) {
        builder.append((char) data);
        counter++;
      }

      System.out.println(builder.toString());
      System.out.println(counter);
    } catch (IOException exception) {
      Assertions.fail(exception);
    }
  }


  @Test
  void readBytes() {
    Path path = Path.of("pom.xml");
    try (InputStream stream = Files.newInputStream(path)) {
      StringBuilder builder = new StringBuilder();
      byte[] bytes = new byte[1024];
      int length;
      int counter = 0;
      
      // stream.read(bytes) --> Method ini membaca data dari file pom.xml dan mengisinya ke dalam array bytes. Ukuran data yang dibaca bergantung pada berapa banyak byte yang tersedia untuk dibaca dan kapasitas array bytes (1024 byte dalam kasus ini).
      // stream.read(bytes) membaca data ke dalam array byte dan mengembalikan jumlah byte yang dibaca.
      // Jika stream.read() mengembalikan -1, berarti tidak ada data lagi yang bisa dibaca.
      while ((length = stream.read(bytes)) != -1) {
          builder.append(new String(bytes, 0, length));
          counter++;  
      }

      System.out.println(builder.toString());
      System.out.println(counter);
    } catch (IOException exception) {
      Assertions.fail(exception);
    }
  }
}

