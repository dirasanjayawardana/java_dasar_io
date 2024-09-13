# Java IO (Input Output)
Merupakan fitur untuk berinteraksi dengan data diluar aplikasi yang dibangun.
Dengan Java IO, bisa dengan mudah membaca dan menyimpan data di file.

## Konsep Java IO
- Sumber data (resource).
Pada java 1.0 menggunakan `class File` di package `import java.io.File;`, sejak java 7.0 menggunakan `class Path` di package `import java.nio.file.Path`, nio (new io)

- IO Stream (untuk membaca atau menulis) terhadap sumber data (resource) tersebut.
Stream untuk karakter `Reader dan Writer `, stream untuk bytes atau numeric `InputStram` dan `OutputStream`

## Learning
- test/FileTest.java
- test/PathTest.java
- test/FileManipulationTest.java
- test/ClosableTest.java
- test/SmallFileTest.java
- test/InputStreamTest.java
- test/OutputsStreamTest.java
- test/ReaderTest.java
- test/WriterTest.java
- test/OpenOptionTest.java
- test/ObjectStreamTest.java
- test/MemoryStreamTest.java
- test/PrintStreamTest.java
- test/ScannerTest.java
- main/ScannerInputApp.java

## Running Task while Java Springboot Start Initialized
1. Menggunakan @PostConstruct
Anda dapat menulis kode yang ingin dieksekusi setelah bean diinisialisasi dengan anotasi @PostConstruct.

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoader {
    @Autowired
    private YourRepository yourRepository;

    @PostConstruct
    public void init() {
        // Query ke database
        yourRepository.findAll().forEach(System.out::println);
    }
}


2. Menggunakan CommandLineRunner
CommandLineRunner adalah interface yang disediakan Spring Boot untuk menjalankan kode setelah aplikasi diinisialisasi. Anda dapat menggunakannya untuk menjalankan query saat startup.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseQueryRunner implements CommandLineRunner {
    @Autowired
    private YourRepository yourRepository;

    @Override
    public void run(String... args) throws Exception {
        // Query ke database
        yourRepository.findAll().forEach(System.out::println);
    }
}

3. Menggunakan ApplicationRunner
ApplicationRunner mirip dengan CommandLineRunner, tetapi menerima ApplicationArguments yang lebih kaya untuk mengelola argumen aplikasi.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseQueryApplicationRunner implements ApplicationRunner {
    @Autowired
    private YourRepository yourRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Query ke database
        yourRepository.findAll().forEach(System.out::println);
    }
}
