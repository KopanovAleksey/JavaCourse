package ru.Kopanov.api.Seminar1;

import java.util.Scanner;

public class Lesson1 {
    public static void main(String[] args) {
        printName();
    }

    static void printName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        System.out.printf("Привет, %s !", name);
        scanner.close();
    }

    static void task2() {
        int counter = 0;
        int max = 0;
        int[] array = { 1, 1, 0, 1, 1, 1, 0, 1 };
        for (int i : array) {
            if (i == 1)
                counter++;
            else{
                if (counter > max)
                    max = counter;
                    counter = 0;
            }
        }
    System.out.println(max);
    }
}
