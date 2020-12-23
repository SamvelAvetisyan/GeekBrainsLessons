package tasks;
/*
2	Найти список уникальных слов в двумерном массиве размером 5х5;
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class
Task2_UniqueWords {
    public static void main(String[] args) {
        String[][] strings = new String[][]{{"a","b","c","d","e"},
            {"aa","bb","cc","dd","ee"},
            {"a","bb","c","dd","e"},
            {"aa","b","cc","d","ee"},
            {"abc","bcd","c","dd","ef"}};
        List<String> uniqueWordsStr = uniqueWords(strings);
        System.out.println(uniqueWordsStr);


    }
    public static List<String> uniqueWords(String[][] arr){
        List<String> uniqueWords = Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        return uniqueWords;
    }
}
