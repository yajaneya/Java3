package dz4.Task3;

public class MFU {

    private Object lockpr, locksc;
    private int pagepr, pagesc;
    private long startTime;

    public MFU() {
        this.lockpr = new Object();
        this.locksc = new Object();
        this.pagepr = 0;
        this.pagesc = 0;
        startTime = System.currentTimeMillis();
    }

    public void print () throws InterruptedException {
        synchronized (lockpr) {
            String msg="Отпечатано " + countPages(++pagepr);
            if ((System.currentTimeMillis()-startTime)>=50) {
                System.out.println(Thread.currentThread().getName()+" поток. "+msg);
                startTime = System.currentTimeMillis();
            }
            Thread.sleep(10); // время печати
        }
    }

    public void scan () throws InterruptedException {
        synchronized (locksc) {
            String msg = "Отсканировано " + countPages(++pagesc);
            if ((System.currentTimeMillis()-startTime)>=50) {
                System.out.println(Thread.currentThread().getName()+" поток. "+msg);
                startTime=System.currentTimeMillis();
            }
            Thread.sleep(10); // время сканирования
        }
    }

    private String countPages (int pages) {
        String s = "";
        for (int i=1; i<pages; i++) {
            s += i + ", ";
        }
        s += pages;
        return s;
    }

}
