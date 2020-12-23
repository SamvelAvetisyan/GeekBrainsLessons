import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//1) чтобы создать свою аннотацию к ней нужно подключить 2 аннотации

@Retention(RetentionPolicy.RUNTIME)//2)указывает где доступна наша аннотация
@Target(ElementType.METHOD)//3)указывает куда можно прицепить аннотацию
//здесь мы указали что аннотация можно принимать к любому методу)

public @interface MyAnnotation4 {
    //4)мы можем в Аннот. закинуть какие то настройки, например указать какой то таймАут
    int timeout();
    //5) если не обязательно указать внутренности Аннотации (default)
    String strData() default "Java";
}

