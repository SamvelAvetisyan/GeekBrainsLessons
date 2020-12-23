public class MainApp4 {
    public static void main(String[] args) {
       try {
           throw new RuntimeException("123");//1)мы можем сами выбросить исключение!
       } catch (RuntimeException e){
           e.printStackTrace();
       }//2)и можно перехватить, на след. примере(sqrt) покажем, где это можно использовать!

       int n = 55;
        try {
            System.out.println(sqrt(n));
        } catch (ArithmeticException e){
            System.out.println("Так делать нельзя");
        }//3)пользователь который увидел наше исключение (Невозможно Вычислить корень из отриц.числа)
        // может он сам перехватить и написать что хочет

    }
    public static double sqrt(int n){
        if (n<0){
            throw new ArithmeticException("Невозможно Вычислить корень из отриц. числа");
        }
        return Math.sqrt(n);
    }
}

