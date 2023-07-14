package ru.Kopanov.api.Homework6;

import java.util.Objects;

public class Cat {
    private String breed;
    private String nickName;
    private String sex;
    private String color;
    private int age;

    public Cat(String breed, String nickName, String sex, String color, int age){
        this.breed = breed;
        this.nickName = nickName;
        this.sex = sex;
        this.color = color;
        this.age = age;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat)o;
        return breed.equals(cat.breed)&&
                nickName.equals(cat.nickName)&&
                sex.equals(cat.sex)&&
                color.equals(cat.color)&&
                (age == cat.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, nickName, sex, color, age);
    } 


    @Override
    public String toString(){
        return String.format("{Порода: %s; Кличка: %s; Пол: %s; Окрас: %s; Возраст: %d}", 
                                breed, nickName, sex, color, age);
    }
    
}
