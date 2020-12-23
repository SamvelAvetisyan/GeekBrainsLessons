public class AboutWile {
    public static void main(String[] args) {


        int a = 15;
        while (a<1000_000) {//пока условие истинно будет выполняться блок
            a = (a * 12 - 40) / 2;
            System.out.println(a);
        }
        // do while сначала выполняется блок потом проверка!
        int b = 15;
        do {
            b = (b * 12 - 40) / 2;
            System.out.println(b);
        } while (b < 1000_000);
    }
}
