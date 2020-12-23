package aboutExtends;

public class Cat1 extends Animal1 {
   public Cat1(String name){
       //2) здесь в первую очередь вызывается конструктор Родителя (super())
      //3)super() всегда вызывается Первым
       //super();
       //4) при создании объекта конструкторы вызывается по цепочке сверху вниз,
       // первым верхний родитель потом его потомок потом потомок потомка и т.д.
       this.name = name;
    }

    @Override
    public void voice() {
      // super.voice();//1) если так написать он сначала будет вызвать родительский метод
        // потом переопределенный
        System.out.println(name + " мякует");
    }
}
