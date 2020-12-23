package aboutInnerClass;

public class Main {
    public static void main(String[] args) {
        new aboutInnerClass.Outer(8).new Inner(7);//5)объекты внутреннего класса
        // обязательно привязаны к какому то объекту внешнего класса
        //без объекта внешнего класса они не могут существовать
        //5-1)это объект внутреннего класса (так создается)
    }
}
