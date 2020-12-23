

public class ThreadAPP_3_Methods {
    public static void main(String[] args) throws InterruptedException {
        Thread tr1 = new Thread(() ->{
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        });

        Thread tr2 = new Thread(()-> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
        });
        tr1.setDaemon(true);
        tr1.start();
        tr2.start();
        tr1.join();
        tr2.join();
        System.out.println("End");
    }
}
