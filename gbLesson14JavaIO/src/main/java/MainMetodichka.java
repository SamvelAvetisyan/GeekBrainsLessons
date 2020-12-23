import java.io.*;

public class MainMetodichka {
    public static void main(String[] args) {
      try(BufferedInputStream buffIn = new BufferedInputStream
                (new FileInputStream("5out.txt"))) {
          int x = -1;
           while((x = buffIn.read()) != -1){
         // System.out.print((char) x);
int n = buffIn.read(new byte[819]);
             //  System.out.println(n);

//           while (buffIn.read() != -1) {
//               System.out.print(buffIn.read() + "-");
           }
      } catch (IOException e){
          e.printStackTrace();
      }

byte[] arr = {65,66,67};
        ByteArrayInputStream in  = new ByteArrayInputStream(arr);
        int x;
        while ((x = in.read()) != -1){
            System.out.print((char)x + " ");
        }

        try(OutputStream out = new BufferedOutputStream(new FileOutputStream("6out.txt"))){
            for(int i  = 0; i<1000000; i++){
                out.write(i);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        try (InputStream in2 = new BufferedInputStream(new FileInputStream("6out.txt"))){
        int y = 0;
        while ((y = in2.read()) !=-1){
            System.out.print((char)y);
        }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
