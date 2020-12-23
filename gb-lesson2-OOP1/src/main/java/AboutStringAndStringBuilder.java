public class AboutStringAndStringBuilder {
    public static void main(String[] args) {


      //  System.out.println(Integer.toBinaryString(50));
      //  System.out.println(Integer.max(78, Integer.max(68, 82)));
//        String str = "1";
//        String str2 = str;
//        System.out.println(str2);
        //1) когда хотим изменить строку нужно использовать StringBuilder,
        //StringBuilder в памяти: массив размером 10, если придет еще элемент этот массив
        //увелечивается в 2 раза и так далше !!!
        //1-1)если работаем с 1 потоком используем StringBuilder
            // (не потокобезопасен  - методы не синхронизированы
        //1-2) если работаем с >1 потоками используем StringDuffer он потокобезопасен
        // - методы методы не синхронизированы
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            stringBuilder.append('x');
        }
        System.out.println(stringBuilder);
        //2) String иммутабельный
        String str = "a";
        System.out.println(str.toUpperCase());
        System.out.println(str);//вывод будет А и а
        //3) чтоб str стал большим нужно писать так
        str = str.toUpperCase();

        String any = "ferfwetg";//4) это хранится в СТРИНГ Пуле
        String a = new String("w");//5)это хранится в Хипе(new выделяет новый част в памяти)
    }
}
