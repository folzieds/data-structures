package com.phos.contract;

public interface Queue<X> {
    public int size();

    public void enQueue(X newItem);

    public X deQueue();

    public boolean contains(X item);

    public X access(int position);
}
