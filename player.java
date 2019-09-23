import java.util.Scanner;

public class player {

    private String username;
    private String forename;
    private String surname;
    private String[] playerHand = new String[6];

    public String input(String field){

        String value;

        System.out.println("Please enter your " + field);
        Scanner kBoard = new Scanner(System.in);
        value = kBoard.nextLine();

        return value;
    }//end method

    public void setUsername(String newValue){
        username = input(newValue);
    }//end method

    public void setForename(String newValue){
        forename = input(newValue);
    }//end method

    public void setSurname(String newValue){
        surname = input(newValue);
    }//end method

    public String getUsername(){
        return "User: "+username;
    }

    public void displayPlayer(){
        System.out.println("Username: "+username);
        System.out.println("Forename: "+forename);
        System.out.println("Surname: "+surname);
    }//end method
}
