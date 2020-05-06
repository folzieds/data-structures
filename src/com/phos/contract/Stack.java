package com.phos.contract;

public interface Stack<X> {

     public void push(X newItem);

     public X pop();

     public boolean contains(X newItem);

     public X access(X newItem);

     public int size();
}
