/*=====================================================
BOGGLE GAME
Nicholas Lin & Wilbur Zhang
May 12 2021
Java 1.8.0

Class containing all front-end layout/formatting. When run, it creates an instance of the application with all the GUI components and navigation logic

LIST OF GLOBAL VARIABLES
singlePlayerInit            Stores whether the single player user input JTextField has been initialized (type boolean)
pvcInit                     Stores whether the PvC user input JTextField has been initialized (type boolean)
multiPlayerInit             Stores whether the multiplayer user input JTextField have been initialized (type boolean [])
rotateButtonInit            Stores whether the rotate buttons for each game mode have been initialized (type boolean [])
newGameButtonInit           Stores whether the restart game buttons for each game mode have been initialized (type boolean [])
frame                       the JFrame used to make a window for the user to play the game (type JFrame)
R                           Number of rows on boggle board (type int)
C                           Number of columns on boggle board (type int)
guessedWords                Stores the words guessed by player 1 (type ArrayList<String>)
guessedWords2               Stores the words guessed by player 2 or AI (type ArrayList<String>)
boardLogic                  Object storing the current board state and all the valid words of said board (type BoggleBoard())
home                        A button in the top left corner that brings the user back to the main menu when pressed (type JButton)
home2                       A button in the bottom right corner that brings the user back to the main menu when pressed in the How to Play section (type JButton)
startGame                   A button that will bring the user to the gamemodes window when pressed (type JButton)
quit                        A button that will close the frame when pressed (type JButton)
howToPlay                   A button that will bring the user to the How to Play page (type JButton)
gameSettings                A button that will bring the user to the game settings page to let them adjust game settings (type JButton)
singlePlayer                A button that will bring the user to the solo Boggle game (type JButton)
pvp                         A button that will bring the user to the player versus player Boggle game (type JButton)
pvc                         A button that will bring the user to the player versus computer Boggle game (type JButton)
newGameButton               A button that will create a new solo Boggle game (type JButton)
rotateBoardButton           A button that will rotate the board of the solo Boggle game 90 degrees CCW (type JButton)
newGameButton2              A button that will create a new player versus player Boggle game (type JButton)
rotateBoardButton2          A button that will rotate the board of the player versus player Boggle game 90 degrees CCW (type JButton)
newGameButton3              A button that will create a new player versus computer Boggle game (type JButton)
rotateBoardButton3          A button that will rotate the board of the player versus computer Boggle game 90 degrees CCW (type JButton)
buttonsPanel                The panel that holds the four main buttons in the main menu page (type JPanel)
tablePanel                  The panel that displays the 5x5 Boggle board (type JPanel)
userPanel                   The panel that holds the text field where the solo player or player one can guess words (type JPanel)
userPanel2                  The panel that holds the text field where player two and the computer can guess words (type JPanel)
gamemodes                   The panel that holds the buttons for the user to select one of the three gamemodes (type JPanel)
minimumLengthPanel          The panel that holds the label and text field where the user can adjust the minimum length of words (type JPanel)
minimumLengthWarn           The panel that holds the label that appears to tell the user to choose a minimum length between 2 to 5 (type JPanel)
onePTimePanel               The panel that holds the label and text field where the user can adjust the time for a solo game (type JPanel)
onePTimeWarn                The panel that holds the label that appears to tell the user to choose a time between 15 to 300 seconds (type JPanel)
twoPTimePanel               The panel that holds the label and text field where the user can adjust the time per turn for a player versus player or player versus computer game (type JPanel)
twoPTimeWarn                The panel that holds the label that appears to tell the user to choose a time between 5 to 120 seconds for each turn (type JPanel)
maxPointsPanel              The panel that holds the label and text field where the user can adjust the maximum points required to win a player versus player or player versus computer game (type JPanel)
maxPointsWarn               The panel that holds the label that appears to tell the user to choose a point limit between 10 to 100 points for each player (type JPanel)
difficultyLevelPanel        The panel that holds the label and text field where the user can adjust the AI difficulty for a player versus computer game (type JPanel)
difficultyLevelWarn         The panel that holds the label that appears to tell the user to choose a difficulty from 1 to 3, where 1 is easy, 2 is medium, and 3 is hard (type JPanel)
currentWordPanel            The panel that holds the label that constantly updates and displays the players whether or not the word that they have in their text field is valid, guessed, or not valid (type JPanel)
scoreBoardPanel             The panel that holds the score of player 1 or the solo score (type JPanel)
scoreBoardPanel2            The panel that holds the score of player 2 or the computer (type JPanel)
gameButtonPanel             The panel that holds the new game button and rotate board button of the solo Boggle gmae (type JPanel)
gameButtonPanel2            The panel that holds the new game button and rotate board button of the multiplayer Boggle gmae (type JPanel)
gameButtonPanel3            The panel that holds the new game button and rotate board button of the player versus computer Boggle gmae (type JPanel)
timerPanel                  The panel that holds the time for player 1 in pvp and pvc, as well as the solo Boggle game (type JPanel)
timerPanel2                 The panel that holds the time for player 2 in the pvp Boggle game (type JPanel)
player1                     The panel that holds the label for the player1 text label as well as the X's, this is for multiplayer and pvc (type JPanel)
player2                     The panel that holds the label for the player2 text label as well as the X's in multiplayer (type JPanel)
soloLabelPanel              The panel that holds the label for the player1 text label (type JPanel)
computerLabelPanel          The panel that holds the label for the computer text label (type JPanel)
mainMenuPanelGUI            The main panel that holds all the JPanels in the main menu window (type JPanel)
mainGameSettingsPanelGUI    The main panel that holds all the JPanels in the game settings window (type JPanel)
mainGamePanelSoloGUI        The main panel that holds all the JPanels in the singleplayer game (type JPanel)
mainGamePanelMultiGUI       The main panel that holds all the JPanels in the multiplayer game (type JPanel)
mainGamePanelCompGUI        The main panel that holds all the JPanels in the player versus computer game (type JPanel)
mainGamemodesPanelGUI       The main panel that holds all the JPanels in the select gamemodes window (type JPanel)
minimumLength               The text field where the user can adjust the minimum length of words a user can guess (type JTextField)
onePTime                    The text field where the user can adjust the time of the singleplayer game (type JTextField)
twoPTime                    The text field where the user can adjust the time per turn of the multiplayer game (type JTextField)
maxPoints                   The text field where the user can adjust the maximum points a player or computer needs to reach to win the game, for multiplayer and player vc computer (type JTextField)
difficultyLevel             The text field where the user can adjust the difficulty level of the computer AI, 1-easy, 2-medium, 3-hard (type JTextField)
guessWordS                  The text field where the player can guess a word for the singleplayer game (type JTextField)
guessWordP1                 The text field where player 1 can guess a word for the player versus player game (type JTextField)
guessWordP2                 The text field where player 2 can guess a word for the player versus player game (type JTextField)
guessWordCP1                The text field where player 1 can guess a word for the player versus computer game (type JTextField)
guessWordC                  The text field where it displays what word the computer guesses for the player versus computer game (type JTextField)
warning                     The label that appears when user doesn't set a minimum length between the range of 2 to 5 letters (type JLabel)
timeWarning                 The label that appears when the user doesn't set a time between the range of 15 to 300 seconds for a singleplayer Boggle game (type JLabel)
timeWarning2                The label that appears when the user doesn't set a time between the range of 5 to 120 seconds for a multiplayer Boggle game (type JLabel)
maxPointsWarning            The label that appears when the user doesn't set a point limit between the range of 10 to 100 points for a multiplayer or player versus computer Boggle game (type JLabel)
difficultyLevelWarning      The label that appears when the user doesn't set a difficulty between 1-3 for the computer AI in player versus computer Boggle game (type JLabel)
currentWord                 The label that constantly updates and displays to the players whether or not the word that they have in their text field is valid, guessed, or not valid (type JLabel)
time                        The label that displays the value of the gameTimer for singleplayer, player 1 for multiplayer and player versus computer (type JLabel)
time2                       The label that displays the value of the gameTimer for player 2 (type JLabel)
soloLabel                   The label that displays player 1 to indicate where the solo player guesses their word (type JLabel)
computerLabel               The label that displays computer to indicate which text field the computer will guess their word in (type JLabel)
playerOneLabel              The label that displays player 1 to indicate where player 1 guesses their word in multiplayer as well as their number of X's they have (type JLabel)
playerOneX1                 The label that holds the first X for player 1(type JLabel)
playerOneX2                 The label that holds the second X for player 1 (type JLabel)
playerOneX3                 The label that holds the third X for player 1 (type JLabel)
playerTwoLabel              The label that displays player 2 to indicate where player 2 guesses their word in multiplayer as well as their number of X's they have (type JLabel)
playerTwoX1                 The label that holds the first X for player 2 (type JLabel)
playerTwoX2                 The label that holds the second X for player 2 (type JLabel)
playerTwoX3                 The label that holds the third X for player 2 (type JLabel)
wordsCount                  The integer that stores the number of words guessed from the solo player, or player 1 in pvp or pvc (type int)
scoreCount                  The integer that stores the score of the solo player, or player 1 in pvp or pvc (type int)
score                       The label that holds and displays the score of the solo player, or player 1 in pvp or pvc (type JLabel)
words                       The label that holds and displays the number of words guessed from the solo player, or player 1 in pvp or pvc (type JLabel)
wordsCount2                 The integer that stores the number of words guessed from player 2 in pvp or pvc (type int)
scoreCount2                 The integer that stores the score of player 2 in pvp or pvc (type int)
score2                      The label that holds and displays the score of player 2 in pvp or pvc (type JLabel)
words2                      The label that holds and displays the number of words guessed from player 2 in pvp or pvc (type JLabel)
timePerTurn                 The integer that stores the time per turn from the game settings (type int)
gameTimer                   Object controlling all the timers within the game (type Timer())
winner                      The boolean that will display the corresponding colours to display who wins (type boolean)
=====================================================*/

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Timer;

public class Boggle {
    //declare boolean variables and arrays to prevent duplicate ActionListeners
    static boolean singlePlayerInit = true, pvcInit = true;
    static boolean [] multiPlayerInit = new boolean [] {true, true};
    static boolean [] rotateButtonInit = new boolean [] {true, true, true}, newGameButtonInit = new boolean [] {true, true, true};
    //declare frame, dimensions of the board, ArrayList to hold guessed words, and boggle board
    static JFrame frame = new JFrame(); //creates a frame
    static final int R = 5, C = 5;
    static ArrayList<String> guessedWords = new ArrayList<String>();
    static ArrayList<String> guessedWords2 = new ArrayList<String>();
    static BoggleBoard boardLogic;
    //declare all JButton components
    static JButton home = new JButton();
    static JButton home2 = new JButton();
    static JButton startGame = new JButton();
    static JButton quit = new JButton();
    static JButton howToPlay = new JButton();
    static JButton gameSettings = new JButton();
    static JButton singlePlayer = new JButton();
    static JButton pvp = new JButton();
    static JButton pvc = new JButton();
    static JButton newGameButton = new JButton();
    static JButton rotateBoardButton = new JButton();
    static JButton newGameButton2 = new JButton();
    static JButton rotateBoardButton2 = new JButton();
    static JButton newGameButton3 = new JButton();
    static JButton rotateBoardButton3 = new JButton();
    //declare all minor JPanel components
    static JPanel buttonsPanel = new JPanel();
    static JPanel tablePanel = new JPanel();
    static JPanel userPanel = new JPanel();
    static JPanel userPanel2 = new JPanel();
    static JPanel gamemodes = new JPanel();
    static JPanel minimumLengthPanel = new JPanel();
    static JPanel minimumLengthWarn = new JPanel();
    static JPanel onePTimePanel = new JPanel();
    static JPanel onePTimeWarn = new JPanel();
    static JPanel twoPTimePanel = new JPanel();
    static JPanel twoPTimeWarn = new JPanel();
    static JPanel maxPointsPanel = new JPanel();
    static JPanel maxPointsWarn = new JPanel();
    static JPanel difficultyLevelPanel = new JPanel();
    static JPanel difficultyLevelWarn = new JPanel();
    static JPanel currentWordPanel = new JPanel();
    static JPanel scoreBoardPanel = new JPanel();
    static JPanel scoreBoardPanel2 = new JPanel();
    static JPanel gameButtonPanel = new JPanel();
    static JPanel gameButtonPanel2 = new JPanel();
    static JPanel gameButtonPanel3 = new JPanel();
    static JPanel timerPanel = new JPanel();
    static JPanel timerPanel2 = new JPanel();
    static JPanel player1 = new JPanel();
    static JPanel player2 = new JPanel();
    static JPanel soloLabelPanel = new JPanel();
    static JPanel computerLabelPanel = new JPanel();
    //declare all main JPanels that holds all above panels
    static JPanel mainMenuPanelGUI = new JPanel();
    static JPanel mainGameSettingsPanelGUI = new JPanel();
    static JPanel mainGamePanelSoloGUI = new JPanel();
    static JPanel mainGamePanelMultiGUI = new JPanel();
    static JPanel mainGamePanelCompGUI = new JPanel();
    static JPanel mainGamemodesPanelGUI = new JPanel();
    //declare all JTextFields
    static JTextField minimumLength = new JTextField("3");
    static JTextField onePTime = new JTextField("60");
    static JTextField twoPTime = new JTextField("15");
    static JTextField maxPoints = new JTextField("50");
    static JTextField difficultyLevel = new JTextField("1");
    static JTextField guessWordS = new JTextField(25); //declare a new JTextField
    static JTextField guessWordP1 = new JTextField(25); //declare a new JTextField
    static JTextField guessWordP2 = new JTextField(25); //declare a new JTextField
    static JTextField guessWordCP1 = new JTextField(25); //declare a new JTextField
    static JTextField guessWordC = new JTextField(25); //declare a new JTextField
    //declare all JLabels
    static JLabel warning = new JLabel("Please keep the minimum length of the words as 2-5.");
    static JLabel timeWarning = new JLabel("Please keep the time between 15-300s.");
    static JLabel timeWarning2 = new JLabel("Please keep the time between 5-120 seconds.");
    static JLabel maxPointsWarning = new JLabel("Please keep the maximum points between 10-100.");
    static JLabel difficultyLevelWarning = new JLabel("Please enter these numbers: 1-Easy, 2-Medium, 3-Hard");
    static JLabel currentWord = new JLabel();
    static JLabel time = new JLabel();
    static JLabel time2 = new JLabel();
    static JLabel soloLabel = new JLabel();
    static JLabel computerLabel = new JLabel();
    static JLabel playerOneLabel = new JLabel();
    static JLabel playerOneX1 = new JLabel();
    static JLabel playerOneX2 = new JLabel();
    static JLabel playerOneX3 = new JLabel();
    static JLabel playerTwoLabel = new JLabel();
    static JLabel playerTwoX1 = new JLabel();
    static JLabel playerTwoX2 = new JLabel();
    static JLabel playerTwoX3 = new JLabel();

    //declare first scoreboard labels
    static int wordsCount = 0, scoreCount = 0;
    static JLabel score = new JLabel("SCORE: " + scoreCount);
    static JLabel words = new JLabel("WORDS: " + wordsCount);
    //declare second scoreboard labels
    static int wordsCount2 = 0, scoreCount2 = 0;
    static JLabel score2 = new JLabel("SCORE: " + scoreCount);
    static JLabel words2 = new JLabel("WORDS: " + wordsCount);

    static int timePerTurn = Integer.parseInt(twoPTime.getText()); //declare time interval for multiplayer and player versus computer
    static Timer gameTimer; //declare a timer
    static boolean winner = true; //true if player 1 wins, false if player 2 or cpu wins

    /**
     * Void method that generates a new instance of the boggle board w/all the backend logic
     * used to start or restart a game
     * @throws FileNotFoundException if the wordlist.txt file cannot be found
     */
    static void newGame() throws FileNotFoundException {
        boardLogic.ans.clear();
        boardLogic = new BoggleBoard(R, C, Integer.parseInt(minimumLength.getText()));
    }
    /**
     * Void method initiates the two home buttons with their appropriate sizes, colors, and fonts
     */
    public static void declareHome() {
        home.setBounds(15, 15, 60, 20);
        home.setText("Home");
        home.setFocusable(false);
        home.setFont(new Font("SansSerif", Font.BOLD, 8));
        home2.setBounds(555, 445, 100, 50);
        home2.setText("Home");
        home2.setFocusable(false);
        home2.setFont(new Font("SansSerif", Font.BOLD, 15));
    }
    /**
     * Void method that initiates all GUI components and displays the main menu
     */
    public static void declarePanels(){
        declareFrame();
        setPanelTransparent();
        declareButtonsPanelGUI();
        declareGameSettings();
        declareBoggleBoardGUI();
        declareUserPanel();
        declareGamemodes();
        declareHome();
        declareScoreboard();
        declareTimers();
        declarePlayers();
        declareGameButtonPanels();
        declareMainPanels();
        BoggleTime();
    }

    /**
     * Void method that initiates all the main Jpanels
     * Sets their dimensions, layout, and adds all sub-panel components
     */
    public static void declareMainPanels(){
        mainMenuPanelGUI.setSize(800, 600);
        mainGameSettingsPanelGUI.setSize(800, 600);
        mainGamePanelSoloGUI.setSize(800, 600);
        mainGamePanelMultiGUI.setSize(800, 600);
        mainGamePanelCompGUI.setSize(800, 600);
        mainGamemodesPanelGUI.setSize(800, 600);

        mainMenuPanelGUI.setLayout(null);
        mainGameSettingsPanelGUI.setLayout(null);
        mainGamePanelSoloGUI.setLayout(null);
        mainGamePanelMultiGUI.setLayout(null);
        mainGamePanelCompGUI.setLayout(null);
        mainGamemodesPanelGUI.setLayout(null);

        mainMenuPanelGUI.add(buttonsPanel);

        mainGameSettingsPanelGUI.add(minimumLengthPanel);
        mainGameSettingsPanelGUI.add(onePTimePanel);
        mainGameSettingsPanelGUI.add(twoPTimePanel);
        mainGameSettingsPanelGUI.add(maxPointsPanel);
        mainGameSettingsPanelGUI.add(difficultyLevelPanel);
        mainGameSettingsPanelGUI.add(minimumLengthWarn);
        mainGameSettingsPanelGUI.add(onePTimeWarn);
        mainGameSettingsPanelGUI.add(twoPTimeWarn);
        mainGameSettingsPanelGUI.add(maxPointsWarn);
        mainGameSettingsPanelGUI.add(difficultyLevelWarn);
        mainGameSettingsPanelGUI.add(home);

        mainGamemodesPanelGUI.add(gamemodes);
        mainGamemodesPanelGUI.add(home);

        frame.add(mainMenuPanelGUI);
        frame.revalidate();
    }
    /**
     * Void method makes all Jpanel backgrounds transparent to show custom backgrounds
     */
    public static void setPanelTransparent(){
        mainMenuPanelGUI.setOpaque(false);
        mainGameSettingsPanelGUI.setOpaque(false);
        mainGamePanelSoloGUI.setOpaque(false);
        mainGamePanelMultiGUI.setOpaque(false);
        mainGamePanelCompGUI.setOpaque(false);
        mainGamemodesPanelGUI.setOpaque(false);
        buttonsPanel.setOpaque(false);
        userPanel.setOpaque(false);
        userPanel2.setOpaque(false);
        gamemodes.setOpaque(false);
        minimumLengthPanel.setOpaque(false);
        minimumLengthWarn.setOpaque(false);
        onePTimePanel.setOpaque(false);
        onePTimeWarn.setOpaque(false);
        twoPTimePanel.setOpaque(false);
        twoPTimeWarn.setOpaque(false);
        maxPointsPanel.setOpaque(false);
        maxPointsWarn.setOpaque(false);
        difficultyLevelPanel.setOpaque(false);
        difficultyLevelWarn.setOpaque(false);
        currentWordPanel.setOpaque(false);
        scoreBoardPanel.setOpaque(false);
        scoreBoardPanel2.setOpaque(false);
        gameButtonPanel.setOpaque(false);
        gameButtonPanel2.setOpaque(false);
        gameButtonPanel3.setOpaque(false);
        timerPanel.setOpaque(false);
        timerPanel2.setOpaque(false);
        player1.setOpaque(false);
        player2.setOpaque(false);
        soloLabelPanel.setOpaque(false);
        computerLabelPanel.setOpaque(false);
    }
    /**
     * Void method initializes the two score components found in singleplayer and multiplayer game modes
     * sets the fonts, bounds and colors of the text
     */
    public static void declareScoreboard(){
        scoreBoardPanel.setLayout(new GridLayout(0,1, 0,0));
        scoreBoardPanel.setBounds(75, 85, 125, 50);

        words.setSize(100,15);
        score.setSize(100,20);

        words.setFont(new Font("Museo", Font.BOLD, 15));
        score.setFont(new Font("Museo", Font.BOLD, 18));
        words.setForeground(Color.WHITE);
        score.setForeground(Color.WHITE);

        scoreBoardPanel.add(words);
        scoreBoardPanel.add(score);

        scoreBoardPanel2.setLayout(new GridLayout(0,1, 0,0));
        scoreBoardPanel2.setBounds(75, 435, 125, 50);

        words2.setSize(100,15);
        score2.setSize(100,20);

        words2.setFont(new Font("Museo", Font.BOLD, 15));
        score2.setFont(new Font("Museo", Font.BOLD, 18));
        words2.setForeground(Color.WHITE);
        score2.setForeground(Color.WHITE);

        scoreBoardPanel2.add(words2);
        scoreBoardPanel2.add(score2);
    }
    /**
     * Void method that declares declares the player label components that appear above the input input text fields during a game
     * sets their dimensions, layouts, fonts and colors and adds them to the appropriate sub panels
     */
    public static void declarePlayers(){
        soloLabelPanel.setBounds(460, 170, 250, 30);
        soloLabelPanel.setLayout(new FlowLayout());

        soloLabel.setText("Player 1                                           ");
        soloLabel.setFont(new Font("Museo", Font.BOLD, 14));
        soloLabel.setForeground(Color.WHITE);
        soloLabelPanel.add(soloLabel);

        player1.setBounds(460, 170, 250, 30);
        player1.setLayout(new FlowLayout());

        playerOneLabel.setText("Player 1                              ");
        playerOneLabel.setFont(new Font("Museo", Font.BOLD, 14));
        playerOneLabel.setForeground(Color.WHITE);

        playerOneX1.setText("X");
        playerOneX1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
        playerOneX1.setForeground(Color.WHITE);

        playerOneX2.setText("X");
        playerOneX2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        playerOneX2.setForeground(Color.WHITE);

        playerOneX3.setText("X");
        playerOneX3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        playerOneX3.setForeground(Color.WHITE);

        player1.add(playerOneLabel);
        player1.add(playerOneX1);
        player1.add(playerOneX2);
        player1.add(playerOneX3);

        computerLabelPanel.setBounds(460, 320, 250, 30);
        computerLabelPanel.setLayout(new FlowLayout());

        computerLabel.setText("Computer                                       ");
        computerLabel.setFont(new Font("Museo", Font.BOLD, 14));
        computerLabel.setForeground(Color.WHITE);
        computerLabelPanel.add(computerLabel);

        player2.setBounds(460, 320, 250, 30);
        player2.setLayout(new FlowLayout());

        playerTwoLabel.setText("Player 2                              ");
        playerTwoLabel.setFont(new Font("Museo", Font.BOLD, 14));
        playerTwoLabel.setForeground(Color.WHITE);

        playerTwoX1.setText("X");
        playerTwoX1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
        playerTwoX1.setForeground(Color.WHITE);

        playerTwoX2.setText("X");
        playerTwoX2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        playerTwoX2.setForeground(Color.WHITE);

        playerTwoX3.setText("X");
        playerTwoX3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        playerTwoX3.setForeground(Color.WHITE);

        player2.add(playerTwoLabel);
        player2.add(playerTwoX1);
        player2.add(playerTwoX2);
        player2.add(playerTwoX3);
    }

    /**
     * Void method formats the labels and panels used to display timers
     * sets their layout, font, color, and dimensions before adding the labels to their parent sub-panels
     */
    public static void declareTimers(){
        timerPanel.setLayout(new GridLayout(0,1, 0,0));
        timerPanel.setBounds(315, 85, 60, 50);
        timerPanel.setLayout(new FlowLayout());
        time.setForeground(Color.WHITE);
        time.setFont(new Font("Museo", Font.BOLD, 30));
        timerPanel.add(time);

        timerPanel2.setLayout(new GridLayout(0,1, 0,0));
        timerPanel2.setBounds(315, 435, 50, 50);
        timerPanel2.setLayout(new FlowLayout());
        time2.setForeground(Color.WHITE);
        time2.setFont(new Font("Museo", Font.BOLD, 30));
        timerPanel2.add(time2);

    }
    /**
     * Void method formats all the buttons found in the three game mods
     * sets their dimensions, text, and font before adding them to their respective parent sub-panels
     */
    public static void declareGameButtonPanels(){
        gameButtonPanel.setBounds(450, 95, 275, 50);
        gameButtonPanel.setLayout(new FlowLayout());

        gameButtonPanel2.setBounds(450, 95, 275, 50);
        gameButtonPanel2.setLayout(new FlowLayout());

        gameButtonPanel3.setBounds(450, 95, 275, 50);
        gameButtonPanel3.setLayout(new FlowLayout());

        newGameButton.setSize(50, 20);
        newGameButton.setText("New Game");
        newGameButton.setFocusable(false);
        newGameButton.setFont(new Font("SansSerif", Font.BOLD, 11));
        gameButtonPanel.add(newGameButton);

        rotateBoardButton.setSize(50, 20);
        rotateBoardButton.setText("Rotate Board");
        rotateBoardButton.setFocusable(false);
        rotateBoardButton.setFont(new Font("SansSerif", Font.BOLD, 11));
        gameButtonPanel.add(rotateBoardButton);

        newGameButton2.setSize(50, 20);
        newGameButton2.setText("New Game");
        newGameButton2.setFocusable(false);
        newGameButton2.setFont(new Font("SansSerif", Font.BOLD, 11));
        gameButtonPanel2.add(newGameButton2);

        rotateBoardButton2.setSize(50, 20);
        rotateBoardButton2.setText("Rotate Board");
        rotateBoardButton2.setFocusable(false);
        rotateBoardButton2.setFont(new Font("SansSerif", Font.BOLD, 11));
        gameButtonPanel2.add(rotateBoardButton2);

        newGameButton3.setSize(50, 20);
        newGameButton3.setText("New Game");
        newGameButton3.setFocusable(false);
        newGameButton3.setFont(new Font("SansSerif", Font.BOLD, 11));
        gameButtonPanel3.add(newGameButton3);

        rotateBoardButton3.setSize(50, 20);
        rotateBoardButton3.setText("Rotate Board");
        rotateBoardButton3.setFocusable(false);
        rotateBoardButton3.setFont(new Font("SansSerif", Font.BOLD, 11));
        gameButtonPanel3.add(rotateBoardButton3);

        ((FlowLayout)gameButtonPanel.getLayout()).setHgap(35);
        ((FlowLayout)gameButtonPanel2.getLayout()).setHgap(35);
        ((FlowLayout)gameButtonPanel3.getLayout()).setHgap(35);
    }
    /**
     * Void method formats all the components of the settings menu
     * sets their fonts, text, and dimensions before adding them to the appropriate parent sub-panels
     */
    public static void declareGameSettings() {

        minimumLengthPanel.setBounds(0, 175, 800, 30);
        minimumLengthPanel.setLayout(new FlowLayout());
        JLabel minimumLengthLabel = new JLabel("Mininum Length of Words:");
        minimumLengthLabel.setFont(new Font("Museo", Font.BOLD, 20)); //set font as Museo, bolded, and font size 20
        minimumLengthLabel.setForeground(Color.WHITE);
        minimumLengthLabel.setSize(50, 30);

        minimumLength.setFont(new Font("Museo", Font.BOLD, 15));
        minimumLength.setPreferredSize(new Dimension(300, 25));

        warning.setFont(new Font("Museo", Font.BOLD, 11));
        warning.setForeground(Color.WHITE);
        minimumLengthWarn.add(warning);
        minimumLengthWarn.setBounds(375, 200, 300, 20);

        minimumLengthWarn.setVisible(false);
        minimumLengthPanel.add(minimumLengthLabel);
        minimumLengthPanel.add(minimumLength);

        onePTimePanel.setBounds(45, 240, 700, 30);
        onePTimePanel.setLayout(new FlowLayout());
        JLabel onePTimeLabel = new JLabel("Singleplayer Game Time(s):");
        onePTimeLabel.setFont(new Font("Museo", Font.BOLD, 20)); //set font as Museo, bolded, and font size 20
        onePTimeLabel.setSize(50, 30);
        onePTimeLabel.setForeground(Color.WHITE);

        onePTime.setFont(new Font("Museo", Font.BOLD, 15));
        onePTime.setPreferredSize(new Dimension(300, 25));

        timeWarning.setFont(new Font("Museo", Font.BOLD, 11));
        timeWarning.setForeground(Color.WHITE);
        onePTimeWarn.add(timeWarning);
        onePTimeWarn.setBounds(375, 265, 300, 20);
        onePTimeWarn.setVisible(false);
        onePTimePanel.add(onePTimeLabel);
        onePTimePanel.add(onePTime);


        twoPTimePanel.setBounds(50, 315, 700, 30);
        twoPTimePanel.setLayout(new FlowLayout());
        JLabel twoPTimeLabel = new JLabel("PvP/PvC Time per Turn(s):");
        twoPTimeLabel.setFont(new Font("Museo", Font.BOLD, 20)); //set font as Museo, bolded, and font size 20
        twoPTimeLabel.setSize(50, 30);
        twoPTimeLabel.setForeground(Color.WHITE);

        twoPTime.setFont(new Font("Museo", Font.BOLD, 15));
        twoPTime.setPreferredSize(new Dimension(300, 25));
        twoPTimePanel.add(twoPTimeLabel);
        twoPTimePanel.add(twoPTime);

        timeWarning2.setFont(new Font("Museo", Font.BOLD, 11));
        timeWarning2.setForeground(Color.WHITE);
        twoPTimeWarn.add(timeWarning2);
        twoPTimeWarn.setBounds(375, 340, 300, 20);
        twoPTimeWarn.setVisible(false);

        maxPointsPanel.setBounds(64, 390, 700, 30);
        maxPointsPanel.setLayout(new FlowLayout());
        JLabel maxPointsLabel = new JLabel("PvP/PvC Points to Win:");
        maxPointsLabel.setFont(new Font("Museo", Font.BOLD, 20)); //set font as Museo, bolded, and font size 20
        maxPointsLabel.setSize(50, 30);
        maxPointsLabel.setForeground(Color.WHITE);

        maxPoints.setFont(new Font("Museo", Font.BOLD, 15));
        maxPoints.setPreferredSize(new Dimension(300, 25));
        maxPointsPanel.add(maxPointsLabel);
        maxPointsPanel.add(maxPoints);

        maxPointsWarning.setFont(new Font("Museo", Font.BOLD, 11));
        maxPointsWarning.setForeground(Color.WHITE);
        maxPointsWarn.add(maxPointsWarning);
        maxPointsWarn.setBounds(375, 415, 300, 20);
        maxPointsWarn.setVisible(false);

        difficultyLevelPanel.setBounds(77, 465, 700, 30);
        difficultyLevelPanel.setLayout(new FlowLayout());
        JLabel difficultLevelLabel = new JLabel("PvC Difficulty Level:");
        difficultLevelLabel.setFont(new Font("Museo", Font.BOLD, 20)); //set font as Museo, bolded, and font size 20
        difficultLevelLabel.setSize(50, 30);
        difficultLevelLabel.setForeground(Color.WHITE);

        difficultyLevel.setFont(new Font("Museo", Font.BOLD, 15));
        difficultyLevel.setPreferredSize(new Dimension(300, 25));
        difficultyLevelPanel.add(difficultLevelLabel);
        difficultyLevelPanel.add(difficultyLevel);

        difficultyLevelWarning.setFont(new Font("Museo", Font.BOLD, 11));
        difficultyLevelWarning.setForeground(Color.WHITE);
        difficultyLevelWarn.add(difficultyLevelWarning);
        difficultyLevelWarn.setBounds(375, 490, 300, 20);
        difficultyLevelWarn.setVisible(false);
    }
    /**
     * Void method formats the game mode selection screen
     * Sets the text of the buttons and adds it to the appropriate parent sub-panel
     */
    public static void declareGamemodes(){
        gamemodes.setBounds(0, 300, 800, 35); //set the size of the panel and location
        gamemodes.setLayout(new FlowLayout()); //set the panel as FlowLayout

        singlePlayer.setText("Choose");
        singlePlayer.setFocusable(false);
        gamemodes.add(singlePlayer);

        pvp.setText("Choose");
        pvp.setFocusable(false);
        gamemodes.add(pvp);

        pvc.setText("Choose");
        pvc.setFocusable(false);
        gamemodes.add(pvc);

        ((FlowLayout)gamemodes.getLayout()).setHgap(175); //gap between each button
    }
    /**
     * Void method formats the user input related components for each gamemode. (includes input Jtext fields and the status of the input)
     * declares the dimensions layout, colors and font before adding them to the appropriate parent sub-panels
     */
    public static void declareUserPanel(){
        guessWordS.setPreferredSize(new Dimension( 200, 24));
        guessWordP1.setPreferredSize(new Dimension( 200, 24));
        guessWordP2.setPreferredSize(new Dimension( 200, 24));
        guessWordC.setPreferredSize(new Dimension( 200, 24));
        guessWordCP1.setPreferredSize(new Dimension( 200, 24));

        userPanel.setBounds(400, 200, 375, 30);
        userPanel.setLayout(new FlowLayout());

        userPanel2.setBounds(400, 350, 375, 30);
        userPanel2.setLayout(new FlowLayout());

        currentWordPanel.setBounds(415, 260, 315, 30);
        currentWordPanel.setLayout(new FlowLayout());

        currentWord.setForeground(Color.BLACK);
        currentWord.setText("");
        currentWord.setFont(new Font("Museo", Font.BOLD, 20));
        currentWordPanel.add(currentWord);
    }
    /**
     * Void method formats the frame properties, sets its background and displays it to the user
     */
    public static void declareFrame(){
        frame.setTitle("Boggle!"); //sets title of frame to Boggle!
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
        frame.setLayout(null); //sets a null layout to the frame
        frame.setResizable(false); //keep the frame from being adjusted
        frame.setSize(800, 600); //sets the x-dimension, and y-dimension of frame at 800 and 600 respectively
        frame.setLocationRelativeTo(null); //centers frame on the user's screen
        frame.setContentPane(new JLabel(new ImageIcon("BoggleBackground.png")));
        frame.setVisible(true);
    }
    /**
     * Void method formats the buttons found on the main menu. Also sets formats the parent sub-board
     * sets the button dimensions, font and borders before adding them to the parent sub-board
     */
    public static void declareButtonsPanelGUI(){
        buttonsPanel.setBounds(60, 325, 425, 125); //set the size as 50x375 and set their starting left corner at (42, 300) of the frame
        buttonsPanel.setLayout(new GridLayout(2, 2, 25, 25)); //set the layout as FlowLayout to allow buttons to be placed next to each other

        startGame.setText("Play Game"); //set text as New Game for the button
        startGame.setFont(new Font("SansSerif", Font.BOLD, 15));
        startGame.setFocusable(false); //remove the border around the button
        buttonsPanel.add(startGame); //add button to the panel

        howToPlay.setText("How to Play"); //set text as New Game for the button
        howToPlay.setFont(new Font("SansSerif", Font.BOLD, 15));
        howToPlay.setFocusable(false); //remove the border around the button
        buttonsPanel.add(howToPlay); //add button to the panel

        gameSettings.setText("Game Settings"); //set text as New Game for the button
        gameSettings.setFont(new Font("SansSerif", Font.BOLD, 15));
        gameSettings.setFocusable(false); //remove the border around the button
        buttonsPanel.add(gameSettings); //add button to the panel

        quit.setText("Quit"); //set text as "Quit" for the button
        quit.setFont(new Font("SansSerif", Font.BOLD, 15));
        quit.setFocusable(false); //remove the border around the button
        buttonsPanel.add(quit); //add button to the panel

        //((FlowLayout)scramblePanel.getLayout()).setHgap(28); //set a horizontal gap of 28 pixels between the buttons

        //frame.add(buttonsPanel); //add panel to frame
    }
    /**
     * Void method that formats the graphical representation of the current board state
     * Sets the fonts, borders and colors of the board while copying each dice face to a grid of JLabels
     */
    public static void declareBoggleBoardGUI(){
        tablePanel.removeAll();
        Border border = BorderFactory.createLineBorder(new Color(40, 91, 138), 5); //create a new border of a blue colour with thickness of 5 pixels
        tablePanel.setBounds(75, 135, 300, 300); //set the location and size of the grid panel
        tablePanel.setLayout(new GridLayout(R, C, 1, 1)); //declare a new grid layout with dimensions of table.length and a gap between the boxes of 1 pixel
        tablePanel.setBorder(border); //set the tablePanel's border as the blue border we created
        tablePanel.setBackground(new Color(237, 237, 237)); //set the background as white, as in the boxes on the grid
        for (int i = 0; i < R; i++) { //runs along each row
            for (int j = 0; j < C; j++) { //for each value in the row
                JLabel label = new JLabel(boardLogic.board[i][j]); //declare a new label that has the value as the letter that is stored as a String inside the 2D array table
                label.setFont(new Font("Helvetica", Font.BOLD, 25 - boardLogic.board.length)); //set the font of each label as Helvetic, bolded, and a font size that will suit the grid depending on the dimension, this makes code usable even for dimensions other than 6
                label.setHorizontalAlignment(JLabel.CENTER); //set the alignment of the text as center
                label.setBackground(Color.WHITE); //set background colour of the labels as white
                label.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //set the border of each box as gray
                tablePanel.add(label); //add the label to the tablePanel - which is is grid layout
            }
        }
    }
    /**
     * Void method displays the main menu panel and hides all other interfaces
     */
    public static void mainMenu(){
        mainMenuPanelGUI.setVisible(true);
        mainGameSettingsPanelGUI.setVisible(false);
        mainGamemodesPanelGUI.setVisible(false);
        mainGamePanelSoloGUI.setVisible(false);
        mainGamePanelMultiGUI.setVisible(false);
    }
    /**
     * Void method that calls the method to display the main menu of the game
     * Holds all action listeners for the four buttons in the home screen
     * Holds all action listeners for the three gamemode buttons after play game button is pressed
     * Holds all in game buttons for the three gamemodes (new game and rotate board)
     * Holds action listeners for both of the home buttons
     * When buttons are pressed, the main panels that hold all of the GUI components will be declared or removed to ensure the background displays correctly
     * For each gamemode, it will call its respective playGame___ method and run___Timer
     */
    public static void BoggleTime() {
        mainMenu();
        quit.addActionListener(e -> {
            System.out.println("Thanks for playing!"); // user friendly output
            System.exit(0); //end the code
        });
        startGame.addActionListener(new ActionListener() {
            /**
             * Void method loads the game selection menu when respective button is pressed
             *
             * @param e the action performed by the user (type ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //set the visibility of the main menu main panel to false and add the main gamemodes panel
                mainMenuPanelGUI.setVisible(false);
                frame.setContentPane(new JLabel(new ImageIcon("gamemodes.png"))); //change background
                mainGamemodesPanelGUI.add(home);
                mainGamemodesPanelGUI.setVisible(true);
                frame.add(mainGamemodesPanelGUI); //add gamemodes panel to frame

                //reset score
                scoreCount = 0;
                wordsCount = 0;
                score.setText("SCORE: " + scoreCount);
                words.setText("WORDS: " + wordsCount);

                singlePlayer.addActionListener(new ActionListener() {
                    @Override
                    /**
                     * Void method that declares all components of the singleplayer game and runs the game
                     *
                     * LIST OF LOCAL VARIABLES
                     * interval     an integer that stores the time for a singleplayer game determined by the game settings (type boolean[])
                     *
                     * @param e the action performed by the user (type ActionEvent)
                     */
                    public void actionPerformed(ActionEvent e) {
                        //create a new boggle board and declare it so it updates on the frame
                        try {
                            newGame();
                            declareBoggleBoardGUI();
                            guessedWords.clear(); //clear the guessedWords array list
                        } catch (FileNotFoundException fileNotFoundException) { //catch exception
                            fileNotFoundException.printStackTrace();
                        }
                        //remove/hide any pre-existing main panels
                        mainGamePanelMultiGUI.removeAll();
                        mainGamePanelCompGUI.removeAll();
                        mainGamemodesPanelGUI.setVisible(false);
                        frame.remove(mainGamePanelMultiGUI); //removing prevents background bugs
                        frame.remove(mainGamePanelCompGUI);
                        frame.setContentPane(new JLabel(new ImageIcon("singleplayer.png"))); //set new background for singleplayer
                        mainGamePanelSoloGUI.setVisible(true);

                        //add all necessary components to mainGamePanelSoloGUI
                        mainGamePanelSoloGUI.add(tablePanel);
                        userPanel.remove(guessWordP1);
                        userPanel.remove(guessWordCP1);
                        userPanel.add(guessWordS);
                        mainGamePanelSoloGUI.add(userPanel);
                        mainGamePanelSoloGUI.add(scoreBoardPanel);
                        mainGamePanelSoloGUI.add(gameButtonPanel);
                        mainGamePanelSoloGUI.add(currentWordPanel);
                        mainGamePanelSoloGUI.add(timerPanel);
                        mainGamePanelSoloGUI.add(soloLabelPanel);
                        mainGamePanelSoloGUI.add(home);
                        mainGamePanelSoloGUI.add(timerPanel);
                        mainGamePanelSoloGUI.add(home);
                        frame.add(mainGamePanelSoloGUI); //add mainGamePanelSoloGUI to the frame

                        //get the time for each game from game settings and call the singleplayer timer and play the game
                        runSinglePlayerTimer(Integer.parseInt(onePTime.getText()));
                        playGameSingle();

                        if (newGameButtonInit[0]) {
                            newGameButton.addActionListener(new ActionListener() {
                                @Override
                                /**
                                 *  Void method that resets board, score, time, and starts the game over
                                 *
                                 *  LIST OF LOCAL VARIABLES
                                 *  interval     an integer that stores the time for a singleplayer game determined by the game settings (type boolean[])
                                 *
                                 *  @param e the action performed by the user (type ActionEvent)
                                 */
                                public void actionPerformed(ActionEvent e) {
                                    //create a new boggle board and declare it so it updates on the frame
                                    try {
                                        newGame();
                                        declareBoggleBoardGUI();
                                        guessedWords.clear(); //clear arrayList for the game
                                    } catch (FileNotFoundException fileNotFoundException) { //catch exception
                                        fileNotFoundException.printStackTrace();
                                    }
                                    //reset scoreboard and word count
                                    scoreCount = 0;
                                    wordsCount = 0;
                                    score.setText("SCORE: " + scoreCount);
                                    words.setText("WORDS: " + wordsCount);

                                    //get the time from gamesettings and call the timer and playGame method for singleplayer
                                    runSinglePlayerTimer(Integer.parseInt(onePTime.getText()));
                                    playGameSingle();
                                    frame.revalidate(); //revalidate frame
                                }
                            });
                            newGameButtonInit[0] = false;
                        }
                        if(rotateButtonInit[0]) {
                            rotateBoardButton.addActionListener(new ActionListener() {
                                @Override
                                /**
                                 * Void method that creates a board copy that is rotated 90 degrees and declares the new board as the board copy
                                 *
                                 * LIST OF LOCAL VARIABLES
                                 * boardCopy    a 2D array that is the copy of the original board but values are stored 90 degrees CCW (type String[][])
                                 *
                                 * @param e the action performed by the user (type ActionEvent)
                                 */
                                public void actionPerformed(ActionEvent e) {
                                    //create a board copy that we will rotate 90 degrees CCW
                                    String[][] boardCopy = new String[5][5];
                                    for (int i = 0; i < 5; i++) {
                                        for (int j = 0; j < 5; j++) {
                                            boardCopy[i][j] = boardLogic.board[j][4-i]; //rotates board 90 according to the way we copy
                                        }
                                    }
                                    boardLogic.board = boardCopy; //replace board with the boardCopy
                                    declareBoggleBoardGUI(); //display rotated board on the frame
                                    frame.revalidate(); //revalidate frame
                                }
                            });
                            rotateButtonInit[0] = false;
                        }
                        ((JButton) e.getSource()).removeActionListener(this); //remove the rotate board actionlistener so rotate board doesn't rotate more that 90 degrees
                    }
                });
                pvp.addActionListener(new ActionListener() {
                    @Override
                    /**
                     * Void method that declares all components of the multiplayer game and runs the game
                     *
                     * LIST OF LOCAL VARIABLES
                     * turn         an array that can be passed by reference and stores a boolean to determine which player's turn it is (type boolean[])
                     * x            an integer that is either 0 or 1, simulating a 50/50 outcome (type int)
                     * pCountX      an array that holds two values to be passed by reference and it contains the number of X's for each player (type int[])
                     *
                     * @param e the action performed by the user (type ActionEvent)
                     */
                    public void actionPerformed(ActionEvent e) {
                        //create a new boggle board and declare it so it updates on the frame
                        try {
                            newGame();
                            declareBoggleBoardGUI();
                        } catch (FileNotFoundException fileNotFoundException) { //catch exception
                            fileNotFoundException.printStackTrace();
                        }
                        //remove/hide the other game panels and gamemode panel
                        mainGamePanelSoloGUI.removeAll();
                        mainGamePanelCompGUI.removeAll();
                        mainGamemodesPanelGUI.setVisible(false);
                        frame.remove(mainGamePanelSoloGUI);
                        frame.remove(mainGamePanelCompGUI);
                        frame.setContentPane(new JLabel(new ImageIcon("pvp.png"))); //set new background for player versus player

                        //add all the necessary components for the multiplayer game and add it to the main multiplayer panel
                        mainGamePanelMultiGUI.setVisible(true); //set visible
                        mainGamePanelMultiGUI.add(home);
                        mainGamePanelMultiGUI.add(tablePanel);
                        userPanel.add(guessWordP1);
                        userPanel.remove(guessWordCP1); //remove element from other gamemode
                        userPanel.remove(guessWordS); //remove element from other gamemode
                        mainGamePanelMultiGUI.add(userPanel);
                        mainGamePanelMultiGUI.add(scoreBoardPanel);
                        mainGamePanelMultiGUI.add(gameButtonPanel2);
                        mainGamePanelMultiGUI.add(currentWordPanel);
                        mainGamePanelMultiGUI.add(timerPanel);
                        mainGamePanelMultiGUI.add(player1);
                        mainGamePanelMultiGUI.add(scoreBoardPanel2);
                        mainGamePanelMultiGUI.add(timerPanel2);
                        userPanel2.add(guessWordP2); //remove element from other gamemode
                        userPanel2.remove(guessWordC);
                        mainGamePanelMultiGUI.add(userPanel2);
                        mainGamePanelMultiGUI.add(player2);

                        frame.add(mainGamePanelMultiGUI); //add to frame

                        //reset scores for both scoreboard
                        scoreCount = 0;
                        wordsCount = 0;
                        score.setText("SCORE: " + scoreCount);
                        words.setText("WORDS: " + wordsCount);

                        scoreCount2 = 0;
                        wordsCount2 = 0;
                        score2.setText("SCORE: " + scoreCount2);
                        words2.setText("WORDS: " + wordsCount2);

                        //initialize true array, which means it's player 1's turn
                        final boolean[] turn = {true};

                        //assuming it's player 1's turn, player 2 loses access of their text field
                        guessWordP1.setEnabled(true);
                        guessWordP1.setBackground(Color.WHITE);
                        guessWordP2.setEnabled(false);
                        guessWordP2.setBackground(Color.GRAY);

                        //initialize X counter for both players
                        int[] pCountX = {0,0};

                        //create a 50/50 generator to determine which player goes first
                        Random rand = new Random();
                        int x = rand.nextInt(2);
                        if(x == 1){ //if x is 1, then it is player 2's turn, if not, it will be player 1's turn and textfields were declared above already
                            turn[0] = false;
                            guessWordP1.setEnabled(false);
                            guessWordP1.setBackground(Color.GRAY);
                            guessWordP2.setEnabled(true);
                            guessWordP2.setBackground(Color.WHITE);
                        }

                        runMultiPlayerTimer(turn, pCountX); //call the timer and pass the arguments turn and pCountX
                        playGameMulti(turn, pCountX); //play the multiplayer game

                        if(newGameButtonInit[1]) {
                            newGameButton2.addActionListener(new ActionListener() {
                                @Override
                                /**
                                 *  Void method that resets board, score, time, and starts the game over
                                 *
                                 *  LIST OF LOCAL VARIABLES
                                 *  turn         an array that can be passed by reference and stores a boolean to determine which player's turn it is (type boolean[])
                                 *  x            an integer that is either 0 or 1, simulating a 50/50 outcome (type int)
                                 *  pCountX      an array that holds two values to be passed by reference and it contains the number of X's for each player (type int[])
                                 *
                                 *  @param e the action performed by the user (type ActionEvent)
                                 */
                                public void actionPerformed(ActionEvent e) {
                                    int[] pCountX = {0,0}; //declare pCountX

                                    //reset scoreboards
                                    scoreCount = 0;
                                    wordsCount = 0;
                                    score.setText("SCORE: " + scoreCount);
                                    words.setText("WORDS: " + wordsCount);

                                    scoreCount2 = 0;
                                    wordsCount2 = 0;
                                    score2.setText("SCORE: " + scoreCount2);
                                    words2.setText("WORDS: " + wordsCount2);
                                    //declare new board
                                    try {
                                        newGame();
                                        declareBoggleBoardGUI();

                                    } catch (FileNotFoundException fileNotFoundException) { //catch exception
                                        fileNotFoundException.printStackTrace();
                                    }

                                    //declare turn for either player 1 or 2
                                    boolean[] turn = {true};
                                    guessWordP1.setEnabled(true);
                                    guessWordP1.setBackground(Color.WHITE);
                                    guessWordP2.setEnabled(false);
                                    guessWordP2.setBackground(Color.GRAY);

                                    Random rand = new Random();
                                    int x = rand.nextInt(2);

                                    if(x == 1){
                                        turn[0] = false;
                                        guessWordP1.setEnabled(false);
                                        guessWordP1.setBackground(Color.GRAY);
                                        guessWordP2.setEnabled(true);
                                        guessWordP2.setBackground(Color.WHITE);
                                    }

                                    //call methods to restart game and timer
                                    runMultiPlayerTimer(turn, pCountX);
                                    playGameMulti(turn, pCountX);
                                    frame.revalidate();

                                }
                            });
                            newGameButtonInit[1] = false;
                        }
                        if(rotateButtonInit[1]) {
                            rotateBoardButton2.addActionListener(new ActionListener() {
                                @Override
                                /**
                                 * Void method that creates a board copy that is rotated 90 degrees and declares the new board as the board copy
                                 *
                                 * LIST OF LOCAL VARIABLES
                                 * boardCopy    a 2D array that is the copy of the original board but values are stored 90 degrees CCW (type String[][])
                                 *
                                 * @param e the action performed by the user (type ActionEvent)
                                 */
                                public void actionPerformed(ActionEvent e) {
                                    String[][] boardCopy = new String[5][5];
                                    for (int i = 0; i < 5; i++) {
                                        for (int j = 0; j < 5; j++) {
                                            boardCopy[i][j] = boardLogic.board[j][4-i];
                                        }
                                    }
                                    boardLogic.board = boardCopy;
                                    declareBoggleBoardGUI();
                                    frame.revalidate();
                                }
                            });
                            ((JButton) e.getSource()).removeActionListener(this);
                            rotateButtonInit[1] = false;
                        }
                        ((JButton) e.getSource()).removeActionListener(this);
                    }
                });
                pvc.addActionListener(new ActionListener() {
                    @Override
                    /**
                     * Void method that declares all components of the person versus computer game and runs the game
                     *
                     * LIST OF LOCAL VARIABLES
                     * ai       Generates RNG'd guesses weighted on the difficulty (type ai())
                     * pCountX  Stores the penalties of each player (type int[])
                     *
                     * @param e the action performed by the user (type ActionEvent)
                     */
                    public void actionPerformed(ActionEvent e) {
                        try {
                            newGame();
                            declareBoggleBoardGUI();
                            guessedWords.clear();
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                        mainGamePanelSoloGUI.removeAll();
                        mainGamePanelMultiGUI.removeAll();
                        mainGamemodesPanelGUI.setVisible(false);
                        frame.remove(mainGamePanelSoloGUI);
                        frame.remove(mainGamePanelMultiGUI);
                        frame.setContentPane(new JLabel(new ImageIcon("computer.png")));
                        mainGamePanelCompGUI.setVisible(true);
                        mainGamePanelCompGUI.add(home);

                        mainGamePanelCompGUI.add(tablePanel);
                        userPanel.remove(guessWordP1);
                        userPanel.add(guessWordCP1);
                        userPanel.remove(guessWordS);
                        mainGamePanelCompGUI.add(userPanel);
                        mainGamePanelCompGUI.add(scoreBoardPanel);
                        mainGamePanelCompGUI.add(gameButtonPanel3);
                        mainGamePanelCompGUI.add(currentWordPanel);
                        mainGamePanelCompGUI.add(timerPanel);
                        mainGamePanelCompGUI.add(player1);
                        mainGamePanelCompGUI.add(scoreBoardPanel2);
                        userPanel2.remove(guessWordP2);
                        userPanel2.add(guessWordC);
                        mainGamePanelCompGUI.add(userPanel2);
                        mainGamePanelCompGUI.add(computerLabelPanel);

                        frame.add(mainGamePanelCompGUI);

                        scoreCount = 0;
                        wordsCount = 0;
                        score.setText("SCORE: " + scoreCount);
                        words.setText("WORDS: " + wordsCount);

                        scoreCount2 = 0;
                        wordsCount2 = 0;
                        score2.setText("SCORE: " + scoreCount2);
                        words2.setText("WORDS: " + wordsCount2);

                        AI ai = new AI(boardLogic.ans, Integer.parseInt(difficultyLevel.getText()));
                        int[] pCountX = {0};
                        runPvCTimer(Integer.parseInt(twoPTime.getText()), pCountX, ai);
                        playGameComp(pCountX, ai);
                        if(newGameButtonInit[2]) {
                            newGameButton3.addActionListener(new ActionListener() {
                                /**
                                 * Void method that restarts the current game mode when respective button is pressed
                                 *
                                 * LIST OF LOCAL VARIABLES
                                 * ai       Generates RNG'd guesses weighted on the difficulty (type ai())
                                 * pCountX  Stores the penalties of each player (type int[])
                                 *
                                 * @param e the action performed by the user (type ActionEvent)
                                 */
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        newGame();
                                        declareBoggleBoardGUI();
                                    } catch (FileNotFoundException fileNotFoundException) {
                                        fileNotFoundException.printStackTrace();
                                    }
                                    scoreCount = 0;
                                    wordsCount = 0;
                                    score.setText("SCORE: " + scoreCount);
                                    words.setText("WORDS: " + wordsCount);

                                    scoreCount2 = 0;
                                    wordsCount2 = 0;
                                    score2.setText("SCORE: " + scoreCount2);
                                    words2.setText("WORDS: " + wordsCount2);

                                    AI ai = new AI(boardLogic.ans, Integer.parseInt(difficultyLevel.getText()));
                                    int[] pCountX = {0};
                                    playGameComp(pCountX, ai);
                                    runPvCTimer(Integer.parseInt(twoPTime.getText()), pCountX, ai);
                                    frame.revalidate();

                                }
                            });
                            newGameButtonInit[2] = false;
                        }
                        if(rotateButtonInit[2]) {
                            rotateBoardButton3.addActionListener(new ActionListener() {
                                /**
                                 * Void method that rotates the board counterclockwise when respective button is pressed
                                 *
                                 * LIST OF LOCAL VARIABLES
                                 * boardCopy    a 2D array that is the copy of the original board but values are stored 90 degrees CCW (type String[][])
                                 *
                                 * @param e the action performed by the user (type ActionEvent)
                                 */
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String[][] boardCopy = new String[5][5];
                                    for (int i = 0; i < 5; i++) {
                                        for (int j = 0; j < 5; j++) {
                                            boardCopy[i][j] = boardLogic.board[j][4-i];
                                        }
                                    }
                                    boardLogic.board = boardCopy;
                                    declareBoggleBoardGUI();
                                    frame.revalidate();
                                }
                            });
                            rotateButtonInit[2] = false;
                            ((JButton) e.getSource()).removeActionListener(this);
                        }
                        ((JButton) e.getSource()).removeActionListener(this);
                    }
                });
                home.addActionListener(new ActionListener() {
                    /**
                     * Displays the main menu when respective button is pressed
                     *
                     * @param e the action performed by the user (type ActionEvent)
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{ //purges old timer if there is one
                            gameTimer.cancel();
                        } catch (NullPointerException n) {}
                        frame.remove(mainGameSettingsPanelGUI);
                        frame.remove(mainGamePanelMultiGUI);
                        frame.remove(mainGamePanelSoloGUI);
                        frame.remove(mainGamePanelCompGUI);
                        frame.remove(mainGamemodesPanelGUI);
                        frame.setContentPane(new JLabel(new ImageIcon("BoggleBackground.png")));
                        frame.add(mainMenuPanelGUI);
                        mainMenuPanelGUI.setVisible(true); //this
                        ((JButton) e.getSource()).removeActionListener(this);
                    }
                });
            }
        });
        howToPlay.addActionListener(new ActionListener() {
            /**
             * Displays the help menu then the respective button is pressed
             *
             * @param e the action performed by the user (type ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuPanelGUI.setVisible(false);
                frame.setContentPane(new JLabel(new ImageIcon("HowToPlay.png")));
                frame.add(home2);
                home2.setVisible(true);

                home2.addActionListener(new ActionListener() {
                    /**
                     * Displays the main menu when respective button is pressed
                     *
                     * @param e the action performed by the user (type ActionEvent)
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setContentPane(new JLabel(new ImageIcon("BoggleBackground.png")));
                        frame.add(mainMenuPanelGUI);
                        mainMenuPanelGUI.setVisible(true);
                        frame.remove(home2);
                        frame.revalidate();
                    }
                });
            }

        });
        gameSettings.addActionListener(new ActionListener() {
            /**
             * Displays the settings menu when respective button is pressed
             *
             * LIST OF LOCAL VARIABLES
             * warn stores whether each settings parameter is valid (type boolean[])
             *
             * @param e the action performed by the user (type ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuPanelGUI.setVisible(false);
                frame.setContentPane(new JLabel(new ImageIcon("gameSettings.png")));
                frame.add(mainGameSettingsPanelGUI);
                mainGameSettingsPanelGUI.add(home);
                mainGameSettingsPanelGUI.setVisible(true);


                frame.remove(mainMenuPanelGUI);
                frame.revalidate();
                boolean[] warn = {false, false, false, false, false};
                minimumLength.getDocument().addDocumentListener(new DocumentListener() {
                    //runs update() when user changes the JTextField
                    public void changedUpdate(DocumentEvent e) {
                        update();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        update();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        update();
                    }
                    /**
                     * Void method warns user of invalid setting parameters if necessary
                     *
                     * LIST OF LOCAL VARIABLES
                     * length   the user query for the minimum length for a word to be considered valid in each game (type Integer)
                     */
                    public void update() {
                        try {
                            int length = Integer.parseInt(minimumLength.getText());
                            warning.setText("Please keep the minimum length of the words as 2-5.");
                            if (length >= 2 && length <= 5){
                                minimumLengthWarn.setVisible(false);
                                warn[0] = false;
                            }
                            else {
                                minimumLengthWarn.setVisible(true);
                                warn[0] = true;
                            }
                        } catch (Exception e) {
                            warning.setText("Invalid input! Please enter a number!");
                            minimumLengthWarn.setVisible(true);
                            warn[0] = true;
                        }
                    }
                });
                onePTime.getDocument().addDocumentListener(new DocumentListener() {
                    //runs update() when user changes the JTextField
                    public void changedUpdate(DocumentEvent e) {
                        update();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        update();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        update();
                    }
                    /**
                     * Void method warns user of invalid setting parameters if necessary
                     *
                     * LIST OF LOCAL VARIABLES
                     * length   the user query for amount of time for a single player game (type int)
                     */
                    public void update() {
                        try {
                            int length = Integer.parseInt(onePTime.getText());
                            timeWarning.setText("Please keep the time between 15-300 seconds.");
                            if (length >= 15 && length <= 300) {
                                onePTimeWarn.setVisible(false);
                                warn[1] = false;
                            }
                            else {
                                onePTimeWarn.setVisible(true);
                                warn[1] = true;
                            }
                        } catch (Exception e) {
                            timeWarning.setText("Invalid input! Please enter a number!");
                            onePTimeWarn.setVisible(true);
                            warn[1] = true;
                        }
                    }
                });
                twoPTime.getDocument().addDocumentListener(new DocumentListener() {
                    //runs update() when user changes the JTextField
                    public void changedUpdate(DocumentEvent e) {
                        update();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        update();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        update();
                    }
                    /**
                     * Void method warns user of invalid setting parameters if necessary
                     *
                     * LIST OF LOCAL VARIABLES
                     * length   the user query for amount of time for a multiplayer/PvC game (type int)
                     */
                    public void update() {
                        try {
                            int length = Integer.parseInt(twoPTime.getText());
                            timeWarning2.setText("Please keep the time between 5-120 seconds.");
                            if (length >= 5 && length <= 120) {
                                twoPTimeWarn.setVisible(false);
                                warn[2] = false;
                            }
                            else{
                                twoPTimeWarn.setVisible(true);
                                warn[2] = true;
                            }
                        } catch (Exception e) {
                            timeWarning2.setText("Invalid input! Please enter a number!");
                            twoPTimeWarn.setVisible(true);
                            warn[2] = true;
                        }
                    }
                });
                maxPoints.getDocument().addDocumentListener(new DocumentListener() {
                    //runs update() when user changes the JTextField
                    public void changedUpdate(DocumentEvent e) {
                        update();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        update();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        update();
                    }
                    /**
                     * Void method warns user of invalid setting parameters if necessary
                     *
                     * LIST OF LOCAL VARIABLES
                     * length   the user query for the minimum score required for a player to win a PvP/PvC game (type int)
                     */
                    public void update() {
                        try {
                            int length = Integer.parseInt(maxPoints.getText());
                            maxPointsWarning.setText("Please keep the maximum points between 10-100.");
                            if (length >= 10 && length <= 100) {
                                maxPointsWarn.setVisible(false);
                                warn[3] = false;
                            }
                            else{
                                maxPointsWarn.setVisible(true);
                                warn[3] = true;
                            }
                        } catch (Exception e) {
                            maxPointsWarning.setText("Invalid input! Please enter a number!");
                            maxPointsWarn.setVisible(true);
                            warn[3] = true;
                        }
                    }
                });
                difficultyLevel.getDocument().addDocumentListener(new DocumentListener() {
                    //runs update() when user changes the JTextField
                    public void changedUpdate(DocumentEvent e) {
                        update();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        update();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        update();
                    }
                    /**
                     * Void method warns user of invalid setting parameters if necessary
                     *
                     * LIST OF LOCAL VARIABLES
                     * length   the user query for the difficulty level of AI (type int)
                     */
                    public void update() {
                        try {
                            int length = Integer.parseInt(difficultyLevel.getText());
                            difficultyLevelWarning.setText("Please enter these numbers: 1-Easy, 2-Medium, 3-Hard");
                            if (length >= 1 && length <= 3) {
                                difficultyLevelWarn.setVisible(false);
                                warn[4] = false;
                            }
                            else{
                                difficultyLevelWarn.setVisible(true);
                                warn[4] = true;
                            }
                        } catch (Exception e) {
                            difficultyLevelWarning.setText("Invalid input! Please enter a number!");
                            difficultyLevelWarn.setVisible(true);
                            warn[4] = true;
                        }
                    }
                });
                home.addActionListener(new ActionListener() {
                    /**
                     * Void method that displays the main menu screen as long as settings menu has valid parameters
                     *
                     * LIST OF LOCAL VARIABLES
                     * canReturn stores whether all setting parameters are valid (type boolean[])
                     *
                     * @param e the action performed by the user (type ActionEvent)
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean canReturn = true;
                        for (int i = 0; i < 5; i++) {
                            if(warn[i]){
                                canReturn = false;
                            }
                        }
                        if(canReturn){
                            timePerTurn = Integer.parseInt(twoPTime.getText());
                            mainGameSettingsPanelGUI.setVisible(false);
                            frame.remove(mainGameSettingsPanelGUI);
                            frame.setContentPane(new JLabel(new ImageIcon("BoggleBackground.png")));
                            frame.add(mainMenuPanelGUI);
                            mainMenuPanelGUI.setVisible(true);
                            frame.revalidate();
                        }
                    }
                });
            }
        });

        frame.setVisible(true); //make frame visible
    }
    /**
     * Void method formats the necessary user input and background logic for a singleplayer game
     * resets all necessary gui components and adds respective action & document listeners for a single player game
     */
    public static void playGameSingle(){
        guessedWords.clear(); //clear out data from any previous games
        guessWordS.setBackground(Color.WHITE);
        guessWordS.setEnabled(true);
        guessWordS.requestFocus();
        guessWordS.setText("");
        currentWord.setText("");
        if(singlePlayerInit) { //if action and document listeners weren't already added
            guessWordS.getDocument().addDocumentListener(new DocumentListener() {
                //these 3 methods run each time the user updates the JTextField
                public void changedUpdate(DocumentEvent e) {
                    update();
                }
                public void removeUpdate(DocumentEvent e) {
                    update();
                }
                public void insertUpdate(DocumentEvent e) {
                    update();
                }
                /**
                 * Void method displays the current word entered by the user as well as the validity of the query
                 *
                 * LIST OF LOCAL VARIABLES
                 * val  Value of the current user query (type String)
                 */
                public void update() {
                    String val = guessWordS.getText().toUpperCase();
                    if(val.length() > 27){
                        val = val.substring(0, 26) + "...";
                    }
                    if(boardLogic.ans.contains(val) && !guessedWords.contains(val)){ //valid word
                        currentWord.setForeground(Color.GREEN);
                    }
                    else if(guessedWords.contains(val)){ //word already guessed
                        currentWord.setForeground(Color.YELLOW);
                    }
                    else{ //invalid word
                        currentWord.setForeground(Color.RED);
                    }
                    currentWord.setText(val);
                    currentWordPanel.add(currentWord);
                }
            });
            guessWordS.addActionListener(new ActionListener() { //new ActionListener for the guessWordS JTextField
                /**
                 * Void method updates the score and user data when a query is entered
                 *
                 * LIST OF LOCAL VARIABLES
                 * input  Value of the current user query (type String)
                 *
                 * @param e the action performed by the user (type ActionEvent)
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = guessWordS.getText().toUpperCase();
                    if(!guessedWords.contains(input) && boardLogic.ans.contains(input)){ //valid word and not already guessed
                        scoreCount += input.length(); //update score count
                        wordsCount += 1;
                        score.setText("SCORE: " + scoreCount);
                        words.setText("WORDS: " + wordsCount);
                        guessedWords.add(input);
                        boardLogic.ans.remove(input);
                    }
                    guessWordS.setText(""); //empty the textfield so the user does not have to delete the word themself
                }
            });
            singlePlayerInit = false;
        }
    }
    /**
     * Void method formats the necessary user input and background logic for a multiplayer/pvc game
     * resets all necessary gui components and adds respective action & document listeners
     *
     * @param turn      stores which player is currently going (type boolean [])
     * @param pCountX   stores the number of penalties each player currently has (type int [])
     */
    public static void playGameMulti(boolean[] turn, int[] pCountX){
        guessedWords2.clear(); //clear out old user data
        guessedWords.clear();
        playerOneX1.setForeground(Color.WHITE);
        playerOneX2.setForeground(Color.WHITE);
        playerOneX3.setForeground(Color.WHITE);
        playerTwoX1.setForeground(Color.WHITE);
        playerTwoX2.setForeground(Color.WHITE);
        playerTwoX3.setForeground(Color.WHITE);
        guessWordP1.setText("");
        currentWord.setText("");
        if(multiPlayerInit[0]) { //if action/document listeners haven't been added
            guessWordP1.getDocument().addDocumentListener(new DocumentListener() {
                //these 3 methods run each time the user updates the JTextField
                public void changedUpdate(DocumentEvent e) {
                    update();
                }
                public void removeUpdate(DocumentEvent e) {
                    update();
                }
                public void insertUpdate(DocumentEvent e) {
                    update();
                }
                /**
                 * Void method displays the current word entered by the user as well as the validity of the query
                 *
                 * LIST OF LOCAL VARIABLES
                 * val  Value of the current user query (type String)
                 */
                public void update() {
                    String val = guessWordP1.getText().toUpperCase();
                    if (val.length() > 27) {
                        val = val.substring(0, 26) + "...";
                    }
                    if (boardLogic.ans.contains(val) && !guessedWords.contains(val) && !guessedWords2.contains(val)) { //valid word
                        currentWord.setForeground(Color.GREEN);
                    } else if (guessedWords.contains(val) || guessedWords2.contains(val)) { //word already guessed
                        currentWord.setForeground(Color.YELLOW);
                    } else { //invalid word
                        currentWord.setForeground(Color.RED);
                    }
                    currentWord.setText(val);
                    currentWordPanel.add(currentWord);
                }
            });
            guessWordP1.addActionListener(new ActionListener() { //new ActionListener for the guessWordP1 JTextField
                /**
                 * Void method updates the score and user data when a query is entered
                 * Also changes the turn to the next user
                 *
                 * LIST OF LOCAL VARIABLES
                 * input  Value of the current user query (type String)
                 *
                 * @param e the action performed by the user (type ActionEvent)
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = guessWordP1.getText().toUpperCase();
                    if (!guessedWords.contains(input) && !guessedWords2.contains(input) && boardLogic.ans.contains(input)) {
                        guessWordP1.setEnabled(false); //locks current user's input
                        guessWordP1.setBackground(Color.GRAY);

                        scoreCount += input.length(); //updates user score
                        wordsCount += 1;
                        score.setText("SCORE: " + scoreCount);
                        words.setText("WORDS: " + wordsCount);
                        guessedWords.add(input);
                        boardLogic.ans.remove(input);
                        gameTimer.cancel();

                        if (scoreCount >= Integer.parseInt(maxPoints.getText())) { //runs end game screen
                            winner = true;
                            pvpDelay();
                        }
                        else { //unlocks other user input for their turn
                            guessWordP2.setEnabled(true);
                            guessWordP2.setBackground(Color.WHITE);
                            guessWordP2.requestFocus();
                            turn[0] = false;
                            time.setVisible(false);
                            runMultiPlayerTimer(turn, pCountX);
                        }
                    }
                    guessWordP1.setText(""); //empty the textfield so the user does not have to delete the word themself
                }
            });
            multiPlayerInit[0] = false;
        }
        if(multiPlayerInit[1]) {
            guessWordP2.getDocument().addDocumentListener(new DocumentListener() {
                //these 3 methods run each time the user updates the JTextField
                public void changedUpdate(DocumentEvent e) {
                    update();
                }
                public void removeUpdate(DocumentEvent e) {
                    update();
                }
                public void insertUpdate(DocumentEvent e) {
                    update();
                }
                /**
                 * Void method displays the current word entered by the user as well as the validity of the query
                 *
                 * LIST OF LOCAL VARIABLES
                 * val  Value of the current user query (type String)
                 */
                public void update() {
                    String val = guessWordP2.getText().toUpperCase();
                    if (val.length() > 27) {
                        val = val.substring(0, 26) + "...";
                    }
                    if (boardLogic.ans.contains(val) && !guessedWords.contains(val) && !guessedWords2.contains(val)) {
                        currentWord.setForeground(Color.GREEN);
                    } else if (guessedWords.contains(val) || guessedWords2.contains(val)) {
                        currentWord.setForeground(Color.YELLOW);
                    } else {
                        currentWord.setForeground(Color.RED);
                    }
                    currentWord.setText(val);
                    currentWordPanel.add(currentWord);
                }
            });
            guessWordP2.addActionListener(new ActionListener() { //new ActionListener for the guessWord JTextField
                /**
                 * Void method updates the score and user data when a query is entered
                 * Also changes the turn to the next user
                 *
                 * LIST OF LOCAL VARIABLES
                 * input  Value of the current user query (type String)
                 *
                 * @param e the action performed by the user (type ActionEvent)
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = guessWordP2.getText().toUpperCase();
                    if (!guessedWords.contains(input) && !guessedWords2.contains(input) && boardLogic.ans.contains(input)) {
                        guessWordP2.setEnabled(false);
                        guessWordP2.setBackground(Color.GRAY);

                        scoreCount2 += input.length();
                        wordsCount2 += 1;
                        score2.setText("SCORE: " + scoreCount2);
                        words2.setText("WORDS: " + wordsCount2);
                        guessedWords2.add(input);
                        boardLogic.ans.remove(input);
                        gameTimer.cancel();

                        if(scoreCount2 >= Integer.parseInt(maxPoints.getText())){
                            winner = false;
                            pvpDelay();
                        }
                        else{
                            turn[0] = true;
                            time2.setVisible(false);
                            guessWordP1.setEnabled(true);
                            guessWordP1.setBackground(Color.WHITE);
                            guessWordP1.requestFocus();
                            runMultiPlayerTimer(turn, pCountX);
                        }
                    }
                    guessWordP2.setText(""); //empty the textfield so the user does not have to delete the word themself
                }
            });
            multiPlayerInit[1] = false;
        }
    }
    /**
     * Void method formats the necessary user input and background logic for a multiplayer/pvc game
     * resets all necessary gui components and adds respective action & document listeners
     *
     * @param ai        Used to create RNG'd guesses based on difficulty (type AI())
     * @param pCountX   stores the number of penalties the player currently has (type int [])
     */
    public static void playGameComp(int[] pCountX, AI ai){
        guessedWords2.clear();
        guessedWords.clear();
        guessWordC.setBackground(Color.GRAY);
        guessWordC.setEnabled(false);

        guessWordCP1.setBackground(Color.WHITE);
        guessWordCP1.setEnabled(true);
        guessWordCP1.requestFocus();

        guessWordCP1.setText("");
        guessWordC.setText("");
        currentWord.setText("");

        playerOneX1.setForeground(Color.WHITE);
        playerOneX2.setForeground(Color.WHITE);
        playerOneX3.setForeground(Color.WHITE);
        if(pvcInit) {
            guessWordCP1.getDocument().addDocumentListener(new DocumentListener() {
                //these 3 methods run each time the user updates the JTextField
                public void changedUpdate(DocumentEvent e) {
                    update();
                }
                public void removeUpdate(DocumentEvent e) {
                    update();
                }
                public void insertUpdate(DocumentEvent e) {
                    update();
                }
                /**
                 * Void method displays the current word entered by the user as well as the validity of the query
                 *
                 * LIST OF LOCAL VARIABLES
                 * val  Value of the current user query (type String)
                 */
                public void update() {
                    String val = guessWordCP1.getText().toUpperCase();
                    if(val.length() > 27){
                        val = val.substring(0, 26) + "...";
                    }
                    if(boardLogic.ans.contains(val) && !guessedWords.contains(val) && !guessedWords2.contains(val)){
                        currentWord.setForeground(Color.GREEN);
                    }
                    else if(guessedWords.contains(val) || guessedWords2.contains(val)){
                        currentWord.setForeground(Color.YELLOW);
                    }
                    else{
                        currentWord.setForeground(Color.RED);
                    }
                    currentWord.setText(val);
                    currentWordPanel.add(currentWord);
                }
            });
            guessWordCP1.addActionListener(new ActionListener() { //new ActionListener for the guessWord JTextField
                /**
                 * Void method updates the score and user data when a query is entered
                 * Also changes the turn to the computer
                 *
                 * LIST OF LOCAL VARIABLES
                 * input  Value of the current user query (type String)
                 *
                 * @param e the action performed by the user (type ActionEvent)
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = guessWordCP1.getText().toUpperCase();
                    if(!guessedWords.contains(input) && boardLogic.ans.contains(input)){
                        guessWordCP1.setEnabled(false);
                        guessWordCP1.setBackground(Color.GRAY);

                        scoreCount += input.length();
                        wordsCount += 1;
                        score.setText("SCORE: " + scoreCount);
                        words.setText("WORDS: " + wordsCount);
                        guessedWords.add(input);
                        boardLogic.ans.remove(input);

                        if (scoreCount >= Integer.parseInt(maxPoints.getText())) {
                            winner = true;
                            pvcDelay();
                        }
                        else{
                            int interval = Integer.parseInt(twoPTime.getText());
                            runPvCTimer(interval, pCountX, ai);
                            aiChoice(interval, pCountX, ai);
                        }
                    }
                    guessWordCP1.setText(""); //empty the textfield so the user does not have to delete the word themself
                }
            });
            pvcInit = false;
        }
    }
    /**
     * Void method starts the timer for a single player game. Also runs appropriate methods when timer finishes
     *
     * LIST OF LOCAL VARIABLES
     * timeLeft             The amount of loops remaining for the timer task (type int)
     * timeLeftString       The amount of time left in the current game (type String)
     *
     * @param interval the length that the timer runs (type int)
     */
    static void runSinglePlayerTimer(int interval) {
        try{ //purges old timer if there is one
            gameTimer.cancel();
        } catch (NullPointerException n) {}
        gameTimer = new Timer(); //creates a new timer
        gameTimer.scheduleAtFixedRate(new TimerTask() { //loop until no time left
            int timeLeft = interval;
            String timeLeftString = "" + timeLeft;
            /**
             * Void method that runs for the duration of the timer. Reduces the amount of time left every second and
             * displays countdown to user. Runs end screen code once timer is complete
             */
            public void run() {
                time.setText(timeLeftString + "s");
                timeLeft--;
                timeLeftString = "" + timeLeft;
                if(timeLeft == 0){ //no time left
                    gameTimer.cancel(); //terminate task
                    singleplayerEnd();
                }
            }
        }, 0, 1000); //tasks repeat ever 1000 milliseconds without initial delay
    }
    /**
     * Void method starts the timer for a multiplayer game. Also runs appropriate methods when timer finishes
     *
     * LIST OF LOCAL VARIABLES
     * timeLeft             The amount of loops remaining for the timer task (type int)
     * timeLeftString       The amount of time left in the current game (type String)
     *
     * @param turn      Stores which player is currently entering words in the game (type boolean[])
     * @param pCountX   Stores the amount of penalties each player has (type int[])
     */
    static void runMultiPlayerTimer(boolean[] turn, int[] pCountX) {
        try{ //purges old timer if there is one
            gameTimer.cancel();
        } catch (NullPointerException n) {}
        if(turn[0]){ //player 1's turn, lock player 2's input and start player 1's timer
            guessWordP1.setEnabled(true);
            guessWordP1.setBackground(Color.WHITE);
            guessWordP2.setEnabled(false);
            guessWordP2.setBackground(Color.GRAY);
            time2.setVisible(false);
            time.setVisible(true);
            gameTimer = new Timer();
            gameTimer.scheduleAtFixedRate(new TimerTask() { //run every second
                int timeLeft = timePerTurn;
                String timeLeftString = "" + timeLeft;
                /**
                 * Void method that runs for the duration of the timer. Reduces the amount of time left every second and
                 * displays countdown to user. Switches players turn or runs end screen once time runs out
                 */
                public void run() {
                    time.setText(timeLeftString + "s");
                    timeLeft--;
                    timeLeftString = "" + timeLeft;
                    if(timeLeft == -1){ //ran out of time
                        guessWordP1.setEnabled(false); //disable player 1's input
                        guessWordP1.setBackground(Color.GRAY);
                        time.setVisible(false);
                        turn[0] = false;

                        pCountX[0] += 1; //add a penalty and color appropriate "x" red
                        if(pCountX[0] == 1) playerOneX1.setForeground(Color.RED);
                        if(pCountX[0] == 2) playerOneX2.setForeground(Color.RED);
                        if(pCountX[0] == 3) { //Run game over when 3 penalties is reached
                            playerOneX3.setForeground(Color.RED);
                            winner = false;
                            pvpDelay();
                        }
                        else{ //switch turn to player 2 if the game isn't over
                            guessWordP1.setText("");
                            guessWordP2.setEnabled(true);
                            guessWordP2.setBackground(Color.WHITE);
                            guessWordP2.requestFocus();
                            runMultiPlayerTimer(turn, pCountX);
                        }
                    }
                }
            }, 0, 1000); //tasks repeat ever 1000 milliseconds with no initial delay
        }
        else{
            guessWordP1.setEnabled(false);
            guessWordP1.setBackground(Color.GRAY);
            guessWordP2.setEnabled(true);
            guessWordP2.setBackground(Color.WHITE);
            time.setVisible(false);
            time2.setVisible(true);
            gameTimer = new Timer();
            gameTimer.scheduleAtFixedRate(new TimerTask() { //run every second
                int timeLeft = timePerTurn;
                String timeLeftString = "" + timeLeft;
                /**
                 * Void method that runs for the duration of the timer. Reduces the amount of time left every second and
                 * displays countdown to user. Switches players turn or runs end screen once time runs out
                 */
                public void run() {
                    time2.setText(timeLeftString + "s");
                    timeLeft--;
                    timeLeftString = "" + timeLeft;
                    if(timeLeft == -1){ //ran out of time
                        guessWordP2.setEnabled(false); //disable player 2's input
                        guessWordP2.setBackground(Color.GRAY);
                        time2.setVisible(false);
                        turn[0] = true;

                        pCountX[1] += 1; //add a penalty and color appropriate "x" red
                        if(pCountX[1] == 1) playerTwoX1.setForeground(Color.RED);
                        if(pCountX[1] == 2) playerTwoX2.setForeground(Color.RED);
                        if(pCountX[1] == 3) { //Run game over when 3 penalties is reached
                            playerTwoX3.setForeground(Color.RED);
                            winner = true;
                            pvpDelay();
                        }
                        else{ //switch turn to player 1 if the game isn't over
                            guessWordP2.setText("");
                            guessWordP1.setEnabled(true);
                            guessWordP1.setBackground(Color.WHITE);
                            guessWordP1.requestFocus();
                            runMultiPlayerTimer(turn, pCountX);
                        }
                    }
                }
            }, 0, 1000); //tasks repeat ever 1000 milliseconds with no initial delay
        }
    }
    /**
     * Void method starts the timer for a PvC game. Also runs appropriate methods when timer finishes
     *
     * LIST OF LOCAL VARIABLES
     * timeLeft             The amount of loops remaining for the timer task (type int)
     * timeLeftString       The amount of time left in the current game (type String)
     *
     * @param interval the length that the timer runs (type int)
     * @param pCountX stores the number of penalties the player currently has (type int [])
     * @param ai RNG'd guesses weighted on difficulty (type AI())
     */
    static void runPvCTimer(int interval, int[] pCountX, AI ai) {
        try{ //purges old timer if there is one
            gameTimer.cancel();
        } catch (NullPointerException n) {}
        gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() { //run every second
            int timeLeft = interval;
            String timeLeftString = "" + timeLeft;
            /**
             * Void method that runs for the duration of the timer. Reduces the amount of time left every second and
             * displays countdown to user. Runs end screen code once timer is complete
             */
            public void run() {
                time.setText(timeLeftString + "s");
                timeLeft--;
                timeLeftString = "" + timeLeft;
                if(timeLeft == -1){ //ran out of time
                    guessWordCP1.setEnabled(false); //disabled player's input
                    guessWordCP1.setBackground(Color.GRAY);

                    pCountX[0] += 1; //add a penalty and color appropriate "x" red
                    if(pCountX[0] == 1) playerOneX1.setForeground(Color.RED);
                    if(pCountX[0] == 2) playerOneX2.setForeground(Color.RED);
                    if(pCountX[0] == 3) { //Run game over when 3 penalties is reached
                        playerOneX3.setForeground(Color.RED);
                        winner = false;
                        pvcDelay();
                    }
                    else{ //ai's turn
                        aiChoice(interval, pCountX, ai);
                    }
                }
            }
        }, 0, 1000); //tasks repeat ever 1000 milliseconds with no initial delay
    }
    /**
     * void method calls the AI to make a guess; displays guess and calculates score for ai
     *
     * LIST OF LOCAL VARIABLES
     * delay    Amount of delay in seconds before the AI guesses a word (type int)
     *
     * @param interval  The amount of loops remaining for the PvC timer task (type int)
     * @param pCountX   Amount of penalties the player has (type int [])
     * @param ai        Generates RNG'd guesses based off of the difficulty (type ai())
     */
    public static void aiChoice(int interval, int[] pCountX, AI ai){
        try{ //purges old timer if there is one
            gameTimer.cancel();
        } catch (NullPointerException n) {}
        gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            int delay = 2;
            /**
             * void method that adds some delay before the AI makes a guess
             *
             * LIST OF LOCAL VARIABLES
             * AIguess  A RNG'd guess based off of the difficulty (type String)
             */
            public void run(){
                delay--;
                if(delay == 0) {
                    String AIguess = ai.guess();
                    guessWordC.setText(AIguess);
                    scoreCount2 += AIguess.length();
                    wordsCount2 += 1;
                    score2.setText("SCORE: " + scoreCount2);
                    words2.setText("WORDS: " + wordsCount2);
                    guessedWords2.add(AIguess);
                    if (scoreCount2 >= Integer.parseInt(maxPoints.getText())) { //AI won, run end game screen
                        winner = false;
                        pvcDelay();
                    }
                    else{ //set turn to player 1
                        guessWordCP1.setEnabled(true);
                        guessWordCP1.setBackground(Color.WHITE);
                        guessWordCP1.requestFocus();
                        runPvCTimer(interval, pCountX, ai);
                    }
                }
            }//run every second
        }, 0, 1000); //tasks repeat ever 1000 milliseconds with no initial delay
    }
    /**
     * void method adds a slight delay before the game over screen is shown. Used to not cut off user mid-input during a
     * multiplayer game
     *
     * LIST OF LOCAL VARIABLES
     * delay    amount of delay before end screen in seconds (type int)
     */
    public static void pvpDelay(){
        guessWordP1.setEnabled(false); //locks all input
        guessWordP2.setEnabled(false);
        try{ //purges old timer if there is one
            gameTimer.cancel();
        } catch (NullPointerException n) {}
        gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            int delay = 2;
            /**
             * void method executes the delay and displays end screen afterwards
             */
            public void run(){
                delay--;
                if(delay == 0) {
                    multiplayerEnd(3, false); //display end game screen
                }
            }//run every second
        }, 0, 1000); //tasks repeat ever 1000 milliseconds with no initial delay
    }
    /**
     * void method adds a slight delay before the game over screen is shown. Used to not cut off user mid-input during a
     * PvC game
     *
     * LIST OF LOCAL VARIABLES
     * delay    amount of delay before end screen in seconds (type int)
     */
    public static void pvcDelay(){
        guessWordCP1.setEnabled(false);
        try{ //purges old timer if there is one
            gameTimer.cancel();
        } catch (NullPointerException n) {}
        gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            int delay = 2;
            /**
             * void method executes the delay and displays end screen afterwards
             */
            public void run(){
                delay--;
                if(delay == 0) {
                    multiplayerEnd(3,true);
                }
            }//run every second
        }, 0, 1000); //tasks repeat ever 1000 milliseconds with no initial delay
    }
    /**
     * void method used to format the single player end screen and adds it to the frame
     *
     * LIST OF LOCAl VARIABLES
     * endGamePanel         Panel upon which all end game menu components are displayed (type JPanel)
     * title                Main title of the game over screen (type JLabel)
     * topWordsPanel        Panel containing the longest words each player guessed (type JPanel)
     * text                 Contains all the top words of each player properly formatted to be displayed (type StringBuilder)
     * topWords             Contains the longest words each player guessed (type JPanel)
     * endGameButtonsPanel  Panel holding the play again and quit game buttons (type JPanel)
     * playAgain            Button that starts another game when pressed (type JButton)
     * quitGame             Button that terminates the program when pressed (type JButton)
     */
    public static void singleplayerEnd() {
        gameTimer.cancel();
        frame.remove(mainGamePanelSoloGUI);
        frame.setContentPane(new JLabel(new ImageIcon("gameoverSingleplayer.png")));

        JPanel endGamePanel = new JPanel(new BorderLayout()); //initialize and format panel
        endGamePanel.setBorder(BorderFactory.createEmptyBorder(130, 0, 0, 0));
        endGamePanel.setSize(800, 510);
        endGamePanel.setOpaque(false);

        JLabel title = new JLabel("YOUR GAME HIGHLIGHTS:"); //initialize and format label
        title.setFont(new Font("Museo", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);
        endGamePanel.add(title, BorderLayout.NORTH);

        JPanel topWordsPanel = new JPanel(); //initialize and format label
        topWordsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        topWordsPanel.setOpaque(false);
        //sort array based on longest -> smallest words (if length is tied its sorted using alphabetical order)
        Collections.sort(guessedWords, Collections.reverseOrder(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())));

        StringBuilder text =new StringBuilder();
        for(int i = 0; i < Math.min(7, guessedWords.size()); i++) { //get the largest words and add format them using html
            text.append(guessedWords.get(i));
            text.append("<br>");
        }
        text.insert(0, "<html><div style='text-align: center;'>"); //centers text on JPanel
        if(guessedWords.size() > 7) {
            text.append("<br> AND " + (guessedWords.size() - 7) + " MORE!");
        } else if (guessedWords.size() == 0) {
            text.append("no words were guessed :(");
        }
        text.append("</div></html>");
        JLabel topWords = new JLabel(text.toString()); //initialize and format label
        topWords.setFont(new Font("Museo", Font.BOLD, 20));
        topWords.setForeground(Color.white);
        topWordsPanel.add(topWords);
        endGamePanel.add(topWordsPanel, BorderLayout.CENTER);

        JPanel endButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 250, 0)); //initialize and format panel
        endButtonsPanel.setOpaque(false);
        JButton playAgain = new JButton("Play Again");
        JButton quitGame = new JButton("Quit Game");
        playAgain.setFocusable(false);
        quitGame.setFocusable(false);
        endButtonsPanel.add(playAgain);
        endButtonsPanel.add(quitGame);
        endGamePanel.add(endButtonsPanel, BorderLayout.SOUTH);

        frame.add(endGamePanel);
        frame.revalidate();
        frame.repaint();

        playAgain.addActionListener(new ActionListener() {
            /**
             * void method formats necessary panels and components to restart the a game with the same game mode
             *
             * @param e the action performed by the user (type ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    newGame();
                    declareBoggleBoardGUI();
                    guessedWords.clear();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                endGamePanel.removeAll();
                frame.remove(endGamePanel);
                frame.setContentPane(new JLabel(new ImageIcon("singleplayer.png")));
                mainGamePanelSoloGUI.setVisible(true);

                mainGamePanelSoloGUI.add(tablePanel);
                userPanel.remove(guessWordP1);
                userPanel.remove(guessWordCP1);
                userPanel.add(guessWordS);
                mainGamePanelSoloGUI.add(userPanel);
                mainGamePanelSoloGUI.add(scoreBoardPanel);
                mainGamePanelSoloGUI.add(gameButtonPanel);
                mainGamePanelSoloGUI.add(currentWordPanel);
                mainGamePanelSoloGUI.add(timerPanel);
                mainGamePanelSoloGUI.add(soloLabelPanel);
                mainGamePanelSoloGUI.add(home);

                mainGamePanelSoloGUI.add(timerPanel);
                mainGamePanelSoloGUI.add(home);
                frame.add(mainGamePanelSoloGUI);

                scoreCount = 0;
                wordsCount = 0;
                score.setText("SCORE: " + scoreCount);
                words.setText("WORDS: " + wordsCount);
                runSinglePlayerTimer(Integer.parseInt(onePTime.getText()));
                playGameSingle();
            }
        });
        quitGame.addActionListener(new ActionListener() {
            /**
             * void method terminates the program when it's respective button is pressed
             * @param e the action performed by the user (type ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        });
    }
    /**
     * void method used to format the single player end screen and adds it to the frame
     *
     * LIST OF LOCAl VARIABLES
     * endGamePanel         Panel upon which all end game menu components are displayed (type JPanel)
     * title                Main title of the game over screen (type JLabel)
     * topWordsPanel        Panel containing the longest words both player guessed (type JPanel)
     * text                 Contains all the top words of each player properly formatted to be displayed (type StringBuilder)
     * player1Results       Panel containing the longest words player 1 guessed (type JPanel)
     * player2Results       Panel containing the longest words player 2 guessed (type JPanel)
     * topWords             Contains the longest words each player guessed (type JPanel)
     * endGameButtonsPanel  Panel holding the play again and quit game buttons (type JPanel)
     * playAgain            Button that starts another game when pressed (type JButton)
     * quitGame             Button that terminates the program when pressed (type JButton)
     *
     * @param isComputer stores whether the current end screen is used for PVC or multiplayer (type boolean)
     * @param topDisplay stores how many words to display for each user (type int)
     */
    public static void multiplayerEnd(int topDisplay, boolean isComputer){
        gameTimer.cancel();
        frame.remove(mainGamePanelMultiGUI);
        frame.remove(mainGamePanelCompGUI);
        frame.setContentPane(new JLabel(new ImageIcon("gameoverSingleplayer.png")));
        Collections.sort(guessedWords, Collections.reverseOrder(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())));
        Collections.sort(guessedWords2, Collections.reverseOrder(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())));

        JPanel endGamePanel = new JPanel(new BorderLayout());
        endGamePanel.setBorder(BorderFactory.createEmptyBorder(130, 0, 0, 0));
        endGamePanel.setSize(800, 510); //h = 562 is the bottom reaches the bottom of the frame
        endGamePanel.setOpaque(false);

        JLabel title = new JLabel("YOUR GAME HIGHLIGHTS:");
        title.setFont(new Font("Museo", Font.BOLD, 26));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);
        endGamePanel.add(title, BorderLayout.NORTH);

        JPanel topWordsPanel = new JPanel(new GridLayout(2, 1));
        topWordsPanel.setOpaque(false);
        topWordsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JPanel player1Results = new JPanel();
        player1Results.setOpaque(false);

        StringBuilder text =new StringBuilder("------PLAYER 1------<br>");
        for(int i = 0; i < Math.min(topDisplay, guessedWords.size()); i++) {
            text.append(guessedWords.get(i));
            text.append("<br>");
        }
        text.insert(0, "<html><div style='text-align: center;'>");
        if(guessedWords.size() > topDisplay) {
            text.append("AND " + (guessedWords.size() - topDisplay) + " MORE!");
        } else if (guessedWords.size() == 0) {
            text.append("no words guessed");
        }
        text.append("</div></html>");
        JLabel topWords1 = new JLabel(text.toString());
        topWords1.setFont(new Font("Museo", Font.BOLD, 20));
        if(winner){
            topWords1.setForeground(new Color(255,215,0));
        }
        else{
            topWords1.setForeground(new Color(192,192,192));
        }
        player1Results.add(topWords1);

        JPanel player2Results = new JPanel();
        player2Results.setOpaque(false);

        text =new StringBuilder((!isComputer) ? "------PLAYER 2------<br>" : "------COMPUTER------<br>");
        for(int i = 0; i < Math.min(topDisplay, guessedWords2.size()); i++) {
            text.append(guessedWords2.get(i));
            text.append("<br>");
        }
        text.insert(0, "<html><div style='text-align: center;'>");
        if(guessedWords2.size() > topDisplay) {
            text.append("AND " + (guessedWords2.size() - topDisplay) + " MORE!");
        } else if (guessedWords2.size() == 0) {
            text.append("no words guessed");
        }
        text.append("</div></html>");
        JLabel topWords2 = new JLabel(text.toString());
        topWords2.setFont(new Font("Museo", Font.BOLD, 20));
        if(!winner){
            topWords2.setForeground(new Color(255,215,0));
        }
        else{
            topWords2.setForeground(new Color(192,192,192));
        }
        player2Results.add(topWords2);

        topWordsPanel.add(player1Results);
        topWordsPanel.add(player2Results);
        endGamePanel.add(topWordsPanel, BorderLayout.CENTER);

        JPanel endButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 250, 0));
        endButtonsPanel.setOpaque(false);
        JButton playAgain = new JButton("Play Again");
        JButton quitGame = new JButton("Quit Game");
        playAgain.setFocusable(false);
        quitGame.setFocusable(false);
        endButtonsPanel.add(playAgain);
        endButtonsPanel.add(quitGame);
        endGamePanel.add(endButtonsPanel, BorderLayout.SOUTH);

        frame.add(endGamePanel);
        frame.revalidate();
        frame.repaint();

        playAgain.addActionListener(new ActionListener() {
            /**
             * void method formats necessary panels and components to restart the a game with the same game mode
             *
             * LIST OF LOCAL VARIABLES
             * AI       RNG'd guesses weighted using difficultly (type ai())
             * pCountX  Number of penalties each player has (type int [])
             * turn     Stores which player is currently going in the game (type boolean [])
             *
             * @param e the action performed by the user (type ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isComputer){
                    try {
                        newGame();
                        declareBoggleBoardGUI();
                        guessedWords.clear();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    endGamePanel.removeAll();
                    frame.remove(endGamePanel);
                    frame.setContentPane(new JLabel(new ImageIcon("computer.png")));
                    mainGamePanelCompGUI.setVisible(true);
                    mainGamePanelCompGUI.add(home);

                    mainGamePanelCompGUI.add(tablePanel);
                    userPanel.remove(guessWordP1);
                    userPanel.add(guessWordCP1);
                    userPanel.remove(guessWordS);
                    mainGamePanelCompGUI.add(userPanel);
                    mainGamePanelCompGUI.add(scoreBoardPanel);
                    mainGamePanelCompGUI.add(gameButtonPanel3);
                    mainGamePanelCompGUI.add(currentWordPanel);
                    mainGamePanelCompGUI.add(timerPanel);
                    mainGamePanelCompGUI.add(player1);
                    mainGamePanelCompGUI.add(scoreBoardPanel2);
                    userPanel2.remove(guessWordP2);
                    userPanel2.add(guessWordC);
                    mainGamePanelCompGUI.add(userPanel2);
                    mainGamePanelCompGUI.add(computerLabelPanel);

                    frame.add(mainGamePanelCompGUI);

                    scoreCount = 0;
                    wordsCount = 0;
                    score.setText("SCORE: " + scoreCount);
                    words.setText("WORDS: " + wordsCount);

                    scoreCount2 = 0;
                    wordsCount2 = 0;
                    score2.setText("SCORE: " + scoreCount2);
                    words2.setText("WORDS: " + wordsCount2);

                    AI AI = new AI(boardLogic.ans, Integer.parseInt(difficultyLevel.getText()));
                    int[] pCountX = {0};
                    runPvCTimer(Integer.parseInt(twoPTime.getText()), pCountX, AI);
                    playGameComp(pCountX, AI);
                }
                else{
                    try {
                        newGame();
                        declareBoggleBoardGUI();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    endGamePanel.removeAll();
                    frame.remove(endGamePanel);
                    frame.setContentPane(new JLabel(new ImageIcon("pvp.png")));
                    mainGamePanelMultiGUI.setVisible(true);
                    mainGamePanelMultiGUI.add(home);

                    mainGamePanelMultiGUI.add(tablePanel);
                    userPanel.add(guessWordP1);
                    userPanel.remove(guessWordCP1);
                    userPanel.remove(guessWordS);
                    mainGamePanelMultiGUI.add(userPanel);
                    mainGamePanelMultiGUI.add(scoreBoardPanel);
                    mainGamePanelMultiGUI.add(gameButtonPanel2);
                    mainGamePanelMultiGUI.add(currentWordPanel);
                    mainGamePanelMultiGUI.add(timerPanel);
                    mainGamePanelMultiGUI.add(player1);
                    mainGamePanelMultiGUI.add(scoreBoardPanel2);
                    mainGamePanelMultiGUI.add(timerPanel2);
                    userPanel2.add(guessWordP2);
                    userPanel2.remove(guessWordC);
                    mainGamePanelMultiGUI.add(userPanel2);
                    mainGamePanelMultiGUI.add(player2);

                    frame.add(mainGamePanelMultiGUI);

                    scoreCount = 0;
                    wordsCount = 0;
                    score.setText("SCORE: " + scoreCount);
                    words.setText("WORDS: " + wordsCount);

                    scoreCount2 = 0;
                    wordsCount2 = 0;
                    score2.setText("SCORE: " + scoreCount2);
                    words2.setText("WORDS: " + wordsCount2);

                    frame.revalidate();
                    final boolean[] turn = {true};
                    int[] pCountX = {0,0};
                    runMultiPlayerTimer(turn, pCountX);
                    playGameMulti(turn, pCountX);
                }
            }
        });
        quitGame.addActionListener(new ActionListener() {
            /**
             * void method terminates the program when it's respective button is pressed
             * @param e the action performed by the user (type ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Thanks for playing!"); // user friendly output
                System.exit(0); //end the code
            }
        });
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Loading...");
        newGame();
        declarePanels();
    }
}