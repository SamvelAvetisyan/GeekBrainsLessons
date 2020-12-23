public class MainApp1 {
    public static void main(String[] args) {
        method1();
        System.out.println("End");
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        method3(0);
    }

    public static void method3(int divider) {
        if(divider != 0){
            int n = 10/ divider;
        }//чтобы избежать от ошибки. Не нужно будет использовать try catch;
        try {
            System.out.println(1);
            int n = 10 / divider;
            System.out.println(2);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            //System.out.println("Is exception");
        }
        catch (RuntimeException e) {
            e.printStackTrace();

        }
    }
}
