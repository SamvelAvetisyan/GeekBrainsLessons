

public class ThreadAPP_2_Create {
    public static void main(String[] args) {
        //1)еще вариант(лучше чем в ThreadAPP_1) можем создать Thread
        // через анонимный класс
        Thread tr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });
        tr1.start();
        //2)можем создать Thread через лямбда выражение
      Thread tr2 =new Thread(()-> System.out.println(2));
      tr2.start();
    }
}
