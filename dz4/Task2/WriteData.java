package dz4.Task2;

import java.io.*;


public class WriteData implements Runnable {
    private Object lock = new Object();
    private int flow;
    private FileWriter out;

    public WriteData(int flow, FileWriter out) {
        this.flow = flow;
        this.out = out;
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<10; i++) {
                synchronized (lock) {
                    out.write("Строка " + i + " потока " + flow + "\n");
                    out.flush();
                }
                Thread.sleep(20);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
