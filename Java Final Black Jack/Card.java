package blackjack;


public class Card {
    private int suit;
    private int name;
    private int value;
    private String[] names = {"Joker", "Ace","Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"}; 
    private String[] suits = {"Clubs", "Spades", "Diamonds", "Hearts"};
    
    public Card(int cardSuit, int cardValue)
    {
        this.name = cardValue;
        this.suit = cardSuit;
    }
    
    public String toString()
    {
        return (names[name] + " of " + suits[suit]);
    }
    
    public String getSuit()
    {
        return suits[suit];
    }
    
    public String getName()
    {
        return names[name];
    }
    
    public int getValue()
    {
        if(name > 10)
        {
            value = 10;
        }
        else if(name==1)
        {
            value=11;
        }
        else
        {
            value = name;
        }
        return value;
    }
    
    public boolean compareTo(Card cardTwo)
    {
        if(this.name == cardTwo.name)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void setValue(int newValue)
    {
        value = newValue;
    }
    
    
}
