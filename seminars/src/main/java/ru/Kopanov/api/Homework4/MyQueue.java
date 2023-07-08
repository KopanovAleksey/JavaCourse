package ru.Kopanov.api.Homework4;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyQueue {
    private LinkedList<Integer> elements = new LinkedList();

    public void enqueue(int e){
        elements.add(e);
    }
    public int dequeue(){
        if (elements.size() == 0)
            throw new EmptyStackException();
        return elements.remove(0);
    }

    public int first(){
        if (elements.size() == 0)
            throw new EmptyStackException();
        return elements.get(0);
    }

    public void print(){
        System.out.println(elements);
    }

    public int length(){
        return elements.size();
    }
}
