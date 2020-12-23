import java.util.concurrent.*;

public class AboutSubmit_7 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(8);
        Future<String> future = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
               Thread.sleep(300);
                return "Java";
            }
        });
        System.out.println(1);
        System.out.println(future.get());
        System.out.println(2);
        threadPool.shutdown();
    }
}
