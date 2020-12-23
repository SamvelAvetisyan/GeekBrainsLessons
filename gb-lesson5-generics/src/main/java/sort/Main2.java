package sort;

import java.util.Arrays;
import java.util.Comparator;

public class Main2 {
    public static void main(String[] args) {
        //1)сейчас посмотрим пример сортировки
        String[] strings = {"AAAA", "BBB", "D", "DDDD", "A", "AAAA"};
        //2) если мы отсортируем он будет сортировать по алфавиту
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
        //3) если мы хотим отсортировать по количеству букв
        //4) создадим анонимный класс Comparator
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });//5) то есть мы пишем внешнее правила сравнения для любых объектов, в этом случае
            //по длине слов
        System.out.println(Arrays.toString(strings));
    }
}
