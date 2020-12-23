import java.io.*;

public class MainApp4NoEnglish {
    public static void main(String[] args) {

        try(InputStreamReader in  = new InputStreamReader
                (new FileInputStream("rus.txt"),"UTF-8")) {//1)можем читать текст любой кодировки
int n;
while ((n = in.read()) != -1){
    System.out.print((char)n);
}
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
