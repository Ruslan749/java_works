/*                              РЕГУЛЯРНЫЙ ВЫРАЖЕНИЯ
    matches() --  на вход принимает строку  и сравнивает ее (возвращает boolean значение)
 или регулярное выражение
    split() -- разбивает выражение по заданному регулярному выражению и записывает их в массив
    replace(" ", ".") -- принимает 2 аргумента в виде строки
                                1) что заменить (строка)
                                2) на что заменить (строка)
    replaceAll("\\d+", "-") -- принимает на вход 2 аргумента:
                                1) что заменить (регулярное выражение)
                                2) на что заменить (строка)
    replaceFirst("\\d+", "-") -- принимает на вход 2 аргумента:
                                1) что заменить (регулярное выражение) первое что стоит впереди
                                2) на что заменить (строка)

                       + -- 1 или более
                       * -- 0 или более
                       ... ставятся перед регулярным выражением...
                       ? --  знак может быть или не быть (либо отрицательное, либо положительное число)
                       - -- отрицательное значение
                       () -- описывают вероятные вещи
                       | -- разделение и обозначение или
                       \\ --  если хотим использовать специальный символ как простой символ
                       [] -- описывает большие множества
                            [a-zA-Z] -- все английские буквы
                            [abc] = (a|b|c) -- либо a, либо b, либо с (синтаксис идентичен)
                            [0-9] = \\d
                            [^abc] -- значения которых быть не должно в строке иначе выпадет false (хотим все символы кроме перечисленных)
                        {} -- точное количество предыдущих символов
                            {2} --  два символа до
                            {2, } -- два или более символа
                            {2,4} -- от двух до четырех цифр
                        . -- любой символ
                    \\d -- одна цифра
                    \\w -- одна буква
                        \\w = [a-zA-Z]
 */
package Regexp;

import java.util.Arrays;

public class Regexp_1 {
    public static void main(String[] args) {
        String a = "-45";
        String b = "454545454";
        String c = "+444448488";

        System.out.println( a.matches("-\\d+"));
        System.out.println( b.matches("\\d+"));
        System.out.println( c.matches("(-|\\+)?\\d+"));

        String d = "qweq3qeq1we123456789";
        System.out.println( d.matches("[a-zA-Z31]+\\d+")); // до цифр может быть любое количество букв, а в буквах могут быть 3 и 1

        String e = "helalo";
        System.out.println( e.matches("[^abc]*"));

        String url = "http://www.google.com";
        System.out.println( url.matches("http://www\\..+\\.(com|ru)"));

        String f = "123";
        System.out.println( f.matches("\\d{2,}"));

        String z = "hello there hey";
        String[] words = z.split(" "); //  разделяет при помощи пробелов
        System.out.println(Arrays.toString(words));

        String v = "hello456456there4564654hey456465";
        String[] word = v.split("\\d+"); //  разделяет по числам
        System.out.println(Arrays.toString(word));

        String n = "hello there hey";
        String res = n.replace(" ", "."); // меняем пробелы на точки
        System.out.println(res);

        String m = "4654654hello456456465465there4654846hey";
        String resa = m.replaceAll("\\d+", "-"); // меняем цифры на тире
        System.out.println(resa);

        String p = "456465hello456456465465there4654846hey";
        String resault = p.replaceFirst("\\d+", "-"); // меняем только первые цифры на тире
        System.out.println(resault);
    }
}
