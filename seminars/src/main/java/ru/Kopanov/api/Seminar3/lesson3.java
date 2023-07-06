package ru.Kopanov.api.Seminar3;

import java.util.*;

public class lesson3 {
    static Random random = new Random();
    static ArrayList<ArrayList<String>> catalog = new ArrayList<>();
    static void task1(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int size = random.nextInt(10, 21);
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(-9, 10));
        }
        System.out.println("Before: " + arrayList);
        Collections.sort(arrayList);
        System.out.println("After: " + arrayList);
    }
    static void task2(){
        addBook("Поэма", "Книга 1");
        addBook("Поэма", "Книга 2");
        addBook("Поэма", "Книга 3");
        addBook("Проза", "Книга 1");
        addBook("Проза", "Книга 2");
        addBook("Док", "Книга 1");
        printCatalog();
    }
    static void addBook(String genre, String bookName){
        for (ArrayList<String> books: catalog) {
            if (books != null && books.size() > 0 && books.get(0).equals(genre)){
                books.add(bookName);
                return;
            }
        }
        ArrayList<String> books = new ArrayList<>();
        books.add(genre);
        books.add(bookName);
        catalog.add(books);
    }
    static void printCatalog(){
        int i = 0;
        boolean hasBook =true;
        while (hasBook){
            hasBook = false;
            for (ArrayList<String> books: catalog) {
                if (books != null && books.size() > i){
                    hasBook = true;
                    System.out.printf("%s\t\t", books.get(i));
                }
            }
            System.out.println();
            i++;
        }

    }

    public static void main(String[] args) {
//        Person person = new Person();
//        person.age = 2;
//        person.name = "Jija";
//
//        ArrayList arrayList1 = new ArrayList();
//        arrayList1.add("Hello!");
//        arrayList1.add(false);
//        arrayList1.add(person);
//        doProcess(arrayList1);
//        ArrayList<Person> arrayList2= new ArrayList<>();
//        arrayList2.add(person);
        task2();

    }
    static void doProcess(ArrayList list){
        for (Object o: list){
            if (o instanceof Person) {
                Person P = (Person) o;
                System.out.println("Возраст " + P.age);
            }
        }
    }


}
class Person{
    String name;
    int age;
}