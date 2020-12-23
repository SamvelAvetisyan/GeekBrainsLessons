import java.util.concurrent.*;

public class ExecutorsService_7 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(4);
        exec.execute(()-> System.out.println(1));//2) первый вариант дать задачу пулу потоков

        //3) второй вариант, передаем тип Callable
        Future<String> future = exec.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Java";
            }
        });
        //4) как “Java” вытаскивать, для этого используем Future.
        //5) метод submit возвращает объект типа Future
        try {
            System.out.println(future.get());//6)sout: Java
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        exec.shutdown();//1) shutdown говорит пол потоков не принимай больше заказов и выполняй все задачи

        //6)как выполнить одну задачу в параллельном обычном потоке и получить ответ
        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Hello";
            }
        });
        new Thread(ft).start();
        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

