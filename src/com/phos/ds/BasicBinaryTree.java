package com.phos.ds;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class BasicBinaryTree<X extends Comparable<X>> {

    private Node root;
    private int size;

    public BasicBinaryTree() {
        this.root = null;
    }

    public int size(){
        return this.size;
    }

    public void add(X item){
        Node node = new Node(item);

        if(this.root == null){
            this.root = node;
            System.out.println("Set root: " + node.getItem());
            this.size++;
        }
        else{
            insert(this.root,node);
        }

    }

    public boolean contains(X item){
        Node currentNode = getNode(item);

        return currentNode != null;
    }

    private Node getNode(X item){
        Node currentNode = this.root;
        while (currentNode != null) {
            int val = item.compareTo(currentNode.getItem());

            if (val == 0)
                return currentNode;
            else if (val < 0)
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
        }
        return null;
    }

    private void insert(Node parent, Node child){
        // if the child is less than the parent, it goes on the left
        if(child.getItem().compareTo(parent.getItem()) < 0){
            // if it is null then we have found our spot
            if (parent.getLeft() == null){
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            }
            else{
                // if not we go a step down and try again
                insert(parent.getLeft(),child);
            }
        }
        else if(child.getItem().compareTo(parent.getItem()) > 0){
            if (parent.getRight() == null){
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            }
            else{
                insert(parent.getRight(),child);
            }
        }
    }

    public Boolean delete(X item){
        boolean deleted = false;
        if(this.root == null)
            return false;

        Node currentNode = getNode(item);

        if(currentNode != null){
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                unlink(currentNode, null);
                deleted = true;
            }
            else if (currentNode.getLeft() == null && currentNode.getRight() != null){
                unlink(currentNode, currentNode.getRight());
                deleted = true;
            }
            else if (currentNode.getLeft() != null && currentNode.getRight() == null){
                unlink(currentNode, currentNode.getLeft());
                deleted = true;
            }
            else{
                // we can swap the node that we want to delete with the right most node on the left side
                Node child = currentNode.getLeft();
                // we ought to get the right most node and swap it with the node we want to delete
                // this condition can fall short when we think of the possibility of there being a right node and no left node
                // so check for only if the right node is not null and kee going
                // while(child.getRight() != null)
                while (child.getRight() != null && child.getLeft() != null){
                    child = child.getRight();
                }

                // set the parent right node to be null
                child.getParent().setRight(null);

                // replace the child of the node to be deleted with the swapping node
                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());

                // replace using the unlink method
                unlink(currentNode,child);
                deleted = true;


            }
        }

        if(deleted)
            this.size--;

        return deleted;
    }

    private void unlink(Node currentNode, Node newNode){
        if(currentNode == this.root){
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
        }
        else if(currentNode.getParent().getLeft() == currentNode){
            currentNode.getParent().setLeft(newNode);
        }
        else{
            currentNode.getParent().setRight(newNode);
        }
    }

    private class Node{
        private Node left;
        private Node right;
        private Node parent;
        private X item;

        public Node(X item) {
            this.item = item;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }
    }
}
