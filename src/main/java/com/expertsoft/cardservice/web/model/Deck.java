package com.expertsoft.cardservice.web.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Deck {
	private static int count;
	private int id;
	private Card cards[];    
    private int currentCount;    
    private int size;
    private Suit suits[];
	private Value values[];
    
    public Deck(){
    	count++;
    id = count;
	 size=52;
    currentCount=0;
    cards = new Card[size];
    suits=Suit.values();
    values=Value.values();

    for(int i =0 ; i<suits.length;i++){
        for(int j =0 ; j<values.length;j++){
            cards[currentCount++] = new Card(suits[i],values[j]);
        }
    }
       System.out.println("count"+count);
        System.out.println("id"+id);
    }
    
   
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public Suit[] getSuits() {
		return suits;
	}
	
	public Value[] getValues() {
		return values;
	}
	
    public Card[] getCards(){
    	return cards;
    }
    
    public int getCurrentCount() {
        return currentCount;
    }  
    
    public int getSize() {
        return size;
    }
    
    public enum Suit{
        CLUB,DIAMOND,SPADE,HEART
    }

    public enum Value{
        ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING
    }
    
    public String toString(){
        StringBuilder sb=new StringBuilder();

        for(int i=0;i < currentCount;i++){
            sb.append(cards[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

    public class Card{    	
        private final Suit suit;
        private final Value value;

        public Card(Suit suit, Value value){
             this.suit=suit;
             this.value=value;
        }

        public Suit getSuit() {
            return suit;
        }

        public Value getValue() {
            return value;
        }        

        @Override
        public String toString() {            
            return suit+"-"+value;
        }
    }
}