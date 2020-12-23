public class GenericsApp1 {
    public static void main(String[] args) {
        BoxGen1<Integer> bgi1 = new BoxGen1<>(100);//1) создали объект класса BoxGen1 и
        //параметризовали Integer-ом
        BoxGen1<Integer> bgi2 = new BoxGen1<>(5);
        BoxGen1<String> nig3 = new BoxGen1<>("gago");//2)параметризовали String-ом
    }
}
