import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class yahtzeeGUI extends JFrame{
    JButton startBut, next, nextPlayer, rollDice, scoreShow, scoreHide, menuItem3K, 
        menuItem4K, menuItemFH, menuItemSS,menuItemLS, menuItemYL, menuItemC,menuItem1, menuItem2, menuItem3, 
        menuItem4, menuItem5, dice1Button, dice2Button,dice3Button,dice4Button,dice5Button, nextPlayerUp, endGame;

    JLabel topLabel, midLabel, label3, label4, label5, label6, label7, label8; 

    JPanel topPanel, midPanel, lowPanel, endPanel;

    JComboBox<String> drpDwnDice;
    String[] playerOpts = {"1", "2", "3", "4", "5", "6", "7", "8"};




    ArrayList<String> rerolledDice = new ArrayList<>();
    ArrayList<String> currentScorecard;
    ArrayList<String> winners;


    // variblaes 
    boolean onlyOne = false;
    int dice = 5;
    int sides = 6;
    int player = 1;
    int[] hand = new int[dice];  
    int curenetPlayer = 1;
    int turns = 1;
    boolean gameOver = false;
    private int width;
    private int height;



    // classes instantiated
    scorecard scoreClass = new scorecard();
    dice diceClass = new dice();




    public yahtzeeGUI(int w, int h){
        this.width = w;
        this.height = h;

        // creating a drop down menu for dice
        drpDwnDice = new JComboBox<String>(playerOpts);

        // creating a panel
        topPanel = new JPanel();
        midPanel = new JPanel();

        // menu item buttons
        menuItem3K = new JButton(); // 1
        menuItem4K = new JButton();
        menuItemFH = new JButton();
        menuItemLS = new JButton();
        menuItemSS = new JButton();
        menuItemYL = new JButton();
        menuItemC = new JButton();
        menuItem1 = new JButton();
        menuItem2 = new JButton();    
        menuItem3 = new JButton();
        menuItem4 = new JButton();
        menuItem5 = new JButton();

        dice1Button = new JButton(); 
        dice2Button = new JButton(); 
        dice3Button = new JButton(); 
        dice4Button = new JButton(); 
        dice5Button = new JButton(); 

        topLabel = new JLabel();
        midLabel = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        startBut = new JButton();//creating instance of JButton 
        next = new JButton();//creating instance of JButton  
        nextPlayer = new JButton();//creating instance of JButton  
        rollDice = new JButton();//creating instance of JButton  
        scoreShow = new JButton();//creating instance of JButton 
        scoreHide = new JButton();//creating instance of JButton  
        nextPlayerUp = new JButton();//creating instance of JButton  
        endGame = new JButton();//creating instance of JButton  
    }    




    public void setUpGUI()
    {
        this.setSize(width,height);
        this.setTitle("YAHTZEE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // drpDwnDice.addActionListener(this);


        topPanel.setBackground(new Color(75, 75, 75)); // setting color of background panel
        topPanel.setBounds(0, 0, 600, 270);

        midPanel.setBackground(new Color(75, 75, 75)); 
        midPanel.setBounds(0, 270 , 600, 330);

        topPanel.setLayout(null);

        menuItem3K.setText("");
        menuItem3K.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem3K.setBounds(100,125,200,50);
        // menuItem3K.addActionListener(this);

        menuItem4K.setText("");
        menuItem4K.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem4K.setBounds(100,175,200,50);
        // menuItem4K.addActionListener(this);

        menuItemFH.setText("");
        menuItemFH.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItemFH.setBounds(100,225,200,50);
        // menuItemFH.addActionListener(this);

        menuItemLS.setText("");
        menuItemLS.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItemLS.setBounds(100,275,200,50);
        // menuItemLS.addActionListener(this);

        menuItemSS.setText("");
        menuItemSS.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItemSS.setBounds(100,325,200,50);
        // menuItemSS.addActionListener(this);

        menuItemYL.setText("");
        menuItemYL.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItemYL.setBounds(100,375,200,50);
        // menuItemYL.addActionListener(this);

        menuItemC.setText("");
        menuItemC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItemC.setBounds(100,425,200,50);
        // menuItemC.addActionListener(this);

        menuItem1.setText("");
        menuItem1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem1.setBounds(300,125,200,50);
        // menuItem1.addActionListener(this);

        menuItem2.setText("");
        menuItem2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem2.setBounds(300,175,200,50);
        // menuItem2.addActionListener(this);

        menuItem3.setText("");
        menuItem3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem3.setBounds(300,225,200,50);
        // menuItem3.addActionListener(this);
        
        menuItem4.setText("");
        menuItem4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem4.setBounds(300,275,200,50);
        // menuItem4.addActionListener(this);
        
        menuItem5.setText("");
        menuItem5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        menuItem5.setBounds(300,325,200,50);
        // menuItem5.addActionListener(this);

        topPanel.add(menuItem3K);
        topPanel.add(menuItem4K);
        topPanel.add(menuItemFH);
        topPanel.add(menuItemSS);
        topPanel.add(menuItemLS);
        topPanel.add(menuItemYL);
        topPanel.add(menuItemC);
        topPanel.add(menuItem1);
        topPanel.add(menuItem2);
        topPanel.add(menuItem3);
        topPanel.add(menuItem4);
        topPanel.add(menuItem5);

        menuItem3K.setVisible(false);
        menuItem4K.setVisible(false);
        menuItemFH.setVisible(false);
        menuItemLS.setVisible(false);
        menuItemSS.setVisible(false);
        menuItemYL.setVisible(false);
        menuItemC.setVisible(false);
        menuItem1.setVisible(false);
        menuItem2.setVisible(false);
        menuItem3.setVisible(false);
        menuItem4.setVisible(false);
        menuItem5.setVisible(false);


        dice1Button.setText("");
        dice1Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice1Button.setBounds(10,150,75,75);
        // dice1Button.addActionListener(this);
        topPanel.add(dice1Button);
        dice1Button.setVisible(false);

        dice2Button.setText("");
        dice2Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice2Button.setBounds(95,150,75,75);
        // dice2Button.addActionListener(this);
        topPanel.add(dice2Button);
        dice2Button.setVisible(false);

        dice3Button.setText("");
        dice3Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice3Button.setBounds(180,150,75,75);
        // dice3Button.addActionListener(this);
        topPanel.add(dice3Button);
        dice3Button.setVisible(false);

        dice4Button.setText("");
        dice4Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice4Button.setBounds(265,150,75,75);
        // dice4Button.addActionListener(this);
        topPanel.add(dice4Button);
        dice4Button.setVisible(false);
 
        dice5Button.setText("");
        dice5Button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dice5Button.setBounds(350,150,75,75);
        // dice5Button.addActionListener(this);
        topPanel.add(dice5Button);
        dice5Button.setVisible(false);



        topLabel.setText("Welcome to Yahtzee!");
        topLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        topLabel.setBounds(50,50,457,100);



        // middle label blank intially 
        midLabel.setText("");
        midLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        // label 3 blank intially 
        label3.setText("");
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        // label 4 blank intially 
        label4.setText("");
        label4.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        // label 5 blank intially 
        label5.setText("");
        label5.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        // label 6 blank intially 
        label6.setText("");
        label6.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        // label 7 blank intially 
        label7.setText("");
        label7.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        // label 8 blank intially 
        label8.setText("");
        label8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        



        // creating start button
        startBut.setText("Start"); 
        startBut.setPreferredSize(new Dimension(200,50));
        // startBut.addActionListener(this);
        startBut.setBackground(Color.lightGray);
        startBut.setOpaque(true);
        

        next.setText("Next");
        next.setPreferredSize(new Dimension(200,50));
        // next.addActionListener(this);
        next.setBackground(Color.lightGray);
        next.setOpaque(true);

        // creating next player button
        nextPlayer.setText("Reroll Highlighted Dice");
        nextPlayer.setPreferredSize(new Dimension(200,50));
        // nextPlayer.addActionListener(this);
        nextPlayer.setBackground(Color.lightGray);
        nextPlayer.setOpaque(true);

        // creating next player button
        rollDice.setText("Roll All Dice");
        rollDice.setPreferredSize(new Dimension(200,50));
        // rollDice.addActionListener(this);
        rollDice.setBackground(Color.lightGray);
        rollDice.setOpaque(true);

        // creating next player button
        scoreShow.setText("Show Scorecard");
        scoreShow.setPreferredSize(new Dimension(200,50));
        // scoreShow.addActionListener(this);
        scoreShow.setBackground(Color.lightGray);
        scoreShow.setOpaque(true);


        scoreHide.setText("Hide Scorecard");
        scoreHide.setPreferredSize(new Dimension(200,50));
        // scoreHide.addActionListener(this);
        scoreHide.setBackground(Color.lightGray);
        scoreHide.setOpaque(true);

        // creating next player button
        nextPlayerUp.setText("Next Player");
        nextPlayerUp.setPreferredSize(new Dimension(200,50));
        // nextPlayerUp.addActionListener(this);
        nextPlayerUp.setBackground(Color.lightGray);
        nextPlayerUp.setOpaque(true);

        // creating end game button
        endGame.setText("End Game");
        endGame.setPreferredSize(new Dimension(200,50));
        // endGame.addActionListener(this);
        endGame.setBackground(Color.red);
        endGame.setOpaque(true);


        topPanel.add(topLabel);
        topPanel.add(label3);
        topPanel.add(label4);
        midPanel.add(midLabel);
        midPanel.add(startBut);
        topPanel.add(scoreHide);
        scoreHide.setBounds(375,500,150,50);
        scoreHide.setVisible(false);
        this.add(topPanel);
        this.add(midPanel);

        this.setVisible(true);
    }
}
