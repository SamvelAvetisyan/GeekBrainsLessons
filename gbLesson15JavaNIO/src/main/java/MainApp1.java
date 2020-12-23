import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MainApp1 {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("1.txt");//1)путь к файлу
        Path path2 = Paths.get("2", "3", "4.txt");//1-1)путь к файлу из директории или(2/3/4.txt)
        //  System.out.println(path2.getFileName());
        //  System.out.println(path2.getRoot());
//       Files.copy(path2,Paths.get("2","3","1.txt"), StandardCopyOption.REPLACE_EXISTING);
//        System.out.println(Files.exists(path2));
//        Files.lines(path1);//2)получаем Stream строк
//       System.out.println(Files.lines(path1).collect(Collectors.toSet()));
//        System.out.println(Arrays.toString(Files.readAllBytes(path1)));
//        System.out.println(Files.readAllLines(path1).toString());
        Files.walkFileTree(Paths.get("2"), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(path2.getFileName());
                if (path2.getFileName().toString().equals("4.txt")) {
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.TERMINATE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
        Files.write(Paths.get("1.txt"), " Java NIO".getBytes(), StandardOpenOption.APPEND);//3)хороший вариант записать в файл что хотим
        Files.writeString(Paths.get("1.txt"), " Gago", StandardOpenOption.APPEND);//4)запись в файл строку
    }
}

