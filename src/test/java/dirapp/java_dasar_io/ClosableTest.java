package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClosableTest {
    // Semua IO stream di Java adalah turunan dari interface java.io.Closable
    // terdapat method close() untuk menutup Resource yang sudah di buka, agar tidak terjadi memory leak
    // karena jika tidak di close, data tidak bisa dihapus dari memory oleh Java Garbage Collector


    @Test
    void closeIO() {
        Path path = Path.of("pom.xml");
        InputStream inputStream = null;
        try {
            inputStream = Files.newInputStream(path);
            // lakukan apapun dengan input stream
        } catch (IOException exception){
            Assertions.fail(exception);
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Assertions.fail(e);
                }
            }
        }
    }


    // di java memiliki fitur tryWithResource
    // dengan menggunakan try with resource, tidak perlu menutup Resource Closable secara otomatis
    // contohnya seperti try untuk connect database, IO Stream, dll
    @Test
    void closeIOWithTryResource() {
        Path path = Path.of("pom.xml");
        try(InputStream inputStream = Files.newInputStream(path);
            InputStream inputStream2 = Files.newInputStream(path);
            InputStream inputStream3 = Files.newInputStream(path)) {
            // lakukan apapun dengan input stream
        } catch (IOException exception){
            Assertions.fail(exception);
        }
    }
}
