package ru.Kopanov.api.Homework4;

import ru.Kopanov.api.Homework2.Homework2;

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class homework4 {
static Random random = new Random();
static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        task1();
//        task2();
        task3();
    }

// 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
    public static void task1(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < random.nextInt(5, 20); i++) {
            linkedList.add(random.nextInt(-10, 10));
        }
        System.out.println(linkedList);
        linkedList = LinkedListReverse(linkedList);
        System.out.println(linkedList);

    }

    public static LinkedList<Integer> LinkedListReverse(LinkedList<Integer> list){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (Object e: list) {
            linkedList.addFirst((int)e);
        }
        return linkedList;
    }

//    2 *. Реализуйте очередь с помощью LinkedList со следующими методами:
//    enqueue() - помещает элемент в конец очереди,
//    dequeue() - возвращает первый элемент из очереди и удаляет его,
//    first() - возвращает первый элемент из очереди, не удаляя.
    public static void task2(){
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < random.nextInt(10, 20); i++) {
            myQueue.enqueue(random.nextInt(-10, 10));
        }
        myQueue.print();
        while (myQueue.length() > 3){
            System.out.println();
            System.out.println(myQueue.dequeue());
            myQueue.print();
        }
        System.out.println(myQueue.first());
    }

//    3. В калькулятор (урок 1 и 2) добавьте возможность отменить последнюю операцию.

    public static void task3(){

        System.out.println("Welcome to a simple calculator !\n");
        Stack<String> stack = new Stack<>();
        boolean flag = true;
        boolean dataChangeMode = false;
        while (flag) {
            while (flag && !dataChangeMode) {
                int choice;
                System.out.println("Введите:\n1 - для работы с калькулятором в построчном режиме;\n2 - для работы с калькулятором в режиме изменения данных;\n3 - для выхода.\n");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    break;
                } else if (choice == 2) {
                    dataChangeMode = true;
                } else if (choice == 3) {
                    flag = false;
                    System.out.println("Goodbye !\n");
                } else {
                    System.out.println("Wrong input !\n");
                }
            }
            if (flag) {
                double first_number;
                if (stack.isEmpty() || !dataChangeMode) {
                    System.out.print("Введите первое число: ");
                    first_number = Double.parseDouble(scanner.nextLine());
                } else {
                    first_number = Double.parseDouble(stack.peek());
                    System.out.println("Результат предидущей операции: " + first_number);
                }
                System.out.print("Введите оператор (+, -, *, /, ^):");
                String operator = scanner.nextLine();
                System.out.print("Введите второе число: ");
                double second_number = Double.parseDouble(scanner.nextLine());
                String result;
                switch (operator) {
                    case "+" -> {
                        result = Double.toString(first_number + second_number);
                    }
                    case "-" -> {
                        result = Double.toString(first_number - second_number);
                    }
                    case "*" -> {
                        result = Double.toString(first_number * second_number);
                    }
                    case "/" -> {
                        if (second_number == 0) {
                            result = "Error: Zero division !";
                            break;
                        }
                        result = Double.toString(first_number / second_number);
                    }
                    case "^" -> {
                        result = Double.toString(Math.pow(first_number, second_number));
                    }
                    default -> {
                        result = "Wrong operator input !";
                    }
                }
                System.out.printf("%.2f %s %.2f = %s\n", first_number, operator, second_number, result);
                if (isDouble(result)) {
                    stack.add(result);
                }
                while (dataChangeMode){
                    int option;
                    System.out.println("Введите:\n1 - для продолжения работы с калькулятором в режиме изменения данных;\n2 - для выхода из режима.\n");
                    option = Integer.parseInt(scanner.nextLine());
                    if (option == 1) {
                        break;
                    } else if (option == 2) {
                        dataChangeMode = false;
                    } else {
                        System.out.println("Wrong input !\n");
                    }
                }
            }
        }
    }

    private static boolean isDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
