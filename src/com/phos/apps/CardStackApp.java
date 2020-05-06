package com.phos.apps;

import com.phos.contract.Stack;
import com.phos.models.BasicStack;
import com.phos.models.ListStack;

public class CardStackApp {

    //BasicStack<String> stack = new BasicStack<>();

    private Stack<String> stack = new ListStack<String>();

    public static void main(String args[]){
        CardStackApp app = new CardStackApp();

        app.stackCards();
        app.unstackCards();

        // restack the cards
        app.stackCards();

        //check the size
        app.deckSize();

        //check to see if it contains the king of clubs
        app.containsCards("King of clubs");

        //check to see if it contains a joker
        app.containsCards("Joker");

        // go to a particular card on the stack
        app.goToCard("Queen of diamond");

        //check the cards left on the stack
        app.deckSize();

    }

    public void stackCards(){
        // stack the spade suits
        stack.push("Ace of spades");
        stack.push("2 of spades");
        stack.push("3 of spades");
        stack.push("4 of spades");
        stack.push("5 of spades");
        stack.push("6 of spades");
        stack.push("7 of spades");
        stack.push("8 of spades");
        stack.push("9 of spades");
        stack.push("10 of spades");
        stack.push("Jack of spades");
        stack.push("Queen of spades");
        stack.push("King of spades");

        //stack the diamond suit
        stack.push("Ace of diamond");
        stack.push("2 of diamond");
        stack.push("3 of diamond");
        stack.push("4 of diamond");
        stack.push("5 of diamond");
        stack.push("6 of diamond");
        stack.push("7 of diamond");
        stack.push("8 of diamond");
        stack.push("9 of diamond");
        stack.push("10 of diamond");
        stack.push("Jack of diamond");
        stack.push("Queen of diamond");
        stack.push("King of diamond");

        //stack the clubs
        stack.push("Ace of clubs");
        stack.push("2 of clubs");
        stack.push("3 of clubs");
        stack.push("4 of clubs");
        stack.push("5 of clubs");
        stack.push("6 of clubs");
        stack.push("7 of clubs");
        stack.push("8 of clubs");
        stack.push("9 of clubs");
        stack.push("10 of clubs");
        stack.push("Jack of clubs");
        stack.push("Queen of clubs");
        stack.push("King of clubs");

        //stack the hearts
        stack.push("Ace of hearts");
        stack.push("2 of hearts");
        stack.push("3 of hearts");
        stack.push("4 of hearts");
        stack.push("5 of hearts");
        stack.push("6 of hearts");
        stack.push("7 of hearts");
        stack.push("8 of hearts");
        stack.push("9 of hearts");
        stack.push("10 of hearts");
        stack.push("Jack of hearts");
        stack.push("Queen of hearts");
        stack.push("King of hearts");

    }

    public void unstackCards(){
        while(stack.size() > 0)
            System.out.println(stack.pop());
    }

    public void containsCards(String card){
        System.out.println(stack.contains(card));
    }

    public void goToCard(String card){
        System.out.println(stack.access(card));
    }

    public void deckSize(){
        System.out.println(stack.size());
    }
}
