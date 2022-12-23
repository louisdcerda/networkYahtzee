// * This program computes the gui for Yahtzee
// * CPSC 224, Fall 2022
// * Programming Assignment #5
// * 
// * @author Louis Cerda
// * @version v1.0 11/13/22
// */

import javax.swing.*;
import java.io.*;
import java.net.*;

class finalYahtzee extends JFrame
{
    //server connections
    protected ClientSideConnetion csc;



    protected void connectToServer(){
        this.csc = new ClientSideConnetion();
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
            }catch (IOException ex){
                System.out.println("IOException from csc constructor"); 
                ex.getStackTrace();
            }
        }
    }


    public static void main(String[] args)
    {
        // finalYahtzee yahtzee = new finalYahtzee();
        yahtzeeGUI gui = new yahtzeeGUI(600,600);
        finalYahtzee game = new finalYahtzee();
        game.connectToServer();
        gui.setUpGUI();
    }
















    // // changing buttons and label text
    // @Override
    // public void actionPerformed(java.awt.event.ActionEvent e)
    // {   
    //     // changing the settings of the game to fit their needs
    //     if (e.getSource() == startBut)
    //     {
    //         topLabel.setText("How many players would you like to play with?");
    //         topLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));


    //         // setting bounds for labels that say dice and sides
    //         label3.setText("Players: ");
    //         label3.setBounds(150,100,120,100);
    //         label4.setBounds(12,10,75, 25);




    //         // setting bounds for drop down menus
    //         drpDwnDice.setBounds(150,150,100,100);
    //         drpDwnDice.setVisible(true);
    //         topPanel.add(drpDwnDice);

            

    //         startBut.setVisible(false);
    //         next.setVisible(true);
    //         midPanel.add(next);
    //     }




    //     if (e.getSource() == next)
    //     {
    //         // end game button set up 
    //         endGame.setBounds(520, 10,75,50);
    //         topPanel.add(endGame);


    //         drpDwnDice.setVisible(false);
    //         next.setVisible(false);


    //         // dice buttons being set visible
    //         dice1Button.setVisible(true);
    //         dice2Button.setVisible(true);
    //         dice3Button.setVisible(true);
    //         dice4Button.setVisible(true);
    //         dice5Button.setVisible(true);

    //         // setting up score display label
    //         label3.setText("Total Score: " + scorecard.getSpecScore(curenetPlayer - 1));
    //         label3.setBounds(10,0,250,100);





    //         next.setVisible(false);
    //         nextPlayer.setVisible(true);
    //         nextPlayerUp.setVisible(true);
    //         midPanel.add(nextPlayer);
    //         midPanel.add(nextPlayerUp);
    //         midPanel.add(rollDice);
    //         midPanel.add(scoreShow);

    //         // setting up turns label, current player label, and configing game accoridng to how many players were chosen
    //         label4.setText("Turns: " + turns);
    //         topLabel.setText("Player: " + curenetPlayer);
    //         topLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
    //         topLabel.setBounds(10,50,500,100);

    //         scoreClass.setPlayer(player);
    //     }



    //     // rerolls hgihlighted options whne clicked
    //     if (e.getSource() == nextPlayer && turns < 6)
    //     {
    //         diceClass.rerollSelected(rerolledDice, dice1Button, hand, dice2Button, dice3Button, dice4Button, dice5Button);
    //         unhighlight();
    //     }


    //     if (e.getSource() == nextPlayerUp)
    //     {
    //         turns = 1;
    //         label4.setText("Turn: " + turns);
    //         curenetPlayer = (((curenetPlayer) % player) + 1);
    //         label3.setText("Total Score: " + scorecard.getSpecScore(curenetPlayer - 1));
    //         rerollDiceFunction();
    //         topLabel.setText("Player: " + curenetPlayer);
    //         currentScorecard = scorecard.getSpecScorecard((curenetPlayer - 1));
    //     }





    //     if (e.getSource() == scoreShow)
    //     {
    //         currentScorecard = scorecard.getSpecScorecard(curenetPlayer - 1);

    //         nextPlayer.setVisible(false);
    //         nextPlayerUp.setVisible(false);
    //         scoreShow.setVisible(false);
    //         rollDice.setVisible(false);
    //         scoreHide.setVisible(true);
    //         dice1Button.setVisible(false);
    //         dice2Button.setVisible(false);
    //         dice3Button.setVisible(false);
    //         dice4Button.setVisible(false);
    //         dice5Button.setVisible(false);
    //         label4.setVisible(false);



    //         topLabel.setText("Player " + curenetPlayer + " Scorecard");
    //         label3.setText("Total Score: " + scorecard.getSpecScore(curenetPlayer - 1));

    //         int score = 0;




    //         // showing scores 
    //         if (currentScorecard.contains("1"))
    //         {
    //             menuItem1.setVisible(true);

    //             int currentCount = 0;
    //             for (int diePos = 0; diePos < dice; diePos++)
    //             {
    //                 if (hand[diePos] == 1)
    //                     currentCount++;
    //             }
    //             menuItem1.setText("1 Score: " + 1*currentCount);
    //         }

    //         if (currentScorecard.contains("2"))
    //         {
    //             menuItem2.setVisible(true);

    //             int currentCount = 0;
    //             for (int diePos = 0; diePos < dice; diePos++)
    //             {
    //                 if (hand[diePos] == 2)
    //                     currentCount++;
    //             }
    //             menuItem2.setText("2 Score: " + 2*currentCount);
    //         }

    //         if (currentScorecard.contains("3"))
    //         {
    //             menuItem3.setVisible(true);

    //             int currentCount = 0;
    //             for (int diePos = 0; diePos < dice; diePos++)
    //             {
    //                 if (hand[diePos] == 3)
    //                     currentCount++;
    //             }
    //             menuItem3.setText("3 Score: " + 3*currentCount);
    //         }
            
    //         if (currentScorecard.contains("4"))
    //         {
    //             menuItem4.setVisible(true);

    //             int currentCount = 0;
    //             for (int diePos = 0; diePos < dice; diePos++)
    //             {
    //                 if (hand[diePos] == 4)
    //                     currentCount++;
    //             }
    //             menuItem4.setText("4 Score: " + 4*currentCount);
    //         }

    //         if (currentScorecard.contains("5"))
    //         {
    //             menuItem5.setVisible(true);

    //             int currentCount = 0;
    //             for (int diePos = 0; diePos < dice; diePos++)
    //             {
    //                 if (hand[diePos] == 5)
    //                     currentCount++;
    //             }
    //             menuItem5.setText("5 Score: " + 5*currentCount);
    //         }

    //         if (currentScorecard.contains("3K"))
    //         {   
    //             menuItem3K.setVisible(true);
    //             if (diceClass.maxOfAKindFound(hand) >= 3)
    //                 score = diceClass.totalAllDice(hand);
    //             menuItem3K.setText("3K Score: " + score);
    //         }

    //         if (currentScorecard.contains("4K"))
    //         {
    //             menuItem4K.setVisible(true);

    //             if (diceClass.maxOfAKindFound(hand) >= 4)
    //                 score = diceClass.totalAllDice(hand);
    //             menuItem4K.setText("4K Score: " + score);
    //         }

    //         if (currentScorecard.contains("FH"))
    //         {
    //             menuItemFH.setVisible(true);

    //             if (diceClass.fullHouseFound(hand))
    //                 menuItemFH.setText("FH Score: " + 25);
    //             else
    //                 menuItemFH.setText("FH Score: " + 0);
    //         }

    //         if (currentScorecard.contains("SS"))
    //         {
    //             menuItemSS.setVisible(true);

    //             if (diceClass.maxStraightFound(hand) >= 4)
    //                 menuItemSS.setText("SS Score: " + 30);
    //             else menuItemSS.setText("SS Score: " + 0);
    //         }

    //         if (currentScorecard.contains("LS"))
    //         {
    //             menuItemLS.setVisible(true);

    //             if (diceClass.maxStraightFound(hand) >= 5)
    //                 menuItemLS.setText("LS Score: " + 40);
    //             else menuItemLS.setText("LS Score: " + 0);

    //         }

    //         if (currentScorecard.contains("YL"))
    //         {
    //             menuItemYL.setVisible(true);

    //             if (diceClass.maxOfAKindFound(hand) >= 5)
    //                 menuItemYL.setText("YL Score: " + 50);
    //             else menuItemYL.setText("YL Score: " + 0);
    //         }

    //         if (currentScorecard.contains("C"))
    //         {
    //             menuItemC.setVisible(true);

    //             menuItemC.setText("C Score: " + diceClass.totalAllDice(hand));
    //         }
    //         topPanel.setBounds(0,0,600,600);
    //     }





    //     if (e.getSource() == menuItem3K)
    //     {
    //         int temp = 0;
    //         if (diceClass.maxOfAKindFound(hand) >= 3)
    //             temp = diceClass.totalAllDice(hand);
    //         if (temp != 0 && onlyOne == false)
    //         {
    //             menuItem3K.setVisible(false);
    //             currentScorecard.remove("3K");
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total Score: " + finalScore);

    //         }
    //         onlyOne = true;
    //     }

    //     if (e.getSource() == menuItem4K)
    //     {
    //         int temp = 0;
    //         if (diceClass.maxOfAKindFound(hand) >= 4)
    //             temp = diceClass.totalAllDice(hand);
    //         if (temp > 0 && onlyOne == false)
    //         {
    //             menuItem4K.setVisible(false);
    //             currentScorecard.remove("4K");
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total Score: " + finalScore);

    //         }
    //         onlyOne = true;

    //     }

    //     if (e.getSource() == menuItemFH)
    //     {
    //         int temp = 0;
    //         if (diceClass.fullHouseFound(hand) == true)
    //             temp = 25;

    //         if (temp > 0 && onlyOne == false)
    //         {
    //             menuItemFH.setVisible(false);
    //             currentScorecard.remove("FH");
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total Score: " + finalScore);

    //         }
    //         onlyOne = true;

    //     }

    //     if (e.getSource() == menuItemSS)
    //     {
    //         int temp = 0;
    //         if (diceClass.maxStraightFound(hand) >= 4)
    //             temp = 30;

    //         if (temp > 0 && onlyOne == false)
    //         {
    //             menuItemSS.setVisible(false);
    //             currentScorecard.remove("SS");
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total Score: " + finalScore);

    //         }
    //         onlyOne = true;

    //     }

    //     if (e.getSource() == menuItemLS)
    //     {
    //         int temp = 0;
    //         if (diceClass.maxStraightFound(hand) >= 5)
    //             temp = 40;
    //         if (temp > 0 && onlyOne == false)
    //         {
    //             menuItemLS.setVisible(false);
    //             currentScorecard.remove("LS");
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total Score: " + finalScore);

    //         }
    //         onlyOne = true;

    //     }

    //     if (e.getSource() == menuItemYL)
    //     {
    //         int temp = 0;

    //         if (diceClass.maxOfAKindFound(hand) >= 5)
    //             temp = 50;
    //         if (temp > 0 && onlyOne == false)
    //         {
    //             menuItemYL.setVisible(false);
    //             currentScorecard.remove("YL");
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total Score: " + finalScore);
    //         }
    //         onlyOne = true;

    //     }

    //     if (e.getSource() == menuItemC)
    //     {
    //         if (diceClass.totalAllDice(hand) > 0 && onlyOne == false)
    //         {
    //             menuItemC.setVisible(false);
    //             currentScorecard.remove("C");
    //             int temp = diceClass.totalAllDice(hand);
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total Score: " + finalScore);
    //         }
    //         onlyOne = true;

    //     }

    //     if (e.getSource() == menuItem1)
    //     {

    //         // calc the score for menu item 1
    //         int currentCount = 0;
    //         for (int diePos = 0; diePos < dice; diePos++)
    //         {
    //             if (hand[diePos] == 1)
    //                 currentCount++;
    //         }
    //         // score to be added
    //         int temp = 1*currentCount;



    //         if(temp > 0 && onlyOne == false)
    //         {
    //             menuItem1.setVisible(false);
    //             currentScorecard.remove("1");
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total score: " + finalScore);


    //         }

    //         onlyOne = true;
    //     }

    //     if (e.getSource() == menuItem2)
    //     {
    //         int currentCount = 0;
    //         for (int diePos = 0; diePos < dice; diePos++)
    //         {
    //             if (hand[diePos] == 2)
    //                 currentCount++;
    //         }
    //         int temp = 2*currentCount;
    //         if(temp > 0 && onlyOne == false)
    //         {
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total score: " + finalScore);
    //             menuItem2.setVisible(false);
    //             currentScorecard.remove("2");
    //         }


    //         onlyOne = true;

    //     }

    //     if (e.getSource() == menuItem3)
    //     {
    //         int currentCount = 0;
    //         for (int diePos = 0; diePos < dice; diePos++)
    //         {
    //             if (hand[diePos] == 3)
    //                 currentCount++;
    //         }
    //         int temp = 3*currentCount;
    //         if(temp > 0 && onlyOne == false)
    //         {
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total score: " + finalScore);
    //             menuItem3.setVisible(false);
    //             currentScorecard.remove("3");
    //         }


    //         onlyOne = true;
    //     }


    //     if (e.getSource() == menuItem4)
    //     {
    //         int currentCount = 0;
    //         for (int diePos = 0; diePos < dice; diePos++)
    //         {
    //             if (hand[diePos] == 4)
    //                 currentCount++;
    //         }
    //         int temp = 4*currentCount;

    //         if(temp > 0 && onlyOne == false)
    //         {
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total score: " + finalScore);
    //             menuItem4.setVisible(false);
    //             currentScorecard.remove("4");
    //         }
    //         onlyOne = true;

    //     }

    //     if (e.getSource() == menuItem5)
    //     {
    //         int currentCount = 0;
    //         for (int diePos = 0; diePos < dice; diePos++)
    //         {
    //             if (hand[diePos] == 5)
    //                 currentCount++;
    //         }
    //         int temp = 5*currentCount;
    //         if(temp > 0 && onlyOne == false) 
    //         {
    //             int finalScore = scorecard.updateScores((curenetPlayer-1), temp);
    //             label3.setText("Total score: " + finalScore);
    //             menuItem5.setVisible(false);
    //             currentScorecard.remove("5");
    //         }
    //         onlyOne = true;

    //     }





    //     if (e.getSource() == scoreHide)
    //     {
    //         label4.setVisible(true);
    //         nextPlayerUp.setVisible(true);
    //         if (onlyOne == true)
    //         {
    //             turns = 1;
    //             label4.setText("Turn: " + turns);
    //             curenetPlayer = (((curenetPlayer) % player) + 1);
    //             label3.setText("Total Score: " + scorecard.getSpecScore(curenetPlayer - 1));
    //             topLabel.setText("Player: " + curenetPlayer);
    //             rerollDiceFunction();
    //         }
    //         unhighlight();
    //         topPanel.setBounds(0,0,600,270);
    //         scoreShow.setVisible(true);
    //         rollDice.setVisible(true);
    //         scoreHide.setVisible(false);
    //         topLabel.setText("Player: " + curenetPlayer);

    //         menuItem1.setVisible(false);
    //         menuItem2.setVisible(false);
    //         menuItem3.setVisible(false);
    //         menuItem4.setVisible(false);
    //         menuItem5.setVisible(false);
    //         menuItem3K.setVisible(false);
    //         menuItem4K.setVisible(false);
    //         menuItemFH.setVisible(false);
    //         menuItemSS.setVisible(false);
    //         menuItemLS.setVisible(false);
    //         menuItemYL.setVisible(false);
    //         menuItemC.setVisible(false);
           

    //         dice1Button.setVisible(true);
    //         dice2Button.setVisible(true);
    //         dice3Button.setVisible(true);
    //         dice4Button.setVisible(true);
    //         dice5Button.setVisible(true);
    //         nextPlayer.setVisible(true);

    //         onlyOne = false;
            
    //         if (scorecard.checkGameOver() == true)
    //         {
    //             gameOver = true;
    //         }
    //     }



    //     // function that rolls dice and updates the text on the button
    //     if (e.getSource() == rollDice && turns < 6)
    //     {  
    //         unhighlight();
    //         rerollDiceFunction();
    //         turns ++;
    //         label4.setText("Turn: " + turns);
    //     }
        


    

       

    //     // drp dwn for dice
    //     if(e.getSource() == drpDwnDice)
    //     {
    //         label3.setText("Players: " + ((JComboBox<String>) e.getSource()).getSelectedItem());

    //         JComboBox<String> cb = (JComboBox<String>)e.getSource();
    //         String playerString = (String)cb.getSelectedItem();  
    //         player = Integer.parseInt(playerString);
    //     }


        






    //     // buttons clicked action listen 
    //     // if the button is clicked then the background is set to red and added to an aray list to keep easier tabs

    //     if (e.getSource() == dice1Button)
    //     {
    //         dice1Button.setBackground(Color.red);
    //         rerolledDice.add("1");
    //         dice1Button.setOpaque(true);
    //     }

    //     if (e.getSource() == dice2Button)
    //     {
    //         dice2Button.setBackground(Color.red);
    //         dice2Button.setOpaque(true);
    //         rerolledDice.add("2");
    //     }

    //     if (e.getSource() == dice3Button)
    //     {
    //         dice3Button.setBackground(Color.red);
    //         dice3Button.setOpaque(true);
    //         rerolledDice.add("3");
    //     }

    //     if (e.getSource() == dice4Button)
    //     {
    //         dice4Button.setBackground(Color.red);
    //         dice4Button.setOpaque(true);
    //         rerolledDice.add("4");
    //     }

    //     if (e.getSource() == dice5Button)
    //     {
    //         dice5Button.setBackground(Color.red);
    //         dice5Button.setOpaque(true);
    //         rerolledDice.add("5");
    //     }



    //     // game ending frame 
    //     if (e.getSource() == endGame || gameOver == true)
    //     {
    //         // adding labels to top label
    //         topPanel.add(label5);
    //         topPanel.add(midLabel);
    //         topPanel.add(label6);
    //         topPanel.add(label7);
    //         topPanel.add(label8);

    //         menuItem1.setVisible(false);
    //         menuItem2.setVisible(false);
    //         menuItem3.setVisible(false);
    //         menuItem3K.setVisible(false);
    //         menuItem4.setVisible(false);
    //         menuItem4K.setVisible(false);
    //         menuItem5.setVisible(false);
    //         menuItemC.setVisible(false);
    //         menuItemFH.setVisible(false);
    //         menuItemLS.setVisible(false);
    //         menuItemSS.setVisible(false);
    //         menuItemYL.setVisible(false); 
    //         scoreHide.setVisible(false);


    //         topPanel.setBounds(0,0,600,600);
    //         topPanel.setBackground(Color.pink);
            
            
    //         nextPlayer.setVisible(false);
    //         nextPlayerUp.setVisible(false);
    //         scoreShow.setVisible(false);
    //         rollDice.setVisible(false);
    //         dice1Button.setVisible(false);
    //         dice2Button.setVisible(false);
    //         dice3Button.setVisible(false);
    //         dice4Button.setVisible(false);
    //         dice5Button.setVisible(false);
    //         endGame.setVisible(false);

    //         //TO DO: change text in labels
    //         topLabel.setText("Player 1");
    //         //topLabel.setFont("Times New Roman", Font.PLAIN, 10);
    //         midLabel.setText("Player 2");
    //         //midLabel.setFont("Times New Roman", Font.PLAIN, 10);
    //         label3.setText("Player 3");
    //         //Label3.setFont("Times New Roman", Font.PLAIN, 10);
    //         label4.setText("Player 4");
    //         //label4.setFont("Times New Roman", Font.PLAIN, 10);
    //         label5.setText("Player 5");
    //         //label5.setFont("Times New Roman", Font.PLAIN, 10);
    //         label6.setText("Player 6");
    //         //label6.setFont("Times New Roman", Font.PLAIN, 10);
    //         label7.setText("Player 7");
    //         //label7.setFont("Times New Roman", Font.PLAIN, 10);
    //         label8.setText("Player 8");
    //         //label8.setFont("Times New Roman", Font.PLAIN, 10);


    //         topLabel.setBounds(250, 0, 100, 50);
    //         topLabel.setVisible(true);
    //         midLabel.setBounds(250, 75, 100, 50);
    //         midLabel.setVisible(true);
    //         label3.setBounds(250, 150, 100, 50);
    //         label3.setVisible(true);
    //         label4.setBounds(250, 225, 100, 50);
    //         label4.setVisible(true);
    //         label5.setBounds(250, 300, 100, 50);
    //         label5.setVisible(true);
    //         label6.setBounds(250, 375, 100, 50);
    //         label6.setVisible(true);
    //         label7.setBounds(250, 450, 100, 50);
    //         label7.setVisible(true);
    //         label8.setBounds(250, 525, 100, 50);
    //         label8.setVisible(true);


    //     }
    // }




    // // simple function to unhiglihgt selected dice
    // public void unhighlight()
    // {
    //     if (rerolledDice.isEmpty() == false)
    //     {
    //         turns ++;
    //         label4.setText("Turn: " + turns);
    //         // turns ++;
    //     }
    //     if (rerolledDice.contains("1"))
    //     {
    //         // dice1Button.setOpaque(false);
    //         dice1Button.setBackground(null);
    //         rerolledDice.remove("1");
    //     }

    //     if (rerolledDice.contains("2"))
    //     {
    //         // dice2Button.setOpaque(false);
    //         dice2Button.setBackground(null);
    //         rerolledDice.remove("2");
    //     }

    //     if (rerolledDice.contains("3"))
    //     {
    //         dice3Button.setOpaque(false);
    //         dice3Button.setBackground(null);

    //         rerolledDice.remove("3");
    //     }

    //     if (rerolledDice.contains("4"))
    //     {
    //         dice4Button.setBackground(null);
    //         dice4Button.setOpaque(false);
    //         rerolledDice.remove("4");
            
    //     }

    //     if (rerolledDice.contains("5"))
    //     {
    //         dice5Button.setBackground(null);
    //         dice5Button.setOpaque(false);
    //         rerolledDice.remove("5");

    //     }
    // }



    // public void rerollDiceFunction()
    // {

    //     String dice1Roll = diceClass.rollDice();
    //     dice1Button.setText(dice1Roll);
    //     hand[0] = Integer.parseInt(dice1Roll);
        
    //     String dice2Roll = diceClass.rollDice();
    //     dice2Button.setText(dice2Roll);
    //     hand[1] = Integer.parseInt(dice2Roll);


    //     String dice3Roll = diceClass.rollDice();
    //     dice3Button.setText(dice3Roll);
    //     hand[2] = Integer.parseInt(dice3Roll);

        
    //     String dice4Roll = diceClass.rollDice();
    //     dice4Button.setText(dice4Roll);
    //     hand[3] = Integer.parseInt(dice4Roll);

        
    //     String dice5Roll = diceClass.rollDice();
    //     dice5Button.setText(dice5Roll);
    //     hand[4] = Integer.parseInt(dice5Roll);
    // }
}