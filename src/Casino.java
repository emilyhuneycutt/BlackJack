import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Casino implements KeyListener {
    //declaration

    public Card[] Deck;
    public int randomInt;
    public int count = 0;
    public Card holder;
    public Player Alfonso;
    public ArrayList<Player> Group = new ArrayList<Player>();
    ;
    public int nextCard;
    public int nextPlayer;

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    public String myKey;

    public boolean isOver = false;


    public static void main(String[] args) {
        Casino myGame = new Casino();

    }

    public Casino() {
        setUpGraphics();
        makeDeck();
        shuffle();
        //deal();

   /*      Alfonso = new Player(0);
         Group.add(Alfonso);

    */
        Group.add(new Player(1));
        Group.add(new Player(2));
        Group.add(new Player(3));
        Group.add(new Player(4));
        Group.add(new Player(5));

        for (int x = 0; x < Group.size(); x++) {

            Group.get(x).hand.add(Deck[nextCard]);
            nextCard++;

        }
        for (int x = 0; x < Group.size(); x++) {

            Group.get(x).hand.add(Deck[nextCard]);
            nextCard++;

        }
        for (int x = 0; x < Group.size(); x++) {
            System.out.println("*****");
            Group.get(x).printHand();

        }

        for (int x = 0; x < Group.size(); x++) {
            System.out.println("&&&&&&&&&&&");
            Group.get(x).printHand();

        }

        //  Group.get(0).hand.add(Deck[0]);
        //   Alfonso.hand.add(Deck[0]);
        //  Alfonso.hand.add(Deck[1]);
        //   System.out.println("Alfonso, the Dealer, has: ");
        //   Alfonso.printHand();


    }

    public void makeDeck() {
        Deck = new Card[52];

        for (int i = 0; i < 4; i++) {
            for (int k = 1; k < 14; k++) {
                Deck[count] = new Card(k, i);
                Deck[count].printCard();
                count++;
            }

        }

    }

    public void shuffle() {
        for (int index = 0; index < 52; index++) {
            randomInt = (int) (Math.random() * 52);
            holder = Deck[index];
            Deck[index] = Deck[randomInt];
            Deck[randomInt] = holder;
        }
    }

    public void hit() {
        Group.get(nextPlayer).hand.add(Deck[nextCard]);
        nextCard++;
    }

    public void stand() {
        nextPlayer++;
    }

    public void over() {
        System.out.println("Its over :) ");
        for (int x = 1; x < Group.size(); x++) {
            if (Group.get(x).totalvalue > Group.get(Group.size() - 1).totalvalue) {
                System.out.println("player " + x + "  has more points then the dealer with a total value of " + Group.get(x).totalvalue);
            } else {
                System.out.println("player " + x + " is a loser with a total value of " + Group.get(x).totalvalue);

            }
        }
    }


    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);
        canvas.addKeyListener(this);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
        myKey = "" + e.getKeyChar();
        if (myKey.equals("h")) {
            if (isOver == false) {
                hit();
                System.out.println("hit me");
                Group.get(nextPlayer).printHand();
            }
            if (myKey.equals("s")) {
                stand();
                System.out.println("stand");

            }
            if (nextPlayer == Group.size()) {
                over();
                isOver = true;


            }


        }


        //constructor

    }
}
