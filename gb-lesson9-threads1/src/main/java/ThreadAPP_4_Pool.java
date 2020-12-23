

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadAPP_4_Pool {
    public static void main(String[] args) {
        ExecutorService threadPoolCache = Executors.newCachedThreadPool();
        threadPoolCache.execute(()-> System.out.println(1));

        ExecutorService threadPool =  Executors.newFixedThreadPool(8);
        //1)создали пул потоков которое не может выполнять более 8 задач одновременно
        for (int i = 0; i < 16; i++) {
           int w = i;
           threadPool.execute(()-> {
               System.out.println(w + "-start");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(w + "-end");
           });
        }
        threadPool.shutdown();//2)остановим поток
    }
}
