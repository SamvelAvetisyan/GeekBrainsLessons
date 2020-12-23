package tasks;
/*
1.	Напишите метод, который подсчитывает сколько раз в текстовом файле встречается указанная последовательность символов с учетом регистра (только для латиницы). Реализуйте решение на основе FileChannel и ByteBuf;
2.	Напишите метод, который последовательно сшивает все текстовые файлы в указанном каталоге в один файл (подкаталоги обходить не надо) с помощью Java NIO;
3.	Напишите метод, выполняющий поиск файлов размером менее 100 КБ в указанном каталоге и его подкаталогах;

*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    final static int  BUFFSIZE=8192;

    public static String readFile(Path file) throws IOException {

        StringBuilder text=new StringBuilder("");
        FileInputStream in = new FileInputStream(file.toAbsolutePath().toString());
        FileChannel channel = in.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BUFFSIZE);
        int noOfBytesRead = channel.read(buffer);

        while (noOfBytesRead != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                text.append((char)buffer.get());
            }
            buffer.clear();
            noOfBytesRead = channel.read(buffer);
        }
        channel.close();
        return text.toString();
    }

    public static int countWordInFile(Path file, String word) throws IOException {
        if(!Files.isRegularFile(file)){
            throw new RuntimeException("This path is not regular file!");
        }
        int count=0;
        String text=readFile(file);
        int lastIndex = 0;

        while(lastIndex != -1){

            lastIndex = text.indexOf(word,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += word.length();
            }
        }
        return count;
    }

    public static void mergeAllFilesInDirectory(Path directory) throws IOException {

        FileChannel destFileChannel= new FileOutputStream("output.txt").getChannel();
        if(!Files.isDirectory(directory)){
            throw new RuntimeException("This path is not directory!");
        }

        List<String> stringPaths=Files.list(directory)
                .filter(Files::isRegularFile)
                .map(file->file.toAbsolutePath().toString())
                .collect(Collectors.toList());

        for (String filePath:stringPaths) {
            RandomAccessFile fileToCopyInDest=new RandomAccessFile(filePath,"rw");
            FileChannel fileToCopyChannel=fileToCopyInDest.getChannel();
            destFileChannel.position( destFileChannel.size() );
            fileToCopyChannel.transferTo(0,fileToCopyChannel.size(),destFileChannel);
            ByteBuffer buff = ByteBuffer.wrap(("\n").getBytes(StandardCharsets.UTF_8));
            destFileChannel.write(buff);
        }
    }

    public static List<String> findFiesWithLittleSize(Path path) throws IOException {
        if(!Files.isDirectory(path)){
            throw new RuntimeException("This path is not directory!");
        }

        return Files.walk(path,10)
                .filter(Files::isRegularFile)
                .filter(file-> {
                    try {
                        return Files.size(file)<100000;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    return false; })
                .map(file->file.getFileName().toString())
                .collect(Collectors.toList());

    }
    public static void main(String[] args) {

        try {
            System.out.println(countWordInFile(Paths.get("1.txt"),"been"));
        } catch (IOException ioException) {
            throw new RuntimeException("Please check the file!");
        }
        try {
            mergeAllFilesInDirectory(Paths.get("TestDirectory"));
        } catch (IOException ioException) {
            throw new RuntimeException("Please check the file!");
        }
        try {
            System.out.println(findFiesWithLittleSize(Paths.get("TestDirectory")));
        } catch (IOException ioException) {
            throw new RuntimeException("Please check the file!");
        }

    }
}
