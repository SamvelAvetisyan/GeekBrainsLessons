package sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //1)создадим массив простых коробок
       SimpleBox2[] simpleBoxes2 = {new SimpleBox2(5),
                                    new SimpleBox2(7),
                                        new SimpleBox2(2)};
        System.out.println(Arrays.toString(simpleBoxes2));
        //2) сейчас будем сортировать коробки
    //3)ЧТОБЫ JAVA могла отсортировать он должен знать как сравнить наши объекты между собой
        //4) для этого класс наших объектов должны имплементить Comparable
        // (см. класс SimpleBox  и SimpleBox2)
        Arrays.sort(simpleBoxes2);
        System.out.println(Arrays.toString(simpleBoxes2));

    }

}
