import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class gameServer {

    private ServerSocket ss;
    private int numPlayer; // number of players playing
    protected ServerSideConnection player1;
    protected ServerSideConnection player2;
    protected int turnsMade;
    protected int curPlayer = 1;
    ArrayList<Integer> scores;

    


    public gameServer(){
        System.out.println("---- Game Server ----");
        this.numPlayer = 0; 
        this.turnsMade = 0;
        scores = new ArrayList<Integer>();
        scorecard.setupPlayerScores(scores);
        try{
            ss = new ServerSocket(51734);
        } catch (IOException ex){
            System.out.println("IOException form GameServer Constuctor");
        }
    }

    public void acceptConnections(){
        try 
        {
            System.out.println("Waiting for connections...");
            while (numPlayer < 2)
            {
                Socket s = ss.accept(); // tells the server to begin accepting connections
                this.numPlayer ++; // after a conection num players increases
                System.out.println("Player # " + this.numPlayer + " has connected.");
                ServerSideConnection ssc = new ServerSideConnection(s, numPlayer);
                if (numPlayer == 1){
                    player1 = ssc;
                } else{
                    player2 = ssc;
                }
                Thread t = new Thread(ssc);
                t.start();
            }
            System.out.println("We now have 2 players. No longer accepting connections");
        } catch (IOException ex)
        {
            System.out.println("IOException from acceptConnections()");
        }
    }




    private class ServerSideConnection implements Runnable
    {
        protected Socket socket;
        protected DataInputStream dataIn;
        protected DataOutputStream dataOut;
        protected int playerID;

        public ServerSideConnection(Socket s, int id)
        {
            this.socket = s;
            this.playerID = id;
            try{
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());
            } catch(IOException ex)
            {
                System.out.println("IOException from SSC constructor");
            }
        }


        public void run()
        {
            try{
                this.dataOut.writeInt(playerID);
                this.dataOut.writeInt(curPlayer); // write out what players turn it is
                this.dataOut.flush();
                
                while (true){
                    if (playerID == 1){
                        player2.sendCurPlayer(curPlayer);
                    }
                }
            } catch (IOException e)
            {
                System.out.println("IOException form run() SSC");
            }
        }

        public void sendCurPlayer(int curPlayer){
            try{
                dataOut.writeInt(curPlayer);
                dataOut.flush();
            } catch(IOException e){
                System.out.println("IOException from gs sendCurPlayer()");
            }
        }
    }

    public static void main (String[] args)
    {
        gameServer gs = new gameServer();
        gs.acceptConnections();
    }
    
    
}