import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIFunction4_3_FromFile {
    //1)stream из файла
    public static void streamFromFile() {
        try {
            Files.lines(Paths.get("F:\\gb-lesson8-streamApi\\src\\main\\resources\\text.txt"))
                    //.map(s->s.length())
                    .forEach(s -> System.out.println(s));
            //1-1)метод lines возврашает стрим из строк и можем делать что-то с ним
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2)склеить по каким-то образом
    public static void readFileToString() throws IOException {
        System.out.println(Files.lines(Paths.get("F:\\gb-lesson8-streamApi\\src\\main\\resources\\text.txt"))
                        //2-1)здесь мы читаем из файла все строки кладем в поток(stream)
                        .collect(Collectors.joining("\n"))//2-2) здесь делаем
                //collect, мы указали разделитель, все строки которые есть в стриме они
                //склеиваются(конкатенация) друг с другом через этот разделитель,
                // то есть получаем одну длинную строку из файла


        );
    }

    //3) из файла уникальные слова!!
    public static void flatMap() {
        try {
            System.out.println(Files.lines(Paths.get("F:\\gb-lesson8-streamApi\\src\\main\\resources\\text.txt ")) //3-1)читали
                    .map(line -> line.split("\\s"))//3-2)каждую строчку разбиваем по пробелам
                    // на массив, получаем на выходе стрим массивов arr[0], arr[1], arr[2]...
                    .flatMap(Arrays::stream)//3-3)здесь мы каждый массив завернем в стрим
                    // и объединяем все стрим стримов в один длинный стрим,
                    // то есть здесь получили 1 большой стрим из строк
                    .distinct()//3-4)отбросили все дубликаты, остались только уникальные
                    .collect(Collectors.joining(",", "уникальные слова: ", "."))
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //4) посчитать количество слов в файле,
    public static Map<String, Long> countWordsInFile(Path path) {
        try {
            Map<String, Long> map = Files.lines(path)
                    .map(line -> line.split("\\s"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
            return map;
        } catch (IOException e) {
            throw new RuntimeException("не получилось");
        }
    }
    //5) найти слово которое встречается часто всего
    public static void printTheMostFrequentWordInFile(Path path){
        try {
            Files.lines(path)
                    //получаем стрим строк из файла
                    .map(line->line.split("\\s"))
                    //разбиваем все строки на массивы
                    .flatMap(Arrays::stream)
                    //все массивы заворачиваем в стрим(для каждого массива получаем stream)
                    //то есть получили стрим абсолютно всех слов этого файла
                    .collect(Collectors.groupingBy(s->s, Collectors.counting()))
                    //затем все слова группируем,
                    // в качестве ключа остаются слова а в качестве значения их количество(получаем Map)
                    .entrySet()
                    //мы из Map получаем набор ключ-значение (с помощью entrySet)
                    .stream()
                    //этот Set превращаем в поток
                    .sorted((e1,e2)->e2.getValue().intValue()-e1.getValue().intValue())
                    //поток сортируем по значению
                    .limit(1)
                    //получаем самое большое число
                    .findFirst().ifPresent(w-> System.out.println("больше всего встречалось " + w.getKey()));
            //найдем первый же элемент
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //flatMap();
        // streamFromFile();
        //  readFileToString();
//      Map<String, Long> mapCount = countWordsInFile(Paths.get("F:\\gb-lesson8-streamApi\\src\\main\\resources\\text.txt "));
//    for (Map.Entry<String, Long> elements : mapCount.entrySet()){
//        System.out.println(elements.getKey() + " " + elements.getValue());

        printTheMostFrequentWordInFile(Paths.get("F:\\gb-lesson8-streamApi\\src\\main\\resources\\text.txt"));
    }

}

