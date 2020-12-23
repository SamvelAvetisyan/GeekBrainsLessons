import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIFunctions4_1 {
    public static void main(String[] args) {
        //   filterEx();
        //  listOut();
        //    distinctElements();

    }
    //1) about filter
//    public static void filterEx(){
//        Stream.of(1,2,3,5,6,8,9)
//                .filter(p -> p%2 == 0)
//                .forEach(n-> System.out.println(n));
//    }
//2) создаем список из целых чисел
    public static void listOut() {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 7, 8, 9);
        List<Integer> out = numbers.stream()
                .filter(n -> n % 2 == 0)
                .limit(2)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(numbers);
        System.out.println(out);
    }
    //3) уникальные (distinct)
    public static void distinctElements(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,4,1,5,8,9,5,7,3));
        list.stream()
                .distinct()
                .filter(n->n%2 == 1)
                .forEach(n-> System.out.println(n));
        System.out.print(list);
    }
    //4) проверка набора данных
    public static void matchEl(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,4,3,2,5));
        boolean b = list.stream().allMatch(n->n<4);//4-1)здесь мы говорим что
        //ВСЕ элементы должны быть <4, то есть если хоть 1 элемент будет >4 вернет false
        //allMatch - все они должны быть, есть еще anyMatch и noneMatch
    }
    //5) группировка каких то данных
    public static void groupEl(){
        //5-1)например сколько слов состоит из какой то длины

        Map<Integer, Long> map = Stream.of("aa", "BBB", "ccc","DDDD")
                .collect(Collectors.groupingBy(String::length,Collectors.counting()));
        //5-3) здесь String::length,Collectors.counting())
        //с лева указываем как группируем по ключам с права как получаем значение
        //5-4) в данном случае говорим что будем группировать по длине -
        // то есть получаем длину String-а тем самим получая ключ
        //Collectors.counting() - покажет сколько раз длина встретилась
//5-2)collect это сборка, может быть сборка в коллекцию, может в мап, может в строку
    }

}

