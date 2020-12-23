public class MainApp3 {
    public static void main(String[] args) {
        try {
            method1();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }//мы можем перехватывать исключение здесь, в методе!
        System.out.println("End");
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        method3(0);
    }

    public static void method3(int divider) {
            System.out.println(1);
            int n = 10 / divider;
            System.out.println(2);
            //System.out.println("Is exception");
        }

    }

