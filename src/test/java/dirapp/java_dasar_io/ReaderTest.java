package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderTest {
  // Reader adalah Input Stream untuk membaca resource berupa text
  // dengan menggunakan Reader, bisa melakukan konversi otomatis dari numeric ke character
  // read() --> untuk membaca data per character
  // read(char[length]) --> untuk membaca langsung beberapa karakter


  @Test
  void read() {
    Path path = Path.of("output.txt");

    try (Reader reader = Files.newBufferedReader(path)) {
      StringBuilder builder = new StringBuilder();
      int character;
      int counter = 0;

      while ((character = reader.read()) != -1) {
        builder.append((char) character);
        counter++;
      }

      System.out.println(builder.toString());
      System.out.println(counter);
    } catch (IOException e) {
      Assertions.fail(e);
    }
  }


  @Test
  void readChars() {
    Path path = Path.of("output.txt");

    try (Reader reader = Files.newBufferedReader(path)) {
      StringBuilder builder = new StringBuilder();
      char[] chars = new char[1024];
      int length;
      int counter = 0;

      // stream.read(chars) --> Method ini membaca data dari file output.txt dan mengisinya ke dalam array chars. Ukuran data yang dibaca bergantung pada berapa banyak char yang tersedia untuk dibaca dan kapasitas array chars (1024 byte dalam kasus ini).
      while ((length = reader.read(chars)) != -1) {
        builder.append(chars, 0, length);
        counter++;
      }

      System.out.println(builder.toString());
      System.out.println(counter);

    } catch (IOException e) {
      Assertions.fail(e);
    }
  }
}