import java.io.*;

public class MainMetodichka2 {
    public static void main(String[] args) {
       try(BufferedWriter writer = new BufferedWriter(new FileWriter("7.txt"))){
           for (int i = 0; i < 20; i++) {
               writer.write("Java\n");
           }
       } catch (IOException e){
           e.printStackTrace();
       }

       try(BufferedReader reader = new BufferedReader(new FileReader("7.txt"))){
           String str;
           while ((str = reader.readLine()) != null){
               System.out.println(str);
           }
       } catch (IOException e){
           e.printStackTrace();
       }

       try(RandomAccessFile raf = new RandomAccessFile("8.txt", "r")){
raf.seek(3);
           System.out.println((char)raf.read());
       } catch (IOException e){
           e.printStackTrace();
       }

    }
}
