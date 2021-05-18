package dz3;

/**
 *  Задание № 3
 */

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadText {

    public static void main(String[] args) throws IOException {

        initilize();

        Scanner sc = new Scanner(System.in);
        int page=0;
        page = getNumPage(sc);
        while (page != 0) {
            PrintPage(page);
            page = getNumPage(sc);
        }
    }

    private static void printPage(int page) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("FileManyPage.txt", "r");
        raf.seek(2*(page-1)*1800);
        for (int i=1; i<=1800; i++) {
            try {
                System.out.print(raf.readChar());
            } catch (EOFException e) {
                System.out.println("Нет такой страницы");
                raf.close();
                return;
            }
            if (i%200==0) System.out.println();
        }
        raf.close();
    }

    private static int getNumPage(Scanner sc) {
        int page=-1;
        try {
            System.out.println("Введите номер страницы:");
            page = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введено не число.");
            page=0;
        } finally {
            return page;
        }
    }

    private static void initilize() throws IOException {
        System.out.println("Идёт создание файла. Подождите...");
        DataOutputStream out = new DataOutputStream(new FileOutputStream("FileManyPage.txt"));
        for (int k=1; k<100; k++) {
            for (char i=65; i<=94; i++) {
                for (int j=1; j<=1800; j++) {
                    out.writeChar(i);
                }
            }
        }
        System.out.println("Файл на 2970 страниц создан!");
        System.out.println();
    }
}
