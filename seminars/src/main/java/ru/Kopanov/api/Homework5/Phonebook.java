package ru.Kopanov.api.Homework5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Phonebook {
    HashMap<String, ArrayList<Person>> phonebook = new HashMap<>();

    public void add(Person newPerson){
        if(phonebook.containsKey(newPerson.surname)) {
            phonebook.get(newPerson.surname).add(newPerson);
        }else {
            ArrayList<Person> newSurnameArrayList = new ArrayList<>();
            newSurnameArrayList.add(newPerson);
            phonebook.put(newPerson.surname, newSurnameArrayList);
        }
    }

    public ArrayList<Person> get(String surname) {
        return phonebook.get(surname);
    }

    public void showBook(){
        TreeMap<String, ArrayList<Person>> sortedPhonebook = new TreeMap<>(phonebook);
        for (Map.Entry<String, ArrayList<Person>> item: sortedPhonebook.entrySet()) {
            for (Person person:item.getValue()) {
                System.out.println(person);
            }
        }
    }
}
