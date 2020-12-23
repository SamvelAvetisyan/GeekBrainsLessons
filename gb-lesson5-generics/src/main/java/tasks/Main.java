package tasks;
/*
1.	Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
2.	Написать метод, который преобразует массив в ArrayList;
3.	Задача:
a.	Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
b.	Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c.	Для хранения фруктов внутри коробки можно использовать ArrayList;
d.	Сделать метод getWeight(), который высчитывает вес коробки, зная  вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
e.	Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
f.	Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    //Task 1
    public static <T> void switchElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //Task 2
    public static <T> ArrayList<T> fromArrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3};
        String[] arr2 = {"1", "2", "3"};
        switchElements(arr2, 0, 2);
        System.out.println(Arrays.toString(arr1));

        List<String> list = fromArrayToList(arr2);
        System.out.println(list);


        Box<Orange> orangeBox = new Box<>();
        Orange orange = new Orange();
        Orange orange2 = new Orange();
        orangeBox.addFruit(orange);
        orangeBox.addFruit(orange2);

        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Apple apple = new Apple();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        appleBox.addFruit(apple);
        appleBox.addFruit(apple1);
        appleBox.addFruit(apple2);
        appleBox1.addFruit(apple3);

        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox.compare(appleBox));
        System.out.println(appleBox.getWeight());
        appleBox.sprinkleBox(appleBox1);
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox.getWeight());

    }
}