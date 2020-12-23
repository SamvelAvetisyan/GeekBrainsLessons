//1)правило: несколько потоков в один момент времени не могут захватить один и тот же монитор, но могут захватить разные мониторы
//2) есть 3 варианта синх по монитору, (3 варианта что может выступать в роли монитора)
//2-1) внешний объект java Object
//2-2) объект у которого вызываем синх. метод
//2-3) класс
public class ChairsApp_6 {
    public static void main(String[] args) throws Exception {
        Object стул1 = new Object();
        Object стул2 = new Object();

        Thread человек1 = new Thread(() -> {
            System.out.println("Чел1 подошел к стулу1");
            synchronized (стул1) {
                System.out.println("Чел1 сел на стул1");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Чел1 встал со стула1");
            }
        });
        человек1.start();

        Thread человек2 = new Thread(() -> {
            System.out.println("Чел2 подошел к стулу1");
            synchronized (стул1) {
                System.out.println("Чел2 сел на стул1");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Чел2 встал со стула1");
            }
        });
        человек2.start();

        Thread человек3 = new Thread(() -> {
            System.out.println("Чел3 подошел к стулу1");
            synchronized (стул1) {
                System.out.println("Чел3 сел на стул1");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Чел3 встал со стула1");
            }
        });
        человек3.start();

        Thread человек4 = new Thread(() -> {
            System.out.println("Чел4 подошел к стулу2");
            synchronized (стул2) {
                System.out.println("Чел4 сел на стул2");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Чел4 встал со стула2");
            }
        });
        человек4.start();
    }
}
