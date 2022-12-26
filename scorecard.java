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
    static ArrayList<ArrayList<String>> scorecard = new ArrayList<ArrayList<String>>();
    
    int player;

    public static void main(String[] args) 
    {
    }



    public static boolean checkGameOver ()
    {
        for (ArrayList<String> i : scorecard)
        {
            if (i.isEmpty() == false)
                return false;
        }
        return true;
    }


    public void setPlayer(int player) {
        this.player = player;
    }


    // sets up the scores for all the players possible 
    public static void setupPlayerScores(ArrayList<Integer> scores)
    {
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