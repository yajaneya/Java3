package dz3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

public class InOut {
    public static void main(String[] args) throws IOException {

        readFile(); // задание 1

        transpotFiles(); // задание 2


    }

    private static void transpotFiles() throws IOException {
        ArrayList<InputStream> in = new ArrayList<>();
        for (int i=1; i<=5; i++) {
            String nameFile = "scr\\dz3\\File"+i+".txt";
            in.add(new FileInputStream(nameFile));
        }
        Enumeration<InputStream> e = Collections.enumeration(in);
        SequenceInputStream seq = new SequenceInputStream(e);
        FileOutputStream out = new FileOutputStream("scr\\dz3\\Fileout.txt");
        int rb = seq.read();
        while (rb != -1) {
            out.write(rb);
            rb = seq.read();
        }
    }

    private static void readFile() throws IOException {
        int[] readFile = new int[50];
        FileInputStream in = null;
        try {
            in = new FileInputStream("scr\\dz3\\File.txt");
            for (int i = 0; i<readFile.length; i++) {
                readFile[i] = in.read();
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        } finally {
            in.close();
        }

        int el = 1;
        for (int b : readFile) {
            System.out.print(b+" ");
            if (el++%10 == 0) System.out.println();
        }
        System.out.println();
    }
}
