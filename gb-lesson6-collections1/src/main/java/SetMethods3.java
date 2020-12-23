import java.util.*;

public class SetMethods3 {
    public static void main(String[] args) {
        //1)Set это множество уникальных значений
        Set<String> set = new HashSet<>();

        List<String> list = new ArrayList<>(Arrays.asList("A", "BB","AA","A","BB"));
        Set<String> set2 = new HashSet<>(list);
        System.out.println(set2);
       boolean b =  set2.contains("A");

    }
}
