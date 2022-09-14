import java.util.ArrayList;

public class Player {

    public int score;
    public int nameNum;
    public String name;
    public int totalvalue=0;

    public ArrayList<Card>hand;

    public Player(int pNameNum){
        score = 0;
        nameNum = pNameNum;
        hand = new ArrayList<Card>();
        name = "Player " + Integer.toString(nameNum);
    }
    public void printHand(){
        totalvalue=0;
        for (int i=0; i<hand.size(); i++){
            hand.get(i).printCard();
            totalvalue =totalvalue+ hand.get(i).value;
            System.out.println("total value "+totalvalue);
        }
    }

}
