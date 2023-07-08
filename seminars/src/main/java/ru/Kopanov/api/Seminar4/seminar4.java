package ru.Kopanov.api.Seminar4;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class seminar4 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        ArrayList<UUID> arrayList = new ArrayList<>();
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//           arrayList.add(UUID.randomUUID());
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("Операция выполнениа за: " + (endTime - startTime));
//
//        LinkedList<UUID> linkedList= new LinkedList<>();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            linkedList.add(UUID.randomUUID());
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("Операция выполнениа за: " + (endTime - startTime));

//        task1();
//        task2();
        task3();
    }

    public static void task1(){

        LinkedList<String> linkedList = new LinkedList<>();

    while (true){
        System.out.println("Введите строку: ");
        String inputString = scanner.nextLine();
        if (inputString.isEmpty()){
            System.out.println("Завершение работы программы.");
            break;
        }

        String[] parts = inputString.split("~");
        Integer num;
        if (parts.length != 2 || (num = tryParseInt(parts[1])) == null){
            System.out.println("Строка указана неверно. Повторите попытку ввода.");
            continue;
        }
        if (parts[0].equals("print")){
            System.out.printf("Удаление элемента \"%s\"\n", linkedList.remove((int)num));
        } else {
//            if (num >= 0 && num < linkedList.size()){
//                linkedList.add(num, parts[0]);
//            }
//            else {
//                linkedList.add(0, parts[0]);
//            }
            linkedList.add(num >= 0 && num < linkedList.size() ? num: 0, parts[0]);
        }
        System.out.println();
        System.out.println("Элементы списка");
        System.out.println("~~~~~~~~~~~~~~~");
        System.out.println(linkedList);
        System.out.println();

    }
    }

    public static void task2(){
        Deque deque = new ArrayDeque();
        while (true){
            System.out.println("Введите строку: ");
            String inputString = scanner.nextLine();
            if (inputString.isEmpty()){
                System.out.println("Завершение работы программы.");
                break;
            }
            switch (inputString){
                case "print":
                    for (Object e:deque) {
                        System.out.println(e);
                    }
                    System.out.println("~~~~~~~~~~~");

//                    Iterator iterator = deque.iterator();
//                    while (iterator.hasNext()){
//                        System.out.println(iterator.next());
//                    }
                    break;
                case "revert":
                    deque.pollFirst();
                    break;
                default:
                    deque.push(inputString);
                    break;
            }
        }
    }

    public static void task3(){
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(5);
        arrayStack.push(6);
        arrayStack.push(7);
        arrayStack.push(8);
        arrayStack.push(9);
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());


    }

    static Integer tryParseInt(String text){
        try {
            return Integer.parseInt(text);
        }
        catch (NumberFormatException e){
            return null;
        }
    }
}
