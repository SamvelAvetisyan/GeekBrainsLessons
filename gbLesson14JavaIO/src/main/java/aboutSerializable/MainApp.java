package aboutSerializable;

import java.io.*;

public class MainApp {
    public static void main(String[] args) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("stud.txt"))){
            Student student = new Student(1L,"Bob",100);
            Student student2 = new Student(2L,"Bob2",99);
            Book3 book = new Book3("Jungle Book");//4)создали книгу
            student.setBook(book);//)5)даем студенту
            student2.setBook(book);
            out.writeObject(student);//2)мы закинули в файл объект student
            out.reset();//6) reset снимает галочки, не сохраняли
            book.setTittle("Jungle book2");
            out.writeObject(student2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //1)ObjectOutputStream потоки которые позволяют работать с объектами(записать объекты)

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("stud.txt"))){
            Student studentFromFile = (Student) in.readObject();
            Student studentFromFile2 = (Student) in.readObject();

            studentFromFile.info();
            studentFromFile2.info();
            System.out.println(studentFromFile.getBook());
            System.out.println(studentFromFile2.getBook());
        } catch (Exception e){
            e.printStackTrace();
        }
    }//3)мы получили(прочитали) объект с файла
}

