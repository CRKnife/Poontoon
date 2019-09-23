import java.util.Scanner;

public class pontoon {
    private Scanner kboard = new Scanner(System.in);
    private String[] playerHand = new String[6];
    private String[] houseHand= new String[6];
    private int acesHigh;

    public void menu(){//start point for pontoon and point where the player decides to repeat or end game

        String cont;

        do{
            System.out.println("Would you like to play pontoon (y/n)");
            cont = kboard.nextLine();
            pontoonGame();
        }while(cont.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing \n Good Bye");

    }

    private void pontoonGame() {//

        int playerTotal;
        int houseTotal;
        player player1 = new player();

        player1.setUsername("Username");
        String playerName = player1.getUsername();

        cardDeck newDeck = new cardDeck();
        newDeck.initalise(false);
        newDeck.deckShuffle();

        acesHigh = newDeck.acesHighOrLow();//decides randomly if aces are high or low

        playerTotal = playerDraw(newDeck);

        houseTotal = houseDraw(newDeck);

        //win decider based on each parties total face value
        if(playerTotal>21 && houseTotal>21){
            System.out.println("DRAW");
        }
        else if(playerTotal > 21){
            System.out.println("House WINS");
        }
        else if(houseTotal > 21){
            System.out.println(playerName +" WINS");
        }
        else if(playerTotal<houseTotal){
            System.out.println("House WINS");
        }
        else if(playerTotal>houseTotal){
            System.out.println(playerName +" WINS");
        }
        else{
            System.out.println("Draw");
        }
        //end of win decider


    }//end method startGame

    private int playerDraw(cardDeck newDeck){//sets up players initial hand then asks if they want more cards

        boolean drawCard = true;
        int handSize = 1;
        String drawnCard;
        int faceTotalValue = 0;

        drawnCard = newDeck.drawACardFromDeck(true);
        playerHand[handSize] = drawnCard;
        faceTotalValue = faceTotalValue + valueCheck(drawnCard);

        do {//draws cards for player and increase there hand size
            handSize = handSize + 1;

            drawnCard = newDeck.drawACardFromDeck(false);
            playerHand[handSize] = drawnCard;

            faceTotalValue = faceTotalValue + valueCheck(drawnCard);

            System.out.println("Your hand:");

            for (int i = 1; i < handSize + 1; i++) {
                System.out.println(playerHand[i]);
            }//end loop

            if (handSize > 5) {
                break;
            } else if (faceTotalValue > 21) {
                break;
            }//end else/if

            System.out.println("draw(d) or hold(h)");
                if (input().equalsIgnoreCase("h")) {
                    drawCard = false;
                }

        } while (drawCard);// end loop

        return faceTotalValue;

    }//end method draw

    private int houseDraw(cardDeck newDeck){

        boolean drawCard = true;
        int handSize = 1;
        String drawnCard;
        int totalValue = 0;

        drawnCard = newDeck.drawACardFromDeck(false);
        houseHand[handSize] = drawnCard;
        totalValue = totalValue + valueCheck(drawnCard);

        do {
            handSize = handSize + 1;

            drawnCard = newDeck.drawACardFromDeck(false);
            houseHand[handSize] = drawnCard;

            totalValue = totalValue + valueCheck(drawnCard);


            if(totalValue>17 && totalValue<21){
                drawCard=false;
            }
            else if(handSize>=5){
                drawCard=false;
            }

        } while (drawCard);// end loop

        System.out.println("House hand:");

        for (int i = 1; i < handSize + 1; i++) {
            System.out.println(houseHand[i]);
        }//end loop

        return totalValue;

    }//end method draw


    private String input(){

        String value;

        Scanner kBoard = new Scanner(System.in);
        value = kBoard.nextLine();

        return value;
    }//end method


    private int valueCheck(String drawnCard){//checks the value of the card the parties has drawn and returns the face value to be added to parties total

        int faceValue = 0;


        if(drawnCard.contains("two")){
            faceValue = 2;
        }
        else if(drawnCard.contains("three")){
            faceValue = 3;
        }
        else if(drawnCard.contains("four")){
            faceValue = 4;
        }
        else if(drawnCard.contains("five")){
            faceValue = 5;
        }
        else if(drawnCard.contains("six")){
            faceValue = 6;
        }
        else if(drawnCard.contains("seven")){
            faceValue = 7;
        }
        else if(drawnCard.contains("eight")){
            faceValue = 8;
        }else if(drawnCard.contains("nine")){
            faceValue = 9;
        }
        else if(drawnCard.contains("ten") || drawnCard.contains("jack") || drawnCard.contains("queen") || drawnCard.contains("king")) {
            faceValue = 10;
        }
        else {
            if(acesHigh == 1) {
                faceValue = 11;
            }
            else{
                faceValue = 1;
            }
        }

        return faceValue;
    }//end method



}//end class
