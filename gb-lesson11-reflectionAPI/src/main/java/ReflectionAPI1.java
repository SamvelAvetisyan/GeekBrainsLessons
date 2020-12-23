import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionAPI1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1) как получить ссылку на класс(например класс String)
        Class<?> c1 = String.class;//1-1) вариант, через имя класса
        Class<?> c2 = "any".getClass();//1-2 вариант, через объект класса
        Class<?> c3 = Class.forName("java.lang.String");//1-3 вариант, через полное имя класса
        System.out.println(c1.getSimpleName());
        System.out.println(c1.getName());
        System.out.println(c1.getModifiers());
        System.out.println(Modifier.isPublic((c1.getModifiers())));
        System.out.println(c1.getSuperclass());
        System.out.println(Arrays.toString(c1.getInterfaces()));
        System.out.println(".....");

       //2) можем спросить класс у void, int, short, array...
        System.out.println(int.class.getName());//sout int
        System.out.println(void.class.getName());//sout void
        System.out.println(int[].class.getName());//sout [I
        System.out.println(Character[][].class.getName());//sout [[Ljava.lang.Character;

    }
}
