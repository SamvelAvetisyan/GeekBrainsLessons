import java.lang.reflect.*;

public class AboutCat2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Class c = Cat2.class;//1) получили ссылку на класс

        //1)получить методы
        Method[] methods = c.getDeclaredMethods();
        for (Method ele: methods){
            System.out.println(ele);
        }
        Cat2 cat = new Cat2("Barsik", "White", 10);
        //2) можем вызвать любой метод из Cat2 через Reflection API!
        Method mPublicInfo = c.getDeclaredMethod("publicInfo");//2-1) получили ссылку на метод
        mPublicInfo.invoke(cat);//2-2)через invoke(вызов) можем вызвать метод у объекта
        Method mAdd = c.getDeclaredMethod("add", int.class, int.class);
        System.out.println(mAdd.invoke(cat,10, 20));//2-3) здесь вызвали метод
        // с параметрами, если метод в Cat2 будет статик, то вместе объекта(cat) напишем null

        //3) вызов private метода
        Method mPrivateInfo = c.getDeclaredMethod("privateInfo");
        mPrivateInfo.setAccessible(true);//3-1) мы здесь через рефлексию даем доступ к private методу
        mPrivateInfo.invoke(cat);

        //4)можем получить инфо о модификаторе доступа
        int methodModifByte = c.getDeclaredMethod("add",int.class,int.class)
                .getModifiers();//4-1)получили Byte модификатора
        System.out.println(methodModifByte);
        System.out.println(Modifier.isPublic(methodModifByte));//4-2 здесь проверяем тип модификатора

        //5) запросим значение поля
        Field field = c.getDeclaredField("color");//5-1) запросили поле
        System.out.println(field.get(cat));//5-2) запросили значение поля

        //6) можем запросить список конструкторов класса
        Constructor[] constructors = c.getDeclaredConstructors();
        for(Constructor ele: constructors) {
            System.out.println(ele);
        }
        Constructor<Cat2> constructor = c.getConstructor(String.class,String.class,int.class);
        System.out.println(constructor);

        //7) добавить новый список аргументов в конструктор из Cat2, то есть создать новый
        //объект (cat2)
        Cat2 cat2 =(Cat2) c.getDeclaredConstructor(String.class,String.class,int.class)
                .newInstance("Murzik", "black",12);
        cat2.publicInfo();
        System.out.println("----");
        printHierarchy(c);
    }
    //8) получим иерархию
    public static void printHierarchy(Class<?> clazz){
        while (clazz != null){
            clazz = clazz.getSuperclass();
            System.out.println(clazz);
        }
    }
}

