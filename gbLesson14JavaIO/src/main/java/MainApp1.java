import java.io.*;


public class MainApp1 {
    public static void main(String[] args) {

        File file = new File("5");
//        System.out.println(file.exists());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getName());
//        System.out.println(file.getParent());
//        System.out.println(file.getPath());
//        System.out.println(file.lastModified());
//        System.out.println(file.length());

        File fileDirectory = new File("2");
//        Boolean b = fileDirectory.isDirectory();
//        System.out.println(b);
        System.out.println(fileDirectory.listFiles().length);
//        file.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return false;
//            }
//        });
       // file.mkdirs();
    }
}
