package dirapp.java_dasar_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputStreamTest {
    // OutpuStream meruapakan base interface untuk menulis ke Resource
    // OutputStream menggunakan numeric data, disarankan untuk non Text
    // method flush() digunakan untuk memaksa OutputStream menyimpan data secara permanen ke target Resource meski belum melakukan close() pada OutputStream

    @Test
    void outputStream() {
        Path path = Path.of("output.txt");
        
        try(OutputStream stream = Files.newOutputStream(path)){
            for (int i = 0; i < 100; i++) {
                stream.write("Hello World\n".getBytes());
                stream.flush();
            }
        } catch (IOException exception){
            Assertions.fail(exception);
        }
    }
}
