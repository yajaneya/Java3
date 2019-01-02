package dz4;

public class Task1 {

    private final Object let = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Task1 task = new Task1();
        Thread t1 = new Thread(()-> {
            task.printA();
        });
        Thread t2 = new Thread(()-> {
            task.printB();
        });
        Thread t3 = new Thread(()-> {task.printC();});
        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (let) {
            try {
                for (int i=0; i<5; i++) {
                    while (currentLetter != 'A') {
                        let.wait();
                    }
                    System.out.println("A");
                    currentLetter = 'B';
                    let.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void printB() {
        synchronized (let) {
            try {
                for (int i=0; i<5; i++) {
                    while (currentLetter != 'B') {
                        let.wait();
                    }
                    System.out.println("B");
                    currentLetter = 'C';
                    let.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       }
    }

    private void printC() {
        synchronized (let) {
            try {
                for (int i=0; i<5; i++) {
                    while (currentLetter != 'C') {
                        let.wait();
                    }
                    System.out.println("C");
                    currentLetter = 'A';
                    let.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
