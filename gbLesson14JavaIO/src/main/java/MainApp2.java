import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainApp2 {
    public static void main(String[] args) throws IOException {

        try (FileInputStream in = new FileInputStream("5out.txt")) {//1)используем try с ресурсамы,
            int x = -1;
            System.out.println(in.read());
//            while ((x = in.read()) != -1) {//2)читаем байты
//                // -1 вернется если поток ввода закончился),
//                //2-1) read это вычитывание одного байта из файла(результат int)
//                System.out.print((char) x);//3)байты преобразовали в char и выводили
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream out = new FileOutputStream("5out.txt" )){//4)для записи
            //5)если append поставили true записывается не с нуля а после записи в файле
            // out.write(29);//6)write записывает байтовые данные
            //   out.write("Java IO".getBytes());//6)записываем уже строка
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

