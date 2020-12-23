import java.io.FileOutputStream;
import java.io.IOException;

public class TryResources1 {

    public static void main(String[] args) {
        //1)с java8 появилась try with resources!!!
        try(FileOutputStream out2 = new FileOutputStream("2.txt");
        FileOutputStream out3 = new FileOutputStream("3.txt")){
        } catch (IOException e){
            e.printStackTrace();
        }//2) здесь мы создали try с ресурсами
        //3)мы можем здесь и перехватить исключение и использовать finally!
        //4) ВАЖНО при таком подходе потоки будут ЗАКРЫТЫ после использования
        //не важно вылетел исключение или try отработал!
    }
}
