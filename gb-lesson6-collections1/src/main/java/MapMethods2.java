import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapMethods2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        //1-1)изначальный размер map-16(capacity) ячеек, потом может увеличиться в 2 раза и т.д.
        //не можем указать емкость не степень двойки
        //1-2)увеличиться в 2 раза когда добавим пары больше чем емкость*0,75(по умолчанию load factor=0.75)
        //1-3)load factor - это как часто нужно увеличивать емкость(в 2 раза), увеличивается когда
        // количество пары больше чем load factor*capacity, мы можем задать load factor.
        //1-4) вероятность Коллизий зависит от емкости, от load factor и от того как написан hashCode

        map.put("Russia", "Moscow");
        map.put("Germany", "Berlin");
        map.put("Britain", "London");
        //1) когда кладем в map - берется hashCode ключа + map.capacity
        // получается какой то index и туда кладется пара, поэтому не упорядочены
        //индекс получается по формуле i=(n-1)&hash(i не будет больше n-1) здесь n-это емкость(capacity)
        //2) когда несколько пары попадают в один ячеек (из за того что индексы совпали)
        //это называется КОЛЛИЗИЕЙ, эти пары образуют LinkedList, LinkedList с какого то значения
        //может превращаться в дерево
        map.get("Russia"); //3) искать значение по ключу
        //4)важно почти обязательно чтоб ключи были имутабельными

        map.getOrDefault("A", "Java");//5) этот метод вернет значение
        //пары если есть ключ "A", если нет такого ключа вернет то что передали ("Java")
        map.values();//6) вернет множество значений
        map.keySet();//7)вернет множество ключей

        //8) если понадобится перебрать пары ключ-значение
        //Entry является внутренним классом для Map
        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println(e.getKey());//9)печатали ключи
            System.out.println(e.getValue());//10) печатали значения
        }
        //11)если хотим получить по порядку как добавил нужно использовать (LinkedHashMap)
        Map<String, String> map2 = new LinkedHashMap<>();
        map2.put("Russia", "Moscow");
        map2.put("Germany", "Berlin");
        map2.put("Britain", "London");
        for (Map.Entry<String, String> e2 : map2.entrySet()){
            System.out.println(e2.getKey() + " : " + e2.getValue());
        }
            //12)TreeMap будет выдавать значение по сортировке ключей

    }
}

