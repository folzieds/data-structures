package com.phos.ds;

import com.phos.contract.Queue;

import java.util.ArrayList;
import java.util.List;

public class ListQueue<X> implements Queue {

    private List<X> data;
    private int front = -1;

    public ListQueue(){
        data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void enQueue(Object newItem) {
        data.add((X)newItem);

    }

    @Override
    public X deQueue() {
        if(!data.isEmpty() && data.size() != front + 1)
            return data.get(++front);
        throw new IllegalStateException("Cannot Dequeue because queue is empty.");
    }

    @Override
    public boolean contains(Object item) {
        return data.contains(item);
    }

    @Override
    public Object access(int position) {
        if(data.size() == front + 1)
            throw new IllegalStateException("Queue is empty");

        int index =0;
        for(int i = front; i < data.size(); i++){
            if(index == position)
                return data.get(i);
            index++;
        }
        throw new IllegalArgumentException("Could not find any item at that position");
    }
}
