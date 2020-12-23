public class TestCounter_2 {
    public static void main(String[] args) {
        SynchCounter_1 counter = new SynchCounter_1();//1) создали счетчик

        Thread incThread = new Thread(() -> {//2)создали первый поток,
            // который будет увеличивать счетчик
            for (int i = 0; i < 100; i++) {
                counter.inc();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread decThread = new Thread(() -> {//3)создали второй поток,
            // который будет уменьшать счетчик
            for (int i = 0; i < 100; i++) {
                counter.dec();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            incThread.start();
            decThread.start();
            incThread.join();
            decThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Значение счетчика: " + counter.value());
    }
}

