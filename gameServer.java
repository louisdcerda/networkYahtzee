import java.io.*;
import java.net.*;

public class gameServer {

    private ServerSocket ss;
    private int numPlayer; // number of players playing
    protected ServerSideConnection player1;
    protected ServerSideConnection player2;
    protected int turnsMade;

    


    public gameServer(){
        System.out.println("---- Game Server ----");
        this.numPlayer = 0; 
        this.turnsMade = 0;
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
                this.dataIn = new DataInputStream(socket.getInputStream());
                this.dataOut = new DataOutputStream(socket.getOutputStream());
            } catch(IOException ex)
            {
                System.out.println("IOException from SSC constructor");
            }
        }


        public void run()
        {
            try{
                this.dataOut.writeInt(playerID);
                this.dataOut.flush();
            } catch (IOException e)
            {
                System.out.println("IOException form run() SSC");
            }
        }
    }

    public static void main (String[] args)
    {
        gameServer gs = new gameServer();
        gs.acceptConnections();
    }
    
    
}