public class MyExceptionClassMain2 {
    public static void main(String[] args) {
   try{
       arrayLength2(new int[5]);
   } catch (MyExceptionClass2 e){
        System.out.println("Длина массива была равна" + e.getLength());
    }//2)
        //3) мы добавили e.getLength если нужно будут эти данные при обработке ошибки
}
    public static void arrayLength2(int[] arr){
        if (arr.length != 10 ){
        throw new MyExceptionClass2("Длина массива должна быть равна 10", arr.length);
        }//1)здесь мы выбрасиваем наше исключение,
        //здесь мы arr.length используем при перехвате исключения наверху(2))
        int sum = 0;
        for(int i  = 0; i<arr.length; i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
