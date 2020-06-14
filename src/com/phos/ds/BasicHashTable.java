package com.phos.ds;

public class BasicHashTable<X,Y> {

    private HashEntry[] data;
    private int capacity;
    private int size;

    public BasicHashTable(int capacity) {
        this.capacity = capacity;
        this.data = new HashEntry[this.capacity];
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public Y get(X key){
        int hash = calculateHash(key);

        if(data[hash] == null)
            return null;
        else
            return (Y)data[hash].getValue();
    }

    public void put(X key,Y value){
        int hash = calculateHash(key);

        data[hash] = new HashEntry<X,Y>(key, value);
        size++;

    }

    public Y delete(X key){
        // first get the value to be removed
        Y value = get(key);

        if(value != null){
            int hash = calculateHash(key);
            data[hash] = null;
            size--;
            hash =  (hash + 1) % capacity;

            while(data[hash] != null){
                HashEntry temp = data[hash];
                data[hash] = null;
                // repositioning the hash table to remove empty slots and aviod collisions
                put((X)temp.getKey(),(Y)temp.getValue());
                size--;
                hash = (hash + 1) % capacity;
            }
        }

        return value;
    }

    public boolean hasKey(X key){
        int hash = calculateHash(key);

        if (data[hash] == null)
            return false;
        else if(data[hash].getKey().equals(key)){
            return true;
        }
        return false;
    }

    public boolean hasValue(Y value){
        for(int i=0; i < this.capacity; i++){
            HashEntry entry = data[i];

            if (entry != null && entry.getValue().equals(value))
                return true;
        }
        return false;
    }

    private int calculateHash(X key){
        int hash = key.hashCode() % this.capacity;

        // this is necessary to deal with collision
        while(data[hash] != null && !data[hash].getKey().equals(key))
            hash = (hash + 1) % this.capacity;

        return hash;
    }

    private class HashEntry<X,Y>{
        private X key;
        private Y value;

        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }

        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return value;
        }

        public void setValue(Y value) {
            this.value = value;
        }
    }
}
