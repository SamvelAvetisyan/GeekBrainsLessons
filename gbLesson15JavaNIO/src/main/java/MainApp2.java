import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MainApp2 implements Serializable {
    private static final long serialVersionUID = 1l;

    public static void main(String[] args) throws IOException {
//        //1)перекинуть данные из одного файла в другой
//        RandomAccessFile src = new RandomAccessFile("1.txt", "rw");
//        FileChannel srcChannel = src.getChannel();//1-1)создали файловые каналы
//        RandomAccessFile dst = new RandomAccessFile("1out.txt","rw");
//        FileChannel dstChannel = dst.getChannel();
//
//        //2)мы хотим, в канал точки назначения, передать данные из другого канала
//        //dstChannel.transferFrom(srcChannel,0,srcChannel.size());//2-1
//        srcChannel.transferTo(0,srcChannel.size(),dstChannel);//2-2)или так


        try (InputStream in = new BufferedInputStream(new FileInputStream("1.txt"))) {
            int x = -1;
            while ((x = in.read()) != -1) {
                // System.out.print((char)x);
            }
        }//3)прочитанные по байтам в IO


        try (RandomAccessFile src = new RandomAccessFile("1.txt", "rw");
             FileChannel srcChannel = src.getChannel()) {//4)открываем канал
            ByteBuffer buffer = ByteBuffer.allocate(4);//4-1)выделим память под буфер(4 byte)
            int byteRead = srcChannel.read(buffer);//5)теперь нам нужно узнать сколько байтов прочитали,
            // для этого мы берем входящий канал и вычитываем эти данные в буфер,
            // то есть srcChannel.read(buffer) выдергивает данные из канала(файла) и кладет в буфер.
            while (byteRead != -1) {
                buffer.flip();//5-1)чтоб перейти из режима записи в режим чтения делаем flip,
                // flip курсор в ноль сбрасывает
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear(); //6)после чтения буфер чистим
                byteRead = srcChannel.read(buffer);//6-1)и делаем повторное чтение
            }
            System.out.println(srcChannel.position());//8)можем узнать позицию курсора
        }//7) для чтения в NIO
    }
}

