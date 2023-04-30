/*
        СТЭК
возвращаеться последний добавленый список
    push -- добавляет элименты
    pop -- достает элименты из стека
    peek -- показывает элимент но не извлекает его
 */
package collections.stack;

import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(1);

        System.out.println("получение последнего добавленого элимента:  " + stack.pop());
        System.out.println("Просмотр элимента: " +stack.peek());
    System.out.println("получение элиментов через цикл: ");
//        выведение всех элиментов из стека
        while (!stack.empty()){
            System.out.println("--> " + stack.pop());
        }
    }

}
