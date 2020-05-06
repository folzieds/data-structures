package com.phos.models;

import com.phos.contract.Stack;

public class BasicStack<X> implements Stack {

    private int stackPointer;
    private X [] data;

    public BasicStack(){
        stackPointer = 0;
        data = (X[]) new Object[1000];
    }

    @Override
    public void push(Object newItem){
        data[stackPointer++] = (X)newItem;
    }

    @Override
    public X pop(){
        if(stackPointer == 0){
            throw new IllegalStateException("No more items on the stack");
        }
        return data[--stackPointer];
    }

    @Override
    public boolean contains(Object item){

        for(int i = 0; i < stackPointer; i++){
            if(data[i] == item)
                return true;
        }

        return false;

    }

    @Override
    public X access(Object item){
        while (stackPointer > 0){
            X tempItem = pop();
            if(item.equals(tempItem))
                return tempItem;
        }
        throw new IllegalArgumentException("could not find item on the stack " + item);
    }

    @Override
    public int size(){
        return stackPointer;
    }
}
