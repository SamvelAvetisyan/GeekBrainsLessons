package aboutInnerClass;

public class Outer {
    //3)внешний класс не имеет доступ к полям и методам внутренного ласса
    //4)статики имеют доступ друг другу

    public class Inner {//1)Объявили внутренний класс
        private int innerX;

        public Inner(int innerX) {
            this.innerX = innerX;
        }
        //2)внутренний класс имеет доступ к полям и методам внешнего класса
        public void innerMethod() {
            System.out.println(innerX);
            System.out.println(outerX);
            outerMethod();
        }
    }

    private int outerX;

    public Outer(int outerX) {
        this.outerX = outerX;
    }

    public void outerMethod() {

    }
}
