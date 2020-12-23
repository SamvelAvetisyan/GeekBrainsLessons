package tasks;
/*
Создать класс, который может запускать (выполнять) «тесты».
В качестве тестов выступают классы с наборами методов, снабженных аннотациями @Test.
 Класс, запускающий тесты, должен иметь статический метод start(Class testClass),
 которому в качестве аргумента передается объект типа Class. Из «класса-теста» вначале должен
  быть запущен метод с аннотацией @BeforeSuite, если он присутствует. Далее запускаются методы
   с аннотациями @Test, а по завершении всех тестов – метод с аннотацией @AfterSuite.

К каждому тесту необходимо добавить приоритеты (int-числа от 1 до 10), в соответствии с
которыми будет выбираться порядок их выполнения. Если приоритет одинаковый, то порядок не имеет
 значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном
  экземпляре. Если это не так – необходимо бросить RuntimeException при запуске «тестирования».

 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class TestRunner {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
start(Tests.class);
    }
    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {
        Class c = Tests.class;
        Method[] methods = c.getDeclaredMethods();

        ArrayList<Method> listMethodsWithBefore = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(BeforeSuite.class))
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Method> listMethodsWithAfter = Arrays.stream(methods)
                .filter(method->method.isAnnotationPresent(AfterSuite.class))
                .collect(Collectors.toCollection(ArrayList::new));
        Map<Method, Integer> mapMethodsTestWithPriority= Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(Test.class))
                .collect(Collectors
                        .toMap(method -> method, method -> method.getAnnotation(Test.class).priority()));
        Map<Method, Integer> sortedByPriority = mapMethodsTestWithPriority.entrySet().stream()
                .sorted(comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

        if(listMethodsWithBefore.size()>1){
            throw new RuntimeException("количество методов которые отмечены @BeforeSuite " +
                    "должно быть 1");
        }
        if(listMethodsWithBefore.size() != 0){
            listMethodsWithBefore.get(0).invoke(new Tests());
        }

        for (Method method : sortedByPriority.keySet()){
            method.invoke(new Tests());
        }

        if(listMethodsWithAfter.size()>1){
            throw new RuntimeException("количество методов которые отмечены  @AfterSuite " +
                    "должно быть 1");
        }
        if(listMethodsWithAfter.size() != 0){
            listMethodsWithAfter.get(0).invoke(new Tests());
        }
    }
}
