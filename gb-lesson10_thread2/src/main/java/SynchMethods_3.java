public class SynchMethods_3 {

    //1)если мы метод пометили как synchronized то в РОЛИ монитора будет выступать
    //объект на которой мы вызвали этот метод
    public static void main(String[] args) {
        SynchMethods_3 e1 = new SynchMethods_3();
        SynchMethods_3 e2 = new SynchMethods_3();
        Thread t1 = new Thread(()->e1.method1());
        Thread t2 = new Thread(()->e1.methiod2());
        t1.start();
        t2.start();//2) мы вызвали синх. методы в разных потоках у одного и того же объекта
// поток захватил (заблокировал) объект(е1) и работает с ним и второй поток увидел
        //что наш объект (в роли монитора) занят и ничего не может пока объект(е1)
        //в роли монитора не освободится
    }

    public synchronized void method1(){
        System.out.println("method1 Start ");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("method1 END");
    }
    public synchronized void methiod2(){
        System.out.println("method2 Start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("method2 END");
    }
}

