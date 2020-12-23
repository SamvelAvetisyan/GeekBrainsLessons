public class Cat2 {
    private String name;
    String color;
    public int age;

    public Cat2(){}

    public Cat2(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public  void publicInfo(){

        System.out.println(name + " " + color + " " + age);
    }
    void defaultInfo(){

        System.out.println(name + " " + color + " " + age);
    }
     private void privateInfo(){

        System.out.println(name + " " + color + " " + age);
     }
     public int add(int a, int b){

        return a+b;
     }
}
