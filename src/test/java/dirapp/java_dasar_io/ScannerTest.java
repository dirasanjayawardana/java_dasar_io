package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ScannerTest {
  // Scanner digunakan untuk membaca input dari InputStream
  // method dengan awalan next() digunakan untuk membaca data
  // method dengan awalan has() digunakan untuk mengecek apakah masih ada data

  @Test
  void scanner() {
    Path path = Path.of("print.txt");
    try (InputStream stream = Files.newInputStream(path);
        Scanner scanner = new Scanner(stream)) {

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println(line);
      }

    } catch (IOException exception) {
      Assertions.fail(exception);
    }
  }


  void scannerInTerminal() {
    try (Scanner scanner = new Scanner(System.in)) {
      
      System.out.println("INPUT: ");
      String input = scanner.nextLine();

      System.out.println("INPUT ADALAH : " + input);

      // while (true) {
      //   String input = scanner.nextLine();
      //   if (input.equals("q")) {
      //     break;
      //   }
      // }
    }

  }
}