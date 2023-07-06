package ru.Kopanov.api.Homework3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class homework3 {
    static Random random = new Random();
    static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int size = random.nextInt(10, 21);
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(-20, 20));
        }
        boolean flag = true;
        while (flag) {
            System.out.println(" Задание: \nПусть дан произвольный список целых чисел:" + arrayList + ".");
            System.out.println("""
                    1) Нужно удалить из него чётные числа
                    2) Найти минимальное значение
                    3) Найти максимальное значение
                    4) Найти среднее значение
                    
                    Введите номер задания или "5"- для выхода.
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    ArrayList<Integer> oddArray = delete_all_even(arrayList);
                    System.out.println("Результат: " + oddArray);
                }
                case 2 -> {
                    int min_value = findMinValue(arrayList);
                    System.out.println("Результат: " + min_value);
                }
                case 3 -> {
                    int max_value = findMaxValue(arrayList);
                    System.out.println("Результат: " + max_value);
                }
                case 4 -> {
                    float average_value = findAverageValue(arrayList);
                    System.out.println("Результат: " + average_value);
                }
                case 5 -> {
                    flag = false;
                }
                default -> System.out.println("Unexpected value: " + choice);
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> delete_all_even(ArrayList<Integer> arrayList){
        ArrayList<Integer> newArray = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) %2 != 0){
                newArray.add(arrayList.get(i));
            }
        }
        return newArray;
    }

    public static int findMinValue(ArrayList<Integer> arrayList){
        int min = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) < min){
                min = arrayList.get(i);
            }
        }
        return min;
    }

    public static int findMaxValue(ArrayList<Integer> arrayList) {
        int max = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > max) {
                max = arrayList.get(i);
            }
        }
        return max;
    }

    public static float findAverageValue(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
                sum += arrayList.get(i);
        }
        float average = (float) sum /arrayList.size();
        return average;
    }
}
