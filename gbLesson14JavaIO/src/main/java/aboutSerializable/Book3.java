package aboutSerializable;

import java.io.Serializable;

public class Book3 implements Serializable {
    private String Tittle;

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public Book3(String tittle) {
        Tittle = tittle;
    }

    @Override
    public String toString() {
        return "Book3{" +
                "Tittle='" + Tittle + '\'' +
                '}';
    }
}
