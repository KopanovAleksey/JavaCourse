package ru.Kopanov.api.Seminar6;

import java.util.*;

public class seminar6 {
    public static void main(String[] args) {
    task4();
    }
    private static Random random = new Random();
    public static void task1(){
        HashSet<Integer> hashSet= new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        int size = random.nextInt(10, 21);
        System.out.println("Общеее кол-во элементов: " + size);
        for (int i = 0; i < size; i++){
            int number = random.nextInt(-9,9);
            System.out.printf("%d ", number);
            hashSet.add(number);
            linkedHashSet.add(number);
            treeSet.add(number);
        }
        System.out.println();
        System.out.println("hashSet" + hashSet);
        System.out.println("linkedHashSet" + linkedHashSet);
        System.out.println("treeSet" + treeSet);
    }

    public static void task2(){
        Integer[] array = new Integer[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 25);
        }
        task3(array);
    }

    public static void task3(Integer[] array){
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(array));
        System.out.println("% уникальных чисел: " + (double)hashSet.size()*100/ array.length);
    }

    public static void task4(){
        Fraction fraction1 = new Fraction();

        Fraction fraction2 = new Fraction(1, 4);
        System.out.println(fraction1);
        System.out.println(fraction2);

        System.out.printf("%s + %s = %s\n", fraction1, fraction2, Fraction.plus(fraction1,fraction2));

        HashSet<Fraction> hashSet = new HashSet<>();
        hashSet.add(new Fraction(3, 4));
        hashSet.add(new Fraction(4, 4));
        hashSet.add(new Fraction(3, 6));
        hashSet.add(new Fraction(2, 5));
        hashSet.add(new Fraction(3, 4));
        hashSet.add(new Fraction(3, 7));
        hashSet.add(new Fraction(3, 4));

        System.out.println(new Fraction(3, 4).equals(new Fraction(3,4)));

        System.out.println(hashSet);
    }
}
