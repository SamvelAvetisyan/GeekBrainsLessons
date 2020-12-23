

public class ThreadAPP1_Create {
//    static class MyThread extends Thread{//1)1-ий вариант создать поток(не лучший)
//        @Override
//        public void run() {
//           for (int i = 0; i<10; i++){
//               System.out.println(i);
//           }
//        }
//    }
    //2) 2ой вариант создать поток (лучше так) но тоже не удобно ->ThreadAPP_2
//    static class MyRunnable implements Runnable {
//        @Override
//        public void run() {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i);
//            }
//        }
//    }
    public static void main(String[] args) {
//       MyThread tr1 = new MyThread();
//       MyThread str2 = new MyThread();
//       tr1.start();
//       str2.start();
        System.out.println(Thread.currentThread().getName());
//        Thread tr1 = new Thread(new MyRunnable());//2-1)чтобы реализовать наш поток
//        //нужно создать поток и в конструктор передать реализацию метода run()
//        // из MyRunnable()
//        tr1.start();



    }
}
