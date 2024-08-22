package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterTest {
  // Writer meruapakan base interface untuk menulis ke Resource untuk data text
  // method flush() digunakan untuk memaksa Writer menyimpan data secara permanen ke target Resource meski belum melakukan close() pada Writer

  @Test
  void writer() {
    Path path = Path.of("writer.txt");

    try (Writer writer = Files.newBufferedWriter(path)) {
      for (int i = 0; i < 100; i++) {
        writer.write("Hello World\n");
        writer.flush();
      }

    } catch (IOException exception) {
      Assertions.fail(exception);
    }
  }
}