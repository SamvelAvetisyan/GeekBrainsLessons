public class MyExceptionClassMain1 {
    public static void main(String[] args) {
        int[] massiv = new int[3];
        arrayLength(massiv);

    }
    public static void arrayLength(int[] arr){
        if (arr.length != 10 ){
            throw new MyExceptionClass1("Длина массива должна быть равна 10");
        }//здесь мы выбрасываем наше исключение, если знаем как делать нельзя

   int sum = 0;
        for(int i  = 0; i<arr.length; i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
