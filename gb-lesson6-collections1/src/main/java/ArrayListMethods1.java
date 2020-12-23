import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListMethods1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D","B"));
        //1-1)Arrays.asList заворачивает наши объекты в Лист
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "F", "D","G"));
        list.add("A");
        list.add(1, "D");//1)добавление по индексу
        list.set(2, "E");//2) замена элемента
        System.out.println(list.contains("C"));//3) что в листе есть указанный намы элемент
        list.remove(3);//4)удаление по индексу
        list.remove("C");//5) удаление по элементу, если есть повторные одинаковые элементы
        //будет удалена ТОЛЬКО первый из них, остальные остаются
        while (list.remove("C")) ;//6) удалить все элементы "C"
        list.ensureCapacity(700);//7)проверяет что емкость листа не менее 7000 элементов
        list.trimToSize();//8) отрубить емкость до размера
        //8-1) механизм-создается лист размером занятого частя, данные копируются в новый
        list.indexOf("B");//9) Вернет индекс первого элемента ("B")
        list.lastIndexOf("B");//10)Вернет индекс, первого справа, элемента ("B")
        //A.removeAll(B)//11) из коллекции А удаляются все элементы которые есть в Коллекции B
        list.subList(2,4);//12) из листа взять часть, получить подлист(возмет 2-3)
        list.containsAll(list2);//13)в list есть все элементы которые есть в list2
        System.out.println(list);
        System.out.println(list.subList(2,4));
        System.out.println("Gago".substring(1,3));

        List<String> l = new ArrayList<>(50);//14) в конструкторе можно указать емкость, если заранее знаем
       List<String> lConstant = Collections.unmodifiableList(list);//15) если хотим создать неизменяемый лист,
        // только для чтения


    }
}
