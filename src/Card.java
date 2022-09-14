public class Card {

    public String suit;
    public int number;
    public int suitNum;
    public String name;
    public int value;

    public Card(int pNumber, int pSuitnum){

        number = pNumber;
        suitNum = pSuitnum;

        if (suitNum==0){
            suit="hearts";
        }
        if (suitNum==1){
            suit="Diamonds";

        }
        if (suitNum==2){
            suit="Spades";

        }
        if (suitNum==3){
            suit="clubs";

        }
        if(number==1){
            name="Ace";
        }
        if(number==2){
            name="two";
        }
        if(number==3){
            name="three";
        }
        if(number==4){
            name="four";
        }
        if(number==5){
            name="five";
        }
        if(number==6){
            name="six";
        }
        if(number==7){
            name="seven";
        }
        if(number==8){
            name="eight";
        }
        if(number==9){
            name="nine";
        }
        if(number==10){
            name="ten";
        }
        if(number==11){
            name="jack";
        }
        if(number==12){
            name="queen";
        }
        if(number==13){
            name="king";
        }
        value = number;
        if (value > 10) {
            value = 10;
        }
        }


          public void printCard(){
        System.out.println( name + " of " + suit);
        System.out.println("Your total value is "+ value+ ".");
          }

}
