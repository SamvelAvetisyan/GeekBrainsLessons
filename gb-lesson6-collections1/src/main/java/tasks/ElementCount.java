package tasks;
/*
1	Создать массив(лист) с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 Посчитать, сколько раз встречается каждое слово.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElementCount {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        list.add("D");
        list.add("A");
        list.add("E");
        list.add("A");
        list.add("B");
        list.add("E");
        countWord(list);
    }
    public static void countWord(List<String> list) {
        Set<String> set = new HashSet<>(list);
        int count = 0;
        for (String el : set) {
            for (String s : list) {
                if (el.equals(s)) {
                    count++;
                }

            }
            System.out.println(el + " встречается " + count + " раз.");
            count = 0;

        }
    }
}
