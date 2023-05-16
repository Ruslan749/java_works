/*
    <<<<<<<<<<<<<<<<<<<<<<<<<< methods >>>>>>>>>>>>>>>>>>

    Method[] methods = personClass.getMethods() -- Возвращает только публичные методы беря в счет инкапсуляцию
    Method[] methods = personClass.getDeclaredMethods() --- Возвращает все методы

    getName() -- название метода
    getReturnType() -- какой тип данных возвращает метод
    getParameterTypes() -- какие параметры принимаются на вход метода

    <<<<<<<<<<<<<<<<<<<<<<<<<<<<< fields >>>>>>>>>>>>>>>>>>>>>>>>>>
    Field[] fields = personClass.getFields(); -- Возвращает только публичные поля беря в счет инкапсуляцию
    Field[] fields = personClass.getDeclaredFields() -- Возвращает все поля

    getName() -- имена поля
    getType() -- тип поля
* */

package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class reflection_1 {
    public static void main(String[] args) throws ClassNotFoundException {

        Person person = new Person();

        /// 1 способ получение класса как объект

        Class personClass = Person.class; // получили объект класса Peron

        /// 2 способ получение класса как объект

        Class peronClass2 = person.getClass();

        /// 3 способ получение класса как объект

        Class personClass3 = Class.forName("reflection.Person");

        // получаем методы класса

        Method[] methods = personClass.getMethods();
        for (Method method: methods){
            System.out.println(method.getName() + " >> "
                    + method.getReturnType() + " >> "
                    + Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("...........................................................................");

        // поля класса
        Field[] fields = personClass.getDeclaredFields();
        for (Field field: fields){
            System.out.println(field.getName() + " >> "
                    + field.getType());
        }

        System.out.println("...........................................................................");

        // получаем анотации класса

        Annotation[] annotations =  personClass.getAnnotations();

        for (Annotation annotation: annotations){
            if (annotation instanceof Author){ // проверяем есть ли такая анатация на слассе
                System.out.println("yes");
            } else {
                System.out.println("no");

            }
        }
    }

}
