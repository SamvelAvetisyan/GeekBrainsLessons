import java.util.Arrays;
import java.util.Iterator;

public class MyCollection2 implements Iterable<String> {
    private String[] array;//1)наш массив состоит из массив строк

    public MyCollection2() {
        this.array = new String[]{"A", "B", "C", "D", "E"};
    }//1-1) создали нашу коллекцию

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();//11)метод Iterator<String> пусть вернет new MyIterator()
        //12)теперь каждый раз, если у чего то запрашиваем iterator() то создается новый
        // экземпляр  MyIterator() (проверим в MainApp1)
    }//2)имплементировали метод iterator
    //3) нужен такой итератор который будет знать как ходить по нашей коллекции,
    //для этого создадим внутренний класс, и имплементить логично что Iterator
    //3-1) внутренний потому что он будет иметь доступ ко внешнем полям и можем с ними работать

    public void print() {
        System.out.println(Arrays.toString(array));
    }//13) и напечатаем


    private class MyIterator implements Iterator<String> {
        int index = 5;//5)у итератора должен быть индекс, если мы знаем что внешняя коллекция

        //всегда будет иметь длину массива 5
        //6)  В ЧЕМ БУДЕТ ЗАКЛЮЧАТСЯ ЛОГИКУ НАШЕГО ИТЕРАТОРА?!
        //6-1)он будет брать последний элемент массива и идти справа на лево!
        @Override
        public boolean hasNext() {
            return index > 0;
        }//7) когда спрашиваем есть ли у тебя следующий элемент
        //8) мы будем считать что следующий элемент есть если наш index > 0;

        @Override
        public String next() {
            index--;
            return array[index];
        }//9) при каждом next() мы шагаем влево и возвращаем значение этого элемента

        @Override
        public void remove() {
            array[index] = null;
        }//10)при удалении (на каком индексе стоим пусть обнулит этот элемент)
    }//4)внутри MyIterator напишем нашу логику методов
}

