/*
* CPSC 224, Fall 2022
* Programming Assignment Final Prj
* 
* @author Louis Cerda
* @version v1.0 11/21/22
*/
import java.util.ArrayList;

public class scorecard 
{
    // static int player;
    static ArrayList<Integer> scores = new ArrayList<>();
    static ArrayList<ArrayList<String>> scorecard = new ArrayList<ArrayList<String>>();
    
    int player;


    scorecard()
    {
        setupPlayerScores();
        setupPlayerCard();
    }


    public static void main(String[] args) 
    {
    }



    public static boolean checkGameOver ()
    {
        for (ArrayList i : scorecard)
        {
            if (i.isEmpty() == false)
                return false;
        }
        return true;
    }


    public void setPlayer(int player) {
        this.player = player;
    }

    public static ArrayList<String> getSpecScorecard(int cur)
    {
        return scorecard.get(cur);
    }



    public static int getSpecScore(int cur)
    {
        return scores.get(cur);
    }



    public static int updateScores (int curPlayer, int addedScore)
    {
        // calcs the final score of prev score and new score being added
        int finalScore = scores.get(curPlayer) + addedScore;
        // sets the score
        scores.set(curPlayer, finalScore);
        return finalScore;
    }


    // sets up the player card for the scoreboard
    public static void setupPlayerCard()
    {
        ArrayList<String> a1 = new ArrayList<String>();
        ArrayList<String> a2 = new ArrayList<String>();
        ArrayList<String> a3 = new ArrayList<String>();
        ArrayList<String> a4 = new ArrayList<String>();
        ArrayList<String> a5 = new ArrayList<String>();
        ArrayList<String> a6 = new ArrayList<String>();
        ArrayList<String> a7 = new ArrayList<String>();
        ArrayList<String> a8 = new ArrayList<String>();


        a1 = changeInitialArr(a1);
        a2 = changeInitialArr(a2);
        a3 = changeInitialArr(a3);
        a4 = changeInitialArr(a4);
        a5 = changeInitialArr(a5);
        a5 = changeInitialArr(a6);
        a5 = changeInitialArr(a7);
        a5 = changeInitialArr(a8);


        scorecard.add(a1);
        scorecard.add(a2);
        scorecard.add(a3);
        scorecard.add(a4);
        scorecard.add(a5);
        scorecard.add(a6);
        scorecard.add(a7);
        scorecard.add(a8);
    }



    // sets up the scores for all the players possible 
    public static void setupPlayerScores()
    {
        // for (int i = 0; i < players; i++)
        //     scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(0);

    }

    // change intial array to be able to read for the scorecard
    public static ArrayList<String> changeInitialArr(ArrayList<String> list)
    {
        for (int i = 1; i <= 5; i++) 
        {
            String x  = String.valueOf(i);
            list.add(x);
        }
        String[] upperArr = {"3K", "4K", "FH", "SS", "LS", "YL", "C"};
        for (String name : upperArr)
        list.add(name);
        return list;
    }
}
