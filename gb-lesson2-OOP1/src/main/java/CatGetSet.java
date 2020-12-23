public class CatGetSet {
    private String name;
    private String color;
    private int age;

//1)Getter позволяет СНАРУЖИ узнать значение поля!Тип поля и тип Getter-а должны совподать
//2) Setter позволяет СНАРУЖИ изменить значение поля, Setter возьмет значение поля (this.name)
    //и заменяет на то, что попало в аргументе Setter (name)
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }


    public CatGetSet(){
        this.name = "UnName";
        this.color = "UnName";
        this.age = 0;
    }
    public CatGetSet(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
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

