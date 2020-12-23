package aboutExtends;

public class Dog1 extends Animal1 {
    public Dog1(String name){
        this.name = name;
    }

    @Override
    public void voice() {
        System.out.println(name + " гавкает");
    }
}
