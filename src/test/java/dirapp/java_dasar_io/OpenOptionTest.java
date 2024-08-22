package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenOptionTest {
  // ketika membuat IO Stream, terdapat parameter tambahan yaitu OpenOption
  // OpenOption merupakan opsi tambahan yg ingin dilakukan pada proses IO Stream
  // OpenOption merupakan interface, umtuk implementasinya menggunakan enum StandardOpenOption

  @Test
  void append() {
    Path path = Path.of("append.txt");

    // StandardOpenOption.CREATE --> akan membuat file baru jika tidak ada
    // StandardOpenOption.APPEND --> akan menulis file diakhir baris dan akan terus bertambah tanpa menghapus isi sebelumnya
    try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

      writer.write("Hello World\n");
      writer.flush();

    } catch (IOException exception) {
      Assertions.fail(exception);
    }
  }
}