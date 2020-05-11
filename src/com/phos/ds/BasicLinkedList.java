package com.phos.ds;

public class BasicLinkedList<X> {

    private Node first;
    private Node last;

    public BasicLinkedList(){
        first=null;
        last=null;
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
