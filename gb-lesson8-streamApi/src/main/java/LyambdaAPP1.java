import java.util.function.Predicate;

public class LyambdaAPP1 {
    public static void main(String[] args) {
        //1)создадим анонимный внутренний класс
        //1-1) по любому интерфейсу можем создать анонимные внутренние классы
        MyFuncInterface1 mfi = new MyFuncInterface1() {
            @Override
            public void doSomething() {
                System.out.println(1);//3) реализовали чем то (в нашем случае sout(1))
            }//2)получается мы здесь создали public class TempAPP1$1 implements MyFuncInterface
            //и по этому классу создали новый объект (mfi = new MyFuncInterface())
        };
        //3) это все мы можем написать через ЛЯМДА выражение
        MyFuncInterface1 mfi1 = ()->System.out.println(1);
        MyFuncInterface1 mfi2 = ()-> System.out.println(2);
        MyFuncInterface1 mfi3 = ()->{
            System.out.println(3);
            System.out.println(4);
            System.out.println(5);
        };
        //4)посмотрим с аргументом (s) вот здесь мы ожидаем что сюда (s) прилетит объект
        //типом String
        Predicate<String> p = (s)->s.length()>5; //5) вернет true если длина s > 5

        Runnable r = ()-> System.out.println("any thing");
    }
}

