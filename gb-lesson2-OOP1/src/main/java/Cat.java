public class Cat {


    private String name;
    private String color;
    private int age;
    //1)чтобы инициализировать поля создаем конструктор

    public Cat(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }
    //3)this.name = name; говорит что мое Поле name должно быть равно Аргументу name

    //4)мы можем внутри {} указать начальные значения, но этот поле не
    //должен быть в (), то есть в аргументе
    public Cat(){
        this.name = "UnName";
        this.color = "UnName";
        this.age = 0;
    }

    public void mew(){
        System.out.println(name + "say mew");
    }
    public void jump(){
        System.out.println(name + "Jumping");
    }
    public void info(){
        System.out.printf("Cat = [name = %s, color = %s, age = %d ]%n", name, color, age);
    }
}
