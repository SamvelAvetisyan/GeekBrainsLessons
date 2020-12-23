package tasks;
/*
4	Посчитать суммарную длину строк в одномерном массиве
 */
import java.util.Arrays;

public class Task4SumLength {
    public static void main(String[] args) {
        String[] s = {"I", "Love", "Java"};
        System.out.println(sumLength(s));
    }
    public static int sumLength(String[] arr){
        return Arrays.stream(arr)
                .mapToInt(String::length)
              .sum()
//              .map(l->l.length())
//                .reduce(0,(a,b)->a+b)
              ;

    }
}
