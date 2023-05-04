package anatation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // ограничиваем использование аннатации только для методов
@Retention(RetentionPolicy.RUNTIME) //  ограничиваем политику удержания
public @interface MethodInfo {
    String author() default "Ruslan";
    int dateOfCreation() default 2021;
    String purpose();
}
