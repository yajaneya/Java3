package dz4.Task2;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileWriter out = new FileWriter("Task2.txt");
        out.write("Начало \n");
        out.flush();
        Thread t1 = new Thread(new WriteData(1, out));
        Thread t2 = new Thread(new WriteData(2, out));
        Thread t3 = new Thread(new WriteData(3, out));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        out.write("Конец");
        out.flush();
        out.close();
    }
}
