package com.phos.models;

import com.phos.contract.Queue;

public class BasicQueue<X> implements Queue {

    private X[] data;
    private int front;
    private int end;

    public BasicQueue(){
        this(1000);
    }
    BasicQueue(int size){
        this.front = -1;
        this.end = -1;
        data = (X[]) new Object[size];
    }

    @Override
    public int size(){
        // if the queue is empty return 0
        if(front == -1 && end == -1)
            return 0;
        // if it is not empty return the difference plus one to show the inclusive value
        else
            return end - front + 1;
    }

    @Override
    public void enQueue(Object newItem){
        if((end + 1) % data.length == front)
            throw new IllegalStateException("Queue is full");
        else if(size() == 0){
            front++;
            end++;
            data[end] = (X)newItem;
        }
        else {
            end++;
            data[end] = (X)newItem;
        }

    }

    @Override
    public X deQueue(){
        X item;
        if(size() == 0)
            throw new IllegalStateException("Cannot deque because the queue is empty");
        else if (front == end){
            item = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        }
        else{
            item = data[front];
            data[front]= null;
            front++;
        }
        return item;
    }

    @Override
    public boolean contains(Object item){
        if(size() == 0)
            return false;
        for(int i = 0; i < size(); i++){
            if(data[i].equals(item))
                return true;
        }
        return false;
    }

    @Override
    public X access(int position){
        if(size() == 0 || position >= size())
            throw new IllegalArgumentException("Queue is either empty or the postion entered is bigger than the queue");

        int index =0;
        for(int i = front; i <end; i++){
            if(index == position)
                return data[i];
            index++;
        }
       throw new IllegalArgumentException("Could not find any item at that position");

    }
}
