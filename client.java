// * This program computes the gui for Yahtzee
// * CPSC 224, Fall 2022
// * Programming Assignment #5
// * 
// * @author Louis Cerda
// * @version v1.0 11/13/22
// */

import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;
import java.io.*;
import java.net.*;
import java.awt.event.ActionListener;


class client extends JFrame
{
    JButton rollDice, dice1Button, dice2Button,dice3Button,dice4Button,dice5Button, showScore, hideScore, menuItem1;
    JLabel topLabel, midLabel, label3, label4, label5, label6, label7, label8; 
    JPanel topPanel, midPanel, lowPanel, endPanel;


    ArrayList<String> rerolledDice = new ArrayList<>();
    


    // variblaes 
    boolean onlyOne = false;
    int dice = 5;
    int sides = 6;
    int[] hand = new int[dice];  
    boolean gameOver = false;
    private int width;
    private int height;


    // indiviaul scores and scorecard player specific
    protected int score = 0;
    ArrayList<String> scard = new ArrayList<String>();



    // server vars
    protected int playerID;
    protected int turnsMade;
    protected boolean buttonsEnabled;
    protected int curPlayer;


    // classes instantiated
    scorecard scoreClass = new scorecard();
    dice diceClass = new dice();



    //server connections
    protected ClientSideConnetion csc;



    public client(int w, int h){
        this.width = w;
        this.height = h;
        this.turnsMade = 0;




        // since each player is created as a new version of this 
        // this class can have its own score and scorecard
        scard = scorecard.changeInitialArr(scard);



        // creating a panel
        topPanel = new JPanel();
        midPanel = new JPanel();



        dice1Button = new JButton(); 
        dice2Button = new JButton(); 
        dice3Button = new JButton(); 
        dice4Button = new JButton(); 
        dice5Button = new JButton(); 
        rollDice = new JButton();
        hideScore = new JButton();
        showScore = new JButton();
        menuItem1 = new JButton();

        // label welcome 
        topLabel = new JLabel();
        midLabel = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
    }    

    public void setUpGUI()
    {
        this.setSize(width,height);
        this.setTitle("YAHTZEE " + playerID);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);


        topPanel.setBackground(new Color(75, 75, 75)); // setting color of background panel
        topPanel.setBounds(0, 0, 600, 270);

        midPanel.setBackground(new Color(75, 75, 75)); 
        midPanel.setBounds(0, 270 , 600, 330);

        topPanel.setLayout(null);


        dice1Button.setText("");
        dice1Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice1Button.setBounds(10,150,75,75);
        topPanel.add(dice1Button);

        dice2Button.setText("");
        dice2Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice2Button.setBounds(95,150,75,75);
        topPanel.add(dice2Button);

        dice3Button.setText("");
        dice3Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice3Button.setBounds(180,150,75,75);
        topPanel.add(dice3Button);

        dice4Button.setText("");
        dice4Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice4Button.setBounds(265,150,75,75);
        topPanel.add(dice4Button);
 
        dice5Button.setText("");
        dice5Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice5Button.setBounds(350,150,75,75);
        topPanel.add(dice5Button);



        topLabel.setText("Player: " + playerID);
        topLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));



        // middle label blank intially 
        midLabel.setText("");
        midLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        // label 3 blank intially 
        label3.setText("Total Score: " + score);
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        // label 4 blank intially 
        label4.setText("Turn: " + turnsMade);
        label4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label4.setBounds(0,0,80,30);

        // label 5 blank intially 
        label5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label5.setBounds(500,0,80,30);
        

        // creating next player button
        rollDice.setText("Roll All Dice");
        rollDice.setPreferredSize(new Dimension(200,50));
        rollDice.setBackground(Color.lightGray);
        rollDice.setOpaque(true);

        // creating next player button
        showScore.setText("Show Scorecard");
        showScore.setPreferredSize(new Dimension(200,50));
        showScore.setBackground(Color.lightGray);
        showScore.setOpaque(true);


        hideScore.setText("Hide Scorecard");
        hideScore.setPreferredSize(new Dimension(200,50));
        hideScore.setBackground(Color.lightGray);
        hideScore.setOpaque(true);

        menuItem1.setText("");
        menuItem1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem1.setBounds(300,125,200,50);



        topPanel.add(topLabel);
        topPanel.add(label3);
        topPanel.add(label4);
        topPanel.add(label5);
        topPanel.add(menuItem1);
        midPanel.add(midLabel);
        this.add(topPanel);
        this.add(midPanel);


        // end game button set up 
        // dice buttons being set visible
        // setting up score display label
        label3.setBounds(10,0,250,100);
        midPanel.add(rollDice);
        midPanel.add(hideScore);
        hideScore.setVisible(false);
        menuItem1.setVisible(false);
        midPanel.add(showScore);
        // setting up turns label, current player label, and configing game accoridng to how many players were chosen
        topLabel.setBounds(10,50,500,100);

        if (playerID == 1)
        {
            label5.setText("Playing");
            buttonsEnabled = true;
        } else{
            label5.setText("Waiting");
            buttonsEnabled = false;
            // Thread t = new Thread(new Runnable() {
            //     public void run(){
            //         updateTurn();
            //     }
            // });
            // t.start();
        }
        this.setVisible(true);

    }


    public void setupButtons()
    {
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) 
            {
                // function that rolls dice and updates the text on the button
                if (e.getSource() == rollDice)
                {  

                    if (turnsMade < 4 && curPlayer == playerID) 
                    {
                        unhighlight();
                        rerollDiceFunction();
                        turnsMade ++;
                        label4.setText("Turn: " + turnsMade);
                    }
                }


                if (e.getSource() == dice1Button)
                {
                    dice1Button.setBackground(Color.red);
                    rerolledDice.add("1");
                    dice1Button.setOpaque(true);
                }

                if (e.getSource() == dice2Button)
                {
                    dice2Button.setBackground(Color.red);
                    dice2Button.setOpaque(true);
                    rerolledDice.add("2");
                }

                if (e.getSource() == dice3Button)
                {
                    dice3Button.setBackground(Color.red);
                    dice3Button.setOpaque(true);
                    rerolledDice.add("3");
                }

                if (e.getSource() == dice4Button)
                {
                    dice4Button.setBackground(Color.red);
                    dice4Button.setOpaque(true);
                    rerolledDice.add("4");
                }

                if (e.getSource() == dice5Button)
                {
                    dice5Button.setBackground(Color.red);
                    dice5Button.setOpaque(true);
                    rerolledDice.add("5");
                }
                if (e.getSource() == showScore)
                {
                    showScore.setVisible(false);
                    rollDice.setVisible(false);
                    hideScore.setVisible(true);
                    dice1Button.setVisible(false);
                    dice2Button.setVisible(false);
                    dice3Button.setVisible(false);
                    dice4Button.setVisible(false);
                    dice5Button.setVisible(false);
                    label4.setVisible(false);
                    topLabel.setText("Player " + playerID + " Scorecard");
                    label3.setText("Total Score: " + score);

                    diceClass.sortArray(hand, 5);

                    // showing scores 
                    if (scard.contains("1"))
                    {
                        menuItem1.setVisible(true);
                        int currentCount = 0;
                        for (int diePos = 0; diePos < dice; diePos++)
                        {
                            if (hand[diePos] == 1)
                                currentCount++;
                        }
                        menuItem1.setText("1 Score: " + 1*currentCount);
                    }
                }

                if (e.getSource() == hideScore)
                {
                    label4.setVisible(true);
                    if (onlyOne == true)
                    {
                        turnsMade = 1;
                        label4.setText("Turn: " + turnsMade);
                        label3.setText("Total Score: " + score);
                        topLabel.setText("Player: " + playerID);
                        rerollDiceFunction();
                    }
                    unhighlight();
                    topPanel.setBounds(0,0,600,270);
                    showScore.setVisible(true);
                    rollDice.setVisible(true);
                    hideScore.setVisible(false);
                    topLabel.setText("Player: " + playerID);

                    menuItem1.setVisible(false);
            

                    dice1Button.setVisible(true);
                    dice2Button.setVisible(true);
                    dice3Button.setVisible(true);
                    dice4Button.setVisible(true);
                    dice5Button.setVisible(true);

                    onlyOne = false;
                    
                    if (scorecard.checkGameOver() == true)
                    {
                        gameOver = true;
                    }
                }

                if (e.getSource() == menuItem1)
                {
                    if (curPlayer == playerID)
                    {
                        // calc the score for menu item 1
                        int currentCount = 0;
                        for (int diePos = 0; diePos < dice; diePos++)
                        {
                            if (hand[diePos] == 1)
                                currentCount++;
                        }
                        // score to be added
                        int temp = 1*currentCount;
                        if(onlyOne == false)
                        {
                            menuItem1.setVisible(false);
                            scard.remove("1");
                            score += temp;
                            label3.setText("Total score: " + score);
                            switchPlayers(); 
                            curPlayer = (((curPlayer) % 2) + 1);
                            
                        }
                        onlyOne = true;
                        csc.sendCurPlayer();
                    }
                }

                // Thread t = new Thread(new Runnable() {
                //     public void run(){
                //         updateTurn();
                //     }
                // });
                // t.start();
            }
        };
        rollDice.addActionListener(al);
        showScore.addActionListener(al);
        hideScore.addActionListener(al);
        dice1Button.addActionListener(al);
        dice2Button.addActionListener(al);
        dice3Button.addActionListener(al);
        dice4Button.addActionListener(al);
        dice5Button.addActionListener(al);
        menuItem1.addActionListener(al);
    }
    

    protected void connectToServer(){
        this.csc = new ClientSideConnetion();
    }




    public void updateTurn(){
        System.out.println("Cur player was: " + curPlayer );
        curPlayer = csc.receiveCurPlayer();
    }

    



    // client connection inner class
    protected class ClientSideConnetion {

        protected Socket socket;
        protected DataInputStream dataIn;
        protected DataOutputStream dataOut;

        public ClientSideConnetion(){
            System.out.println("---Client---");
            try{
                this.socket = new Socket("localhost", 51734);
                this.dataIn = new DataInputStream(socket.getInputStream());
                this.dataOut = new DataOutputStream(socket.getOutputStream());
                playerID = dataIn.readInt();
                curPlayer = dataIn.readInt();
                System.out.println("Connected to server as player # " + playerID + " .");
            }catch (IOException ex){
                ex.getStackTrace();
                System.out.println("IOException from csc constructor"); 
            }
        }


        public void sendCurPlayer(){
            System.out.println("Sending next player up");
            try{
                dataOut.writeInt(curPlayer);
                dataOut.flush();

            } catch(IOException e){
                System.out.println("IOException from sendCurPlayer function");
            }
        }


        public int receiveCurPlayer(){
            int n = 0;
            try{
                n = dataIn.readInt();
                System.out.println("Cur player is: " );
            } catch(Exception e){
                e.getStackTrace();
                System.out.println("IOException from recieveCurPlayer()");
            }
            return n;
        }


        public void closeConnection(){
            try{    
                socket.close();
                System.out.println("----- CONNECTION CLOSED -----");
            } catch(IOException e){
                System.out.println("ERROR FORM CLOSED CONNECTION");
            }
        }
    }


   


    public static void main(String[] args)
    {
        // finalYahtzee yahtzee = new finalYahtzee();
        client p = new client(600,600);
        p.connectToServer();
        p.setUpGUI();
        p.setupButtons();
    }













    // simple function to unhiglihgt selected dice
    public void unhighlight()
    {
        if (rerolledDice.isEmpty() == false)
        {
            turnsMade ++;
            label4.setText("Turn: " + turnsMade);
        }
        if (rerolledDice.contains("1"))
        {
            // dice1Button.setOpaque(false);
            dice1Button.setBackground(null);
            rerolledDice.remove("1");
        }

        if (rerolledDice.contains("2"))
        {
            // dice2Button.setOpaque(false);
            dice2Button.setBackground(null);
            rerolledDice.remove("2");
        }

        if (rerolledDice.contains("3"))
        {
            dice3Button.setOpaque(false);
            dice3Button.setBackground(null);

            rerolledDice.remove("3");
        }

        if (rerolledDice.contains("4"))
        {
            dice4Button.setBackground(null);
            dice4Button.setOpaque(false);
            rerolledDice.remove("4");
            
        }

        if (rerolledDice.contains("5"))
        {
            dice5Button.setBackground(null);
            dice5Button.setOpaque(false);
            rerolledDice.remove("5");

        }
    }



    public void rerollDiceFunction()
    {
        
        String dice1Roll = diceClass.rollDice();
        dice1Button.setText(dice1Roll);
        hand[0] = Integer.parseInt(dice1Roll);
        
        String dice2Roll = diceClass.rollDice();
        dice2Button.setText(dice2Roll);
        hand[1] = Integer.parseInt(dice2Roll);


        String dice3Roll = diceClass.rollDice();
        dice3Button.setText(dice3Roll);
        hand[2] = Integer.parseInt(dice3Roll);

        
        String dice4Roll = diceClass.rollDice();
        dice4Button.setText(dice4Roll);
        hand[3] = Integer.parseInt(dice4Roll);

        
        String dice5Roll = diceClass.rollDice();
        dice5Button.setText(dice5Roll);
        hand[4] = Integer.parseInt(dice5Roll);
    }



    public void switchPlayers()
    {
        if (label5.getText() == "Waiting")
        {
            label5.setText("Playing");
        } else{
            label5.setText("Waiting");
        }
    }
}





// 12.23.22
// send over button clicked and recieve 
// create new thread to allow for connections to not interfere with GUI function
// toggle buttons enabled 
// update score on game server 
// sort scores arry 
    // possible with a map with the key 



// 12.24.22
// todo:
// needs to receive cur player form server and update 
// update score on the actual server
    // another send function to the server from the client 
    