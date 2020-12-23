package aboutComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik",5));
        cats.add(new Cat("Murzik", 10));
        cats.add(new  Cat("Liska",7));
        System.out.println(cats);
        Collections.sort(cats);
        System.out.println(cats);
    }
}
