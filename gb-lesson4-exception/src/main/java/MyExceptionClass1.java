public class MyExceptionClass1 extends RuntimeException{
    //создать свой класс исключений


//    public MyExceptionClass()1 {
//    }

    public MyExceptionClass1(String message) {
        super(message);
    }
    //при выбросе нашего исключения можем написать наше сообщение
}
