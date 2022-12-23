import java.io.*;
import java.net.*;

public class gameServer {

    private ServerSocket ss;
    private int numPlayer;

    public gameServer(){
        System.out.println("----Game Server ----");
        this.numPlayer = 0;
        try{
            ss = new ServerSocket(51734);
        } catch (IOException ex){
            System.out.println("IOException form GameServer Constuctor");
        }
    }

    public void acceptConnections(){
        try {
            System.out.println("Waiting for connections...");
            while (numPlayer < 2)
            {
                Socket s = ss.accept();
                this.numPlayer ++;
                System.out.println("Player # " + this.numPlayer + " has connected.");
            }
            System.out.println("We now have 2 players. No longer accepting connections");
        } catch (IOException ex)
        {
            System.out.println("IOException from acceptConnections()");
        }
    }


    public static void main (String[] args)
    {
        gameServer gs = new gameServer();
        gs.acceptConnections();
    }
    
    
}
