package Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp_2 {
    public static void main(String[] args) {
        String text = "Hello guys! I send you email joe@gmail.com so we can \n" +
                "keep in touch. Thanks Joe! That`s cool. I am sending you \n" +
                "my address tim@yandex.ru. Let`s stay in touch..." ;

        Pattern email = Pattern.compile("\\w+@(gmail|yandex)\\.(com|ru)"); // создаем потерн регулярного выражения
        Matcher matcher = email.matcher(text); // передаем в объект наше регулярное выражение и текст

        while (matcher.find()){ // пока не равно false (нет больше совпадений)
            System.out.println(matcher.group()); // получим совпадения
        }
    }
}
