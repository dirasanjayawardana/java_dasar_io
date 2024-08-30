package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
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


  @Test
    void saveBufferToFile() {
        Path sourcePath = Path.of("image.png");  // Ganti dengan path file gambar sumber
        Path targetPath = Path.of("saved_buffer_image.png");  // Ganti dengan path file tujuan

        // ByteArrayOutputStream untuk menampung buffer yang berhasil dibaca
        ByteArrayOutputStream bufferStream = new ByteArrayOutputStream();

        try (InputStream inputStream = Files.newInputStream(sourcePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                // Menyimpan byte[] yang dibaca ke dalam ByteArrayOutputStream
                bufferStream.write(buffer, 0, bytesRead);
            }

            // Setelah semua buffer dibaca, tulis byte[] ke file lain
            try (OutputStream outputStream = Files.newOutputStream(targetPath)) {
                bufferStream.writeTo(outputStream);
            }

            System.out.println("Buffer berhasil disimpan ke " + targetPath.toString());

        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }


  @Test
  void saveBufferToFileAndDatabase() {
      Path sourcePath = Path.of("image.png");  // Ganti dengan path file gambar sumber
      Path targetPath = Path.of("saved_buffer_image.png");  // Ganti dengan path file tujuan
  
      ByteArrayOutputStream bufferStream = new ByteArrayOutputStream();
  
      try (InputStream inputStream = Files.newInputStream(sourcePath)) {
          byte[] buffer = new byte[1024];
          int bytesRead;
          while ((bytesRead = inputStream.read(buffer)) != -1) {
              bufferStream.write(buffer, 0, bytesRead);
          }
  
          // Simpan byte[] ke database
          saveToDatabase(bufferStream.toByteArray());
  
          System.out.println("Buffer berhasil disimpan ke " + targetPath.toString() + " dan database.");
  
      } catch (IOException exception) {
          Assertions.fail(exception);
      }
  }

  
  void saveToDatabase(byte[] imageData) {
      String url = "jdbc:mysql://localhost:3306/yourdatabase";  // Ganti dengan URL database Anda
      String username = "yourusername";  // Ganti dengan username database Anda
      String password = "yourpassword";  // Ganti dengan password database Anda
  
      String insertSQL = "INSERT INTO your_table_name (image_data) VALUES (?)";  // Ganti dengan nama tabel dan kolom Anda
  
      try (Connection connection = DriverManager.getConnection(url, username, password);
           PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
  
          preparedStatement.setBytes(1, imageData);
          int rowsAffected = preparedStatement.executeUpdate();
  
          if (rowsAffected > 0) {
              System.out.println("Image data berhasil disimpan ke database.");
          }
  
      } catch (SQLException e) {
          e.printStackTrace();
      }
}
}

