package tasks;
/*
5	Из массива слов получить первые три слова в алфавитном порядке
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
String[] s = {"abc","abe","aa","cc","abb","ee","ss"};
        System.out.println(theFirstThreeWords(s));
    }

    public static List<String> theFirstThreeWords(String[] arr){
        List<String> theFirstThreeWords = Arrays.stream(arr)
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
        return theFirstThreeWords;
    }
}
