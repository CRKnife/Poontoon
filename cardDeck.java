
import java.util.ArrayList;
import java.util.Random;

public class cardDeck {

    private String[] deck;
    private int deckPosition = 1;

    public void initalise(boolean includeJokers) {//creates a unshuffled deck with or without jokers

        int currentSuit = 0;
        int position;
        int modifier=0;

        if(includeJokers){//sets size of deck string and adds jokers if necessary. position 0 will always be null
            deck = new String[56];
            deck[54] =  "joker";
            deck[55] =  "joker";
        } else{
            deck = new String[53];
        }//end if/else

        String[] face = {null, "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "king", "queen", "ace"};
        String[] suits = {null, "hearts", "diamonds", "clubs", "spades"};


        while(currentSuit<4){//takes values in face and suits string and combines them to create deck

            currentSuit = currentSuit+1;

            for (int i = 1; i < face.length; i++) {
                //System.out.println("suit "+currentSuit);
                position = i+modifier;
                //System.out.println("position:"+position);
                deck[position] = "|"+face[i] + " of " + suits[currentSuit]+"|";
            }//end loop
            modifier = 13*currentSuit;
        }//end loop
    }//end method

    public void displayDeck(){//outputs current deck order


        for (int i = 1; i < deck.length; i++) {

            System.out.println(deck[i]);

        }//end loop
    }

    public String[] deckShuffle(){//shuffles deck string into a random order

        String heldCard;
        int randomPosition;

        for (int i = 1; i < deck.length; i++) {
            randomPosition =(int)(Math.random()*deck.length);
            heldCard = deck[i];
            deck[i]=deck[randomPosition];
            deck[randomPosition]=heldCard;
        }//end loop
        return deck;
    }//end method

    public String drawACardFromDeck(boolean reset){

        String drawnCard;

        if(reset){
            deckPosition = 1;
        }

        drawnCard = deck[deckPosition];

        deckPosition = deckPosition+1;

        return drawnCard;
    }//end method

    public int acesHighOrLow() {//random decider if aces are high or low in this deck

        int acesHigh;

        acesHigh = (int)(Math.random()*2);

        System.out.println(acesHigh);

        if (acesHigh == 1){
            System.out.println("Aces are High");
        }
        else{
            System.out.println("Aces are Low");
        }//end else/if

        return(acesHigh);

    }//end method
}//end class
