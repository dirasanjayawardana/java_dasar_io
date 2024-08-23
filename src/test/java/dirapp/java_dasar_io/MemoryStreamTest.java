package dirapp.java_dasar_io;

import org.junit.jupiter.api.Test;

import java.io.StringWriter;

public class MemoryStreamTest {
  // Memory Stream digunakan untuk membuat IO Stream dengan target resource di variabel di memory
  // ByteArrayOutputStream --> turunan dari OutputStram, untuk menyimpan data di byte[] di memory
  // ByteArrayInputStream --> turunan InputStream, untuk mengambil data byte[]
  // StringWriter --> turunan Writer, untuk menyimpan data String
  // StringReader --> turunan Reader, untuk mengambil data String

  @Test
  void memoryStream() {
    StringWriter writer = new StringWriter();

    for (int i = 0; i < 10; i++) {
      writer.write("Hello World\n");
    }

    String content = writer.getBuffer().toString();
    System.out.println(content);
  }
}