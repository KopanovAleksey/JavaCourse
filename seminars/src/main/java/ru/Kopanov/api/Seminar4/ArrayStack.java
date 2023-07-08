package ru.Kopanov.api.Seminar4;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStack {
    static final int CAPACITY = 1000;
    private int[] data;
    private int topIndex = -1;

    public ArrayStack(){
        data = new int[CAPACITY];
    }
    public ArrayStack(int capacity){
        if (capacity < 0)
            throw new IllegalArgumentException();
        data = new int[capacity];
    }

    public int size(){
        return topIndex + 1;
    }

    public boolean empty(){
        return topIndex == -1;
    }

    public void push(int e){
        if (size() == data.length)
            throw new StackOverflowError("Переполнение стека. Невозможножно добавить элемент.");
        data[++topIndex] = e;
    }

    public int peek(){
        if (empty())
            throw new EmptyStackException();
        return data[topIndex];
    }

    public int pop(){
        if (empty())
            throw new EmptyStackException();
        return data[topIndex--];
    }

}
