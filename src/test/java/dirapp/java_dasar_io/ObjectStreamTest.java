package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectStreamTest {
  // saat membuat program java, sering membuat java bean (class dengan getter dan setter)
  // jika ingin menyimpan data object ke file, jika menggunakan Input/Ouput Stream, maka cukup kompleks
  // ObjectStream digunakna untuk menyimpan atau membaca data java Object dari file
  // class nya harus turunan dari serializable, wajib menambahkan "field public static final long serialVersionUID"


  @Test
  void savePerson() {
    Person person = new Person();
    person.setId("1");
    person.setName("Dira");

    Path path = Path.of("dira.person");

    try (OutputStream stream = Files.newOutputStream(path);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream)) {

      objectOutputStream.writeObject(person);
      objectOutputStream.flush();

    } catch (IOException exception) {
      Assertions.fail(exception);
    }
  }


  @Test
  void getPerson() {
    Path path = Path.of("dira.person");

    try (InputStream stream = Files.newInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(stream)) {

      Person person = (Person) objectInputStream.readObject();

      Assertions.assertEquals("1", person.getId());
      Assertions.assertEquals("Dira", person.getName());

    } catch (IOException | ClassNotFoundException exception) {
      Assertions.fail(exception);
    }
  }
}