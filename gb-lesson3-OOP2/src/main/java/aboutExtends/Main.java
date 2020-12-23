package aboutExtends;

public class Main {
    public static void main(String[] args) {
        Cat1 catA = new Cat1("Barsik");

        catA.voice();//1) Всегда объект вызывает метод БЛИЖЕ к объекту

        Animal2 a1 = new Cat2("Barsik");
        Animal2 a2 = new Dog2("Bobik");
        //2) можно прямо вызвать только методы которые объявлены в родителе
        //если хотим вызвать метод который объявлен в дочке нужно кастить (Cast)
        //3) для этого лучше проверять!(instanceof)
        if(a1 instanceof Cat2) {
            ((Cat2) a1).voice();
        }
        Animal2 catAA = new Cat2("Barsik");
        System.out.println(catAA);

        ///--------
        //4) сравнение
        Cat2 cat1 = new Cat2("Barsik");
        Cat2 cat2 = new Cat2("Barsik");
        System.out.println(cat1.equals(cat2));
    }
}
