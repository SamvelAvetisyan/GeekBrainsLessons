import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LyambdaAPP3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("AAA", "BBBB", "CCCCC"));
        filter(list, s-> s.length() < 5);
        System.out.println(list);

    }
    public static void filter(List<String> list, Predicate<String> p){

        list.removeIf(p::test);
    }
}
