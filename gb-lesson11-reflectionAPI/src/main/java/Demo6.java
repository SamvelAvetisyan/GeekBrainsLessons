import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo6 {
    //1) для того чтобы использовать нашу Аннотацию нужно написать обработчик Аннотации
    //(for{})это и есть обработчик
    //2) нам нужно из Demo5 вызвать методы которые отмечены Аннотацией
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class demoClass = Demo5.class;//3)получили ссылку на класс Demo5
        Method[] methods = demoClass.getDeclaredMethods();//4) мы получаем список методов которые есть у Demo5
        //5)теперь нужно узнать какие методы помечены аннотацией а какие нет
        for (Method ele: methods){
            if(ele.isAnnotationPresent(MyAnnotation4.class)){
                //7)узнаем какой таймаут указан для этого метода
                System.out.println("timeout is: " + ele.getAnnotation(MyAnnotation4.class).timeout());
                //8)здесь у метода(ele) говорим дай свою Аннотацию (getAnnotation) timeout()
                // даем ссылку нашей аннотации(MyAnnotation4.class) и вызываем
                System.out.println("strData is: " + ele.getAnnotation(MyAnnotation4.class).strData());
                ele.invoke(null);//6) мы вызвали все методы которые помечены MyAnnot...
            }
        }
    }
}



