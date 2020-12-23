public class SynchMonitor_4 {
//1)есть возможность объявить внешний монитор, самый обычный Джава объект
//    //он в коде будет в роли монитора
   private Object monitor = new Object();

    public static void main(String[] args) {
        SynchMonitor_4 e = new SynchMonitor_4();
        new Thread(()->e.method()).start();
        new Thread(()->e.method()).start();
        new Thread(()->e.method()).start();

    }

   public void method() {
       try {  System.out.println("startNonSynch" + Thread.currentThread().getName());
       for (int i = 0; i < 3; i++) {
           System.out.println(".");
               Thread.sleep(100);
       }
       System.out.println("finishNonSynch" + Thread.currentThread().getName());
       synchronized (monitor){
           System.out.println("startSynch" + Thread.currentThread().getName());
           for (int i = 0; i < 3; i++) {
               System.out.println(".");
               Thread.sleep(100);
           }
           System.out.println("finishSynch" + Thread.currentThread().getName());
       }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }

}
