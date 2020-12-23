package aboutSerializable;

import java.io.Serializable;

public class Student implements Serializable {

    //1)Serializable маркерный интерфейс,
    // мы сказали что согласны с сериализацией объектов нашего класса
    private static final long serialVersionUID = 7510731779782274741L;//3) для совместимости JVM
    private Long id;
    private String name;
    private int score;
    private Book3 book;
   // private transient Book3 book;//2)transient при сериализации его пропускаем,


    public Book3 getBook() {
        return book;
    }

    public void setBook(Book3 book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student() {
    }

    public Student(Long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    public void info(){
        System.out.println(id + " " + name + " " + score);
    }
}
