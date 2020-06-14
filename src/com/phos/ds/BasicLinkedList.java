package com.phos.ds;

public class BasicLinkedList<X> {

    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList(){
        first=null;
        last=null;
        nodeCount=0;
    }

    public int size(){
        return nodeCount;
    }

    public void add(X item){
        if(first == null){
            first = new Node(item);
            last = first;
        }
        else{
            Node newNode = new Node(item);
            last.setNextNode(newNode);
            last = newNode;
        }
        nodeCount++;
    }

    public X remove(){
        if (first == null)
            throw new IllegalStateException("The linked list is empty and there are no items to remove");

        X nodeItem = first.nodeItem;

        // update the first pointer to the next node item
        first = first.getNextNode();
        nodeCount--;

        return nodeItem;
    }

    public void insert(X item, int position){
        if (size() < position)
            throw new IllegalStateException("The position chosen is greater than the size of the LinkedList");

        Node currentNode = first;

        // we are starting at 1 because we are already on the first node
        // we loop through the list till we get to the position on the list
        for(int i = 1; i < position && currentNode.getNextNode() != null; i++)
            currentNode = currentNode.getNextNode();

        Node newNode = new Node(item);
        newNode.setNextNode(currentNode.getNextNode());
        currentNode.setNextNode(newNode);
        nodeCount++;

    }

    public X get(int position){
        if (first == null)
            throw new IllegalStateException("The linked list is empty");

        Node currentNode = first;

        for(int i =1; i < size() && currentNode.getNodeItem() != null; i++){
            if (i == position)
                return currentNode.getNodeItem();
            currentNode = currentNode.getNextNode();
        }
        throw new IllegalStateException("could not find position");
    }

    public int find(X item){
        if(first == null)
            throw new IllegalStateException("the list is empty");
        Node currentNode = first;

        for(int i = 1; i < size() && currentNode.getNodeItem() != null; i++){
            if (currentNode.getNodeItem().equals(item))
                return i;
            currentNode = currentNode.getNextNode();
        }
        // returns -1 if nothing is found
        return -1;
    }

    @Override
    public String toString() {
        StringBuffer content = new StringBuffer();

        Node currentNode = first;
        while (currentNode != null){
            content.append(currentNode.getNodeItem());
            currentNode = currentNode.getNextNode();

            if(currentNode != null)
                content.append(", ");
        }
        return content.toString();
    }

    public X removeAt(int position){
        if(size() < position)
            throw new IllegalStateException("The position chosen is greater than the size of the Linked list");

        Node previousNode = first;
        Node currentNode = first;

        // we are starting at 1 because we are already on the first node
        // we loop through the list till we get to the position on the list
        for(int i = 1; i < position && currentNode.getNextNode() != null; i++){
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        X nodeItem = currentNode.nodeItem;
        previousNode.setNextNode(currentNode.getNextNode());
        nodeCount--;

        return nodeItem;

    }

    private class Node {

        public Node(X item){
            this.nextNode = null;
            this.nodeItem = item;
        }

        private Node nextNode;
        private X nodeItem;

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public X getNodeItem() {
            return nodeItem;
        }

    }
}
