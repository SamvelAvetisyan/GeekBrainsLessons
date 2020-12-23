public class AboutFor {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.println(i);
        }

        exit:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 4) {
                    break exit;
                }
            }
            System.out.println(i);
        }
    }
}

