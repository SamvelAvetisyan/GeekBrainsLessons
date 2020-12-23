import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LyambdaAPP2 {
    public static void main(String[] args) {
        //1)напишем фильтр
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 4;
            }
        };
        Predicate<String> predicate1 = (s) -> s.length() == 4;
        //4)создадим лист
        List<String> list = new ArrayList<>(Arrays.asList("AAA","BBBB", "CCCCC"));
        System.out.println(list);
        //5) теперь используем наш метод filterLength4
        filterLength4(list,predicate1);
        System.out.println(list);
        //6) если нам нужен будет другие условие то прям в аргументе можем
        //написать наш другой Predicate
        filterLength4(list, s -> s.length() < 5);
        System.out.println(list);

    }
    //2)напишем метод который фильтрует листы и оставляет строки длина которых == 4
    //3)он ожидает вход список строк и некий Predicate для строк
    public static void filterLength4(List<String> list, Predicate<String> p){

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String o = iterator.next();
            if(p.test(o)){
                iterator.remove();
            }
        }
    }

}

