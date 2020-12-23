public class MainApp2 {

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
           int[] arr = {1, 5, 8};
            try {
                System.out.println(1);
                arr[5] = 100;//int n = 10 / divider;
                // это уже не выполняется, сразу прыгает 2 catch
                int n = 10 / divider;
                System.out.println(2);
            } catch (ArithmeticException e) {
                e.printStackTrace();
                //System.out.println("Is exception");
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            } catch (RuntimeException e){
                e.printStackTrace();
            }
        }
    }


