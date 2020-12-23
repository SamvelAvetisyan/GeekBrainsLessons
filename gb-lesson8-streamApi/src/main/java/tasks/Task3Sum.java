package tasks;
/*
3	Посчитать сумму четных чисел в пределах от 100 до 200 (включительно);
 */
import java.util.stream.IntStream;

public class Task3Sum {
    public static void main(String[] args) {
        System.out.println(sum(100,200));

    }
    public static int sum(int a, int b){
        int sum = IntStream.rangeClosed(a,b)
                .filter(n->n%2 == 0)
                .sum();
        return sum;
    }
}
