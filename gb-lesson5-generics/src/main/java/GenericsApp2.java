import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  GenericsApp2 {
    public static void main(String[] args) {

        List<Number> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(calculateAvg(list));
    }
    //2)давайте посчитать среднее по List-у
//    public static double calculateAvg(List<Number> numbers){
//        double avg = 0.0;
//        for (int i = 0; i < numbers.size(); i++) {
//            avg += numbers.get(i).doubleValue();
//        }
//        return avg / numbers.size();
//    }
    //3) если хотим работать с Integer
    //4) нельзя так List<Number> list = new ArrayList<Integer>();
    //5) чтобы мы могли написать работающий метод для чисел нужно писать так
    public static double calculateAvg(List<? extends Number> numbers){
        double avg = 0.0;
        for (int i = 0; i < numbers.size(); i++) {
            avg += numbers.get(i).doubleValue();
        }
        return avg / numbers.size();
    }

//6)Могут быть обобщенные методы(метод вернет первый элемент листа)
    public static <T> T getFirstElement(List<T> list){
    return list.get(0);
    }//7)мы указываем что будем использовать обобщенный тип <Т>
    //8) и метод вернет объект типа T(Это Т рядом <Т>)
//9)мы можем поставить ограничение <T extends Number>-сверху

}
