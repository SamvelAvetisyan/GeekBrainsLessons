import java.util.Collection;
import java.util.Iterator;

public class MainApp1 {

    public static void main(String[] args) {

        MyCollection2 myCollection2 = new MyCollection2();
    Iterator<String> iterator = myCollection2.iterator();
    while (iterator.hasNext()){
        if (iterator.next().equals("C")){
            iterator.remove();
        }
    }
    myCollection2.print();
    }
}
