public class SynchStaticMethod_5 {
    //1) для статических методов в роли монитора выступает сам класс(SynchStaticMethod_5)
    //то ест у него тоже есть флажок занятый или свободен,
    //когда зашли в поток, например в метод classMethod1() то не можем зайти в другой метод в этом же классе в этот же время

    public static void main(String[] args) {
//2) у нас (вообще) один поток может вызвать синх. статик метод
// а другой поток нестатик синх. метод
        new Thread(() -> classMethod1()).start();
        new Thread(() -> classMethod2()).start();
    }

    public synchronized static void classMethod1() {
        System.out.println("static synch method1 start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("static synch method1 End");
    }

    public synchronized static void classMethod2() {
        System.out.println("static synch method2 start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("static synch method2 End");
    }
}

