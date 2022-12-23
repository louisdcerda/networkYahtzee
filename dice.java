import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

/*
* This program computes the dice class for our Yahtzee gui
* CPSC 224, Fall 2022
* Programming Assignment Final Prj
* 
* @author Louis Cerda
* @version v1.0 11/21/22
*/

// class returns random roll as a string
// turns and all of that
// total dice
// 

public class dice
{
    int dice;
    dice()
    {
    }


    public String rollDice()
    {
        Random randy = new Random();
        int roll = randy.nextInt(6 - 1 + 1) % 6 + 1;
        String name = String.valueOf(roll);
        return name; // sides number of one
    }

    // totals the dice from hand
    public int totalAllDice(int hand[])
    {
        int total = 0;
        for (int diePos = 0; diePos < 5; diePos++)
            total += hand[diePos];
        return total;
    } 




    // max of a kind function 
    public int maxOfAKindFound(int hand[])
    {
        int maxCount = 0;
        int currentCount;

        for (int dieVal = 1; dieVal <= dice+1; dieVal++)
        {
            currentCount = 0;
            for(int diePos = 0; diePos < dice; diePos++)
            {
                if (hand[diePos] == dieVal)
                    currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }




    // max straight function
    public int maxStraightFound(int hand[])
    {
        int maxLen = 1;
        int curLen = 1;
        
        for (int counter = 0; counter < dice-1; counter++)
        {
            if (hand[counter] + 1 == hand[counter + 1])
                curLen++;
            else if (hand[counter] + 1 < hand[counter + 1])
                curLen = 1;
            if (curLen > maxLen)
                maxLen = curLen;
        }
        return maxLen;
    }




    // full house functuon
    public boolean fullHouseFound(int hand[])
    {
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount;


        for (int dieVal = 1; dieVal <= dice+1; dieVal++)
        {
            currentCount = 0;
            for (int diePos = 0; diePos < dice; diePos++)
            {
                if (hand[diePos] == dieVal)
                    currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
        }
        if (found2K == true && found3K == true)
            return true;
        return foundFH;
    }







    public void rerollSelected(ArrayList<String> rerolledDice, JButton dice1Button, int[]hand, JButton dice2Button, JButton dice3Button, JButton dice4Button, JButton dice5Button)
    {
        if (rerolledDice.contains("1"))
        {
            String dice1Roll = rollDice();
            dice1Button.setText(dice1Roll);
            hand[0] = Integer.parseInt(dice1Roll);
        }

        if (rerolledDice.contains("2"))
        {
            String dice2Roll = rollDice();
            dice2Button.setText(dice2Roll);
            hand[1] = Integer.parseInt(dice2Roll);
        }

        if (rerolledDice.contains("3"))
        {
            String dice3Roll = rollDice();
            dice3Button.setText(dice3Roll);
            hand[2] = Integer.parseInt(dice3Roll);
        }

        if (rerolledDice.contains("4"))
        { 
            String dice4Roll = rollDice();
            dice4Button.setText(dice4Roll);
            hand[3] = Integer.parseInt(dice4Roll);
        }
        if (rerolledDice.contains("5"))
        {            
            String dice5Roll = rollDice();
            dice5Button.setText(dice5Roll);
            hand[4] = Integer.parseInt(dice5Roll);
        }
    }
}
