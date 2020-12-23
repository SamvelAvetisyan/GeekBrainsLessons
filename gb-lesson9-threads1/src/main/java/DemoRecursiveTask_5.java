import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class DemoRecursiveTask_5 extends RecursiveTask<Integer> {
    //1)хотим просуммировать элементы длинного массива
    private int[] data;

    public DemoRecursiveTask_5(int[] data) {
        this.data = data;
    }
    //2)разделим на 2 задачи
    private List<DemoRecursiveTask_5> createSubTasks(){//3) этот метод позволяет нашу задачу
        //RecursiveTask разбить на 2 подзадачи
        return new   ArrayList<>(Arrays.asList(
                new DemoRecursiveTask_5(Arrays.copyOfRange(data,0,data.length/2)),
                new DemoRecursiveTask_5(Arrays.copyOfRange(data,data.length/2, data.length))
        ));
    }
    //4) compute это выполнение, то есть когда в ForkJoin передадим задачу он вызывает compute и сделает вычисление
    protected Integer compute(){
        if(data.length>4){//5если длина массива >4 то начинаем разбивку на подзадачи
            List<DemoRecursiveTask_5> subTasks = createSubTasks();//6) мы получаем список подзадач
//                    new ArrayList<>();
//            subTasks.addAll(createSubTasks());
            for (DemoRecursiveTask_5 subTask : subTasks){
                subTask.fork();//7)выполняем все подзадачи
            }
            int result = 0;
            for (DemoRecursiveTask_5 subTask : subTasks){
                result += subTask.join();//7)проходим все подзадачи и сделаем join-ы,
                // join это получить результаты из подзадач, и суммируем
            }
            return result;
        } else {
            System.out.println("Calculation for" + Arrays.toString(data) + " in thread " + Thread.currentThread().getName());
            return IntStream.of(data).sum();
        }
    }

    public static void main(String[] args) {
        DemoRecursiveTask_5 demoRecursiveTask_5 = new DemoRecursiveTask_5(new int[]{1,2,1,2,1,2,1,2});
        long result = ForkJoinPool.commonPool().invoke(demoRecursiveTask_5);
        System.out.println(result);
    }

}

