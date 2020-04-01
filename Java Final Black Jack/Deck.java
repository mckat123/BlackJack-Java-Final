package blackjack;
import java.util.*;

public class Deck {
    private ArrayList<Card> deck;
    
    
    public Deck()
    {
        deck = new ArrayList<Card>();
        
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 13; j++)
            {
                deck.add(new Card(i,j));
            }
        }
    }
    
    public Card drawCard()
    {
        return deck.remove(0);
    }
    
    public void shuffle()
    {
        Random rand = new Random();
        Card guy;
        for(int i = 0; i<100; i++)
        {
            int x = rand.nextInt();
            int y = rand.nextInt();
            guy = deck.get(y);
            deck.set(y, deck.get(y));
            deck.set(x, guy);
        }
    }
    
    
}
