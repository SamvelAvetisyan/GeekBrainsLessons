import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Iterator4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("AA","AAAA","AAA","AA","AAAAA"));
//        for (String o : list){
//            if(o.length()<3){
//                list.remove(o);
//            }//1) так не будет работать, потому что когда удаляется элемент вместе него
//            //приходит другой элемент но цикл продолжается
//        }


        //2)если нам нужно обойти какой то набор данных нужно использовать Iterator
        List<String> data = new ArrayList<>(Arrays.asList("A","B","B","A","C","B"));
        Iterator<String> iterator = data.iterator();//3)Iterator позволяет обойти все
        //элементы набора данных
        while (iterator.hasNext()){//3) здесь он пройдет по каждому элементу и проверяет
            //есть ли еще элемент
            String o = iterator.next();//4)здесь о принимает все значение набора по очереди,
            //в нашем случае о сначала будет А потом В потом В потом А потом С потом В
            if (o.equals("B")){//5)здесь все можем написать (логику),
            //в нашем случае говорим,если на чем мы стоим сейчас, equals В мы хотим это удалить
            iterator.remove();
            }
        }

    }
}
