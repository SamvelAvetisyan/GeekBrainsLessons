package aboutExtends;

public class Dog2 extends Animal2 {
    public Dog2(String name){
        this.name = name;
    }

    @Override
    public void voice() {
        System.out.println(name + " гавкает");
    }
}
