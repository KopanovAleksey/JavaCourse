package ru.Kopanov.api.Homework6;

import java.util.HashSet;

public class program{
   public static void main(String[] args) {
        Cat cat1 = new Cat("Мейнкун","Берендей","male",
                                                     "grey", 10);
        Cat cat2 = new Cat("Мейнкун","Берендей","male",
                                                     "grey", 10);
        Cat cat3 = new Cat("Сфинкс", "Кузя", "female", "pink", 6);
        System.out.println(cat1.equals(cat2));

        HashSet<Cat> cats = new HashSet<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        System.out.println(cat1.toString().hashCode());
        System.out.println(cat2.toString().hashCode()); 
        System.out.println(cats);    
    } 
}
