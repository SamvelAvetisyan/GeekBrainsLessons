public class Demo5 {
    //1)КАК быть если мы хотим запустить нашу программу и потом в зависимости от того
//как этот класс (Demo5) размечен мы бы вызывали соответствующие методы (m1 или m2 или m3 или m4)
//первым делом поставим нашу аннотацию


    @MyAnnotation4(timeout = 10, strData =  "Hello")//3)здесь указываем внутренности Аннотации
    //и можем менять значение default-ов
    public static void method1(){
        System.out.println("m1");
    }

    public static void method2(){
        System.out.println("m2");
    }

    @MyAnnotation4(timeout = 50)
    public static void method3(){
        System.out.println("m3");
    }

    @MyAnnotation4(timeout = 100)
    public static void method4(){
        System.out.println("m4");
    }
}
