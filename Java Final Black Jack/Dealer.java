package blackjack;
import java.util.*;

public class Dealer {
    
    private ArrayList<Card> hand;
    private int handTotal = 0;
    private Card[] randHand;
    private Card[] randHand2;
    private int numAces;
    private Deck deck;
    
    public void handValueCheck()
    {
        for(int i = 0; i < randHand.length; i++)
        {
            //begin calculations for hand's value
            handTotal += randHand[i].getValue();
            
            //determine existence of aces
            if(randHand[i].getValue()==11)
            {
                numAces++;
            }
            
            //determines value of aces in relation to total value of other cards in hand
            while(numAces > 0 && handTotal > 21)
            {
                handTotal -= 10;
                numAces --;
            }
        }
    }
    
    public Dealer(Deck deck)
    {
        hand = new ArrayList<>();
        randHand = new Card[]{};
        int numAces = 0;
        
        //Create the dealer's hand
        for(int i = 0; i < 2; i++)
        {
            hand.add(deck.drawCard());
        }
        
        
        handValueCheck();
    }
    
    
    
    
    public void revealTopCard()
    {
        Card[] cardOne = new Card[]{};
        cardOne = hand.toArray(cardOne);
        
    }
    
    
    public void HitMe(Deck deck)
    {
        hand.add(deck.drawCard());
        randHand = hand.toArray(randHand);
        handTotal = 0;
        handValueCheck();
    }
    
    public boolean mustHit()
    {
        if(handTotal <= 16)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean hasBlackJack()
    {
        if(handTotal == 21 && hand.size() == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean IWin()
    {
        if(handTotal == 21 /*PLACE HOLDER FOR PLAYER WIN CONDITION*/)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    
    public int getHandValue()
    {
        return handTotal;
    }
    
    public boolean bust(int handTotal)
    {
        if(handTotal > 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean fiveCardCharlie()
    {
        if(hand.size() == 5 && handTotal <= 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int myTurn()
    {
        while(mustHit() == true)
        {
            HitMe(deck);
            if(bust(handTotal))
            {
                break;
            }
        }
        return handTotal;
    }
}
