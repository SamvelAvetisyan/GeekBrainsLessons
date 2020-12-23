package tasks;
/*
1	Взять строку, состоящую из 100 слов разделенных пробелом,
    получить список слов длиннее 5 символов,
    и склеить их в одну строку с пробелом в качестве разделителя
 */

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        String s = "a ab abc abcd abcde abcdef abcdefg abcdef abcdefgh ab " +
                "a ab abc abcd abcde abcdef abcdefg abcdef abcdefgh ab " +
                "a ab abc abcd abcde abcdef abcdefg abcdef abcdefgh ab " +
                "a ab abc abcd abcde abcdef abcdefg abcdef abcdefgh ab " +
                "a ab abc abcd abcde abcdef abcdefg abcdef abcdefgh ab " +
                "a ab abc abcd abcde abcdef abcdefg abcdef abcdefgh ab " +
                "a ab abc abcd abcde abcdef abcdefg abcdef abcdefgh ab " +
                "a ab abc abcd abcde abcdef abcdefg abcdef abcdefgh ab " +
                "a ab abc abcd abcde abcdef abcdefg abcdef abcdefgh ab " +
                "a ab abc abcd abcde abcdef abcdefg abcdef abcdefgh ab ";
        System.out.println(wordsLengthMoreThenFifeSymbol(s));
    }

    public static String wordsLengthMoreThenFifeSymbol(String s) {
        String result = Stream.of(s)
                .map(line -> line.split(" "))
                .flatMap(Arrays::stream)
                .filter(str -> str.length() > 5)
                .collect(Collectors.joining(" "));
        return result;
    }

}

