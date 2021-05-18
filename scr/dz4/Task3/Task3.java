package dz4.Task3;

public class Task3 {
    public static void main(String[] args) {

        MFU mfu = new MFU();

        getThreadPrint(mfu, 30).start();
        getThreadScan(mfu, 30).start();
        getThreadPrint(mfu, 20).start();
        getThreadPrint(mfu, 10).start();
        getThreadScan(mfu, 30).start();
        getThreadPrint(mfu, 20).start();
        getThreadScan(mfu, 10).start();
        getThreadScan(mfu, 5).start();

    }

    private static Thread getThreadScan(MFU mfu, int pages) {
        return new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i<pages; i++){
                        try {
                            mfu.scan();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
    }

    private static Thread getThreadPrint(MFU mfu, int pages) {
        return new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i<pages; i++){
                        try {
                            mfu.print();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
    }
}
