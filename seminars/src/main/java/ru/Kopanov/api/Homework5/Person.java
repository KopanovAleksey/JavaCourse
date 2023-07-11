package ru.Kopanov.api.Homework5;

public class Person {
    String name;
    String surname;
    int number;
    public Person( String name, String surname, int number){
        this.name = name;
        this.surname = surname;
        this.number = number;
    }
    @Override
    public String toString(){
        return surname + " " + name + " " + number;
    }
}
