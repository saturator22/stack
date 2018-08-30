package com.codecool;

public class Stack<T> {

    T[] array;
    int pointer;
    int size;

    public Stack(int size) {
        this.size = size;
        this.array = (T[]) new Object[size];
        this.pointer = -1;
    }

    public int freeSpacesLeft() {
        return size - pointer - 1;
    }

    public T peek() {
        return this.array[pointer];
    }

    public T pop() throws Exception {
        if(isStackEmpty()) {
            throw new Exception("Stack is empty");
        }

        T data = this.array[pointer--];

        return data;
    }

    public void push(T data) {
        if(isStackFull()) {
            throw new StackOverflowError("Stack is full");
        }

        this.array[++pointer] = data;
    }

    private boolean isStackEmpty() {
        return(pointer == -1);
    }

    private boolean isStackFull() {
        return(pointer == size -1);
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
