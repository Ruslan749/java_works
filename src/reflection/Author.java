package reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) // ограничиваем использование аннатации только для методов
@Retention(RetentionPolicy.RUNTIME) //  ограничиваем политику удержания
public @interface Author {
    String name();

    int dateCreation();
}
