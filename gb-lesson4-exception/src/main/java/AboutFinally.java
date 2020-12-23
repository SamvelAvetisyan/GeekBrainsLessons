public class AboutFinally {
    public static void main(String[] args) {
       // method1();
        System.out.println(method2());;
    }

    public static void method1() {
        try {
            int n = 10 / 0;
        } catch (NullPointerException e) {
        }//1)здесь мы не перехватили исключения
        finally {
            System.out.println("Hello World");
        }//2)но программа работал и напечатал, finally по любому будет выполнятся
        //3)но дальнейшие методы не будут выполнятся, потому что исключение не перехвачено
    }

    public static int method2() {
        try {
            return 1;
        } finally {
            return 2;
        }//4)finally мощнее и при вызове метода вернет 2!
        //не рекомендуется finally использовать return
        // он более предназначена для закрытия ресурсов
    }
}
