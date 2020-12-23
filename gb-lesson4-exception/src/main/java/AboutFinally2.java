import java.io.FileOutputStream;
import java.io.IOException;

public class AboutFinally2 {
    public static void main(String[] args) {
        FileOutputStream out = null;//1)мы объявляем здесь а не в try, чтоб могли использовать out
        try {
            out = new FileOutputStream("1.txt");
            out.write(10);
            //2)в try не закрываем (close()) поток, потому что может быть будет какая то логика
            //и программа упадет и не доберемся до close()!!!
        } catch (IOException e){
            e.printStackTrace();//3)возможен исключение поэтому перехватываем
        }finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //4)мы закрываем в finally потому что он будет выполнятся по любому!!!!!
        //ХОТЬ вылетел исключение ХОТЬ нет!!
        //5) В момент закрытия может быть IOException,
        // поэтому мы и здесь используем внедренный try catc!!
        //6) в if-e еще проверяем(может быть NotFoundException)
    }

}
