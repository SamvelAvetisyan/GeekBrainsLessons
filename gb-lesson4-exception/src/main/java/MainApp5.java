import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainApp5 {
    public static void main(String[] args) {
        try {
            doSomething();//2) но когда вызываем этот метод то нужно или обработать
            // или бросить дальше
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void doSomething() throws FileNotFoundException {
        new FileInputStream("1.txt");
    }//1)мы можем бросить исключение в сигнатуре метода
    //мы бросаем исключение дальше, где дальнейший пользователь может отработать лучше
}
