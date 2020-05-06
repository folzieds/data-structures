package com.phos.models;

import com.phos.contract.Stack;

import java.util.ArrayList;
import java.util.List;

public class ListStack<X> implements Stack {

    private List<X> data;

    public ListStack(){
        data =  new ArrayList<>();
    }

    @Override
    public void push(Object newItem) {
        data.add((X)newItem);
    }

    @Override
    public X pop(){
        if(data.size() == 0){
            throw new IllegalStateException("No more items on the stack");
        }
        return data.remove(data.size()-1);
    }

    @Override
    public boolean contains(Object item) {
        return data.contains((X)item);
    }

    @Override
    public X access(Object item){
        while (data.size() > 0){
            X tempItem = pop();
            if(item.equals(tempItem))
                return tempItem;
        }
        throw new IllegalArgumentException("could not find item on the stack " + item);
    }

    @Override
    public int size(){
        return data.size();
    }
}
