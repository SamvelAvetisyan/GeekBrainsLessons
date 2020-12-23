package aboutExtends;

import java.util.Objects;

public class Cat2 extends Animal2 {
    String name;
    int age;

    public Cat2(String name) {
        this.name = name;
        this.age = 1;
    }
    @Override
    public void voice() {
        System.out.println(name + " мякует");
    }

//    @Override
//    public String toString() {
//        return "AA_Cat{" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                '}';
//    }

  //1) переопределим toString - который отвечает за преобразование объекта в строку

    @Override
    public String toString() {

        return String.format("Cat [name = %s, age = %d]", name, age);
    }

    //2) для сравнения объектов нужно переопределить метод equals(Alt+Insert)
    @Override
    public boolean equals(Object o) {//4) equals принимает Object потому что он определен вObject
        if (this == o) return true;//5)здесь проверяется ссылки, если они == то явно наш объекты ==
        if (o == null || getClass() != o.getClass()) return false;//6) понятно
        return this.age == ((Cat2)o).age && this.name.equals(((Cat2)o).name);
     }

    @Override
    public int hashCode() {
        return name.hashCode() + Objects.hash(age);//7) добавили про name
    }
}
