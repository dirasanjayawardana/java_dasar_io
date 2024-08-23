package dirapp.java_dasar_io;

import java.util.Scanner;

public class ScannerInputApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();
        System.out.println("Halo " + name);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
        }

        scanner.close();
    }
}