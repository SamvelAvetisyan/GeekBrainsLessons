import java.nio.ByteBuffer;

public class MainAppBuffer3 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.put((byte)65);
        buffer.put((byte)66);
        buffer.put((byte)67);
        buffer.flip();
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
        buffer.flip();
        buffer.put((byte)68);
        buffer.put((byte)69);
        buffer.flip();
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
        //sout: 65 66 68 69 Exception

    }
}
