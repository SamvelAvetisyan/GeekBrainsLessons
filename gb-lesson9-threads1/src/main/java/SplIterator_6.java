import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplIterator_6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a","b","c","d"));
        list.spliterator().forEachRemaining(System.out::println);

    }
}
