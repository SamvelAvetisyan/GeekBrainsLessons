package tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueList {
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

        uniqueElements(list);
    }

    public static void uniqueElements(List<String> list) {
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
    }
}



