import java.util.Arrays;

public class AboutArray {
    public static void main(String[] args) {
        int[] arr = new int[5];
        String s = Arrays.toString(arr);//Arrays.toString преобразует массив в строку!
        System.out.println(s);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 5;
        }
        int[] arr2 = {1, 5, 4, 5, 8, 9};// вариант заполнения массива

        int[] srcArr = {1,2,4,5,7,9};
        int[] dstArr = new int[4];
       System.arraycopy(srcArr,0,dstArr,0,4);// способ
        //копирования из одного массива в другой
    }
    public static void doSomething(int... arr){// если в методе хотим
        //в аргументе передать массив произвольной длины нужно написать int...


    }

}
