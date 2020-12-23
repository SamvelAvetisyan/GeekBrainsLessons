import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamAPIFunctions4_2 {
    public static void main(String[] args) {

    }
    //1) задача interface Function преобразование данных,
    // то есть принимает какой то тип и возвращает другой тип
    //2)interface BiFunction принимает 2 типы потом склеивает и вернет 1 тип
    //3) reduse сворачивает набор данных в один объект
    public static void reduceEx(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int streamSum = list.stream().reduce(0,(a,b)->a+b);
        System.out.println(streamSum);
    }

    //4)есть разные stream
    public static void intStreams(){
        IntStream intStream = IntStream.of(1,2,3,5,7);//4-1)объявляем так инт
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,5,8,3));//или так
        list.stream().mapToInt(n->n).min();
    }

    public static void streamCreation(){
        Arrays.stream(new int[]{1,2,3,4});//5) можем прямо из массива получать стрим

    }


}

