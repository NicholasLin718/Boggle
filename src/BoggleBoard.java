/*=====================================================
BOGGLE GAME
Nicholas Lin & Wilbur Zhang
May 12 2021
Java 1.8.0

Class contains all the backend logic for generating and solving boggle boards

LIST OF GLOBAL VARIABLES
R       Number of rows on boggle board (type int)
C       Number of columns on boggle board (type int)
moves   Stores all possible directions where adj dice are possible (verticals, horizontals & diagonals) as coordinate pairs (type direction())
dice    Stores the 6 faces of every (type String [])
dict    List of all valid words stored in Trie (type Trie())
board   Current board state (type String [][])
ans     List of all valid words on the board (type ArrayList<String>)
=====================================================*/
import java.io.FileNotFoundException;
import java.util.*;

public class BoggleBoard {
    private static int R, C, minLength;
    private static Coordinate[] moves = new Coordinate[8];
    private static String[] dice = {"AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM",
            "AEEGMU", "AEGMNN", "AFIRSY", "BJKQXZ", "CCNSTW",
            "CEIILT", "CEILPT", "CEIPST", "DDLNOR", "DHHLOR",
            "DHHNOT", "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU",
            "FIPRSY", "GORRVW", "HIPRRY", "NOOTUW", "OOOTTU"};
    private static Trie dict;
    static String[][] board;
    static ArrayList<String> ans = new ArrayList<String>();
    /**
     * Constructor method of BoggleBoard class
     * Creates a board with the given dimensions and solves for all valid words
     *
     * @param r Rows needed for board (type int)
     * @param c Columns needed for board (type int)
     * @throws FileNotFoundException if wordlist.txt can't be found
     */
    public BoggleBoard(int r, int c, int m) throws FileNotFoundException {
        R = r;
        C = c;
        minLength = m;
        dict = new Trie();
        board = new String[R][C];
        generateDir();
        generateBoard();
        solve();
        trim();
    }
    /**
     * Generates all the directions as coordinate pairs
     * and stores them into moves array
     *
     * LIST OF LOCAL VARIABLES
     * index    index of where the next directions should be stored in moves array (type int)
     */
    private void generateDir() {
        int index = 0;
        for(int i = -1; i < 2; i++) //all row directions
            for(int j = -1; j < 2; j++) //all column directions
                if(i != 0 || j != 0) moves[index++] = new Coordinate(i, j); //adds direction as long as its not 0, 0 (which results in no movement)
    }
    /**
     * Generates a new random board state when called
     *
     * LIST OF LOCAL VARIABLES
     * diceList     All 25 dices and their respective faces (type ArrayList <String>)
     * rand         Random number generator (type Random())
     * diceIndex    Index of a random dice from the remaining list of die (type int)
     * charIndex    Index of a random side of said dice (type int)
     */
    private static void generateBoard() {
        ArrayList<String> diceList = new ArrayList<String>(Arrays.asList(dice));
        Random rand = new Random();
        for (int i = 0; i < R; i++) { //for each row of the board
            for (int j = 0; j < C; j++) { //for each column of the board
                int diceIndex = rand.nextInt(diceList.size()); //get random dice from the remaining list of dice
                int charIndex = rand.nextInt(dice[0].length()); //get random face of dice
                board[i][j] = diceList.get(diceIndex).substring(charIndex, charIndex + 1); //assign value to the position on the board
                diceList.remove(diceIndex); //dice was used so it's removed from the list
            }
        }
    }
    /**
     * Finds all valid words for the current board arrangement
     * Uses a modified DFS algorithm for efficiency (further documentation below)
     *
     * LIST OF LOCAL VARIABLES
     * q        Queue of triplet objects that need to be visited (type LinkedList)
     * vis      Keeps track of all used dice (type boolean[][])
     * curr     Current triplet object being visited
     * newR     Row index of a neighboring dice
     * newC     Column index of a neighboring dice
     * newPre   New string formed using current prefix + an adjacent dice
     * newVis   The new state of the visited array to be passed into the queue
     **/
    private static void solve () {
        LinkedList<Triplet> q = new LinkedList<Triplet>();
        for (int r = 0; r < R; r++) { //initialize a DFS starting from every dice
            for (int c = 0; c < C; c++) {
                boolean[][] vis = new boolean[R][C];
                vis[r][c] = true; //mark starting dice as visited
                q.add(new Triplet(r, c, board[r][c], vis)); //pass triplet object into queue
            }
        }
        while (!q.isEmpty()) {
            Triplet curr = q.pop(); //dequeue a triplet object (contains current dice, the array of visited dice, and the prefix formed so far)
            for (Coordinate dir : moves) { //search in every direction for an unused adjacent dice
                int newR = curr.coords.r + dir.r, newC = curr.coords.c + dir.c; //coordinates of neighboring dice
                if (newR >= 0 && newR < R && newC >= 0 && newC < C && !curr.vis[newR][newC]) { //check if neighbor is valid (not OOB and not already used)
                    String newPre = curr.prefix + board[newR][newC]; //Create a new prefix that additionally includes neighbor dice value
                    if (dict.searchPrefix(newPre.toLowerCase())) { //if the string formed is a valid prefix to any word
                        boolean[][] newVis = new boolean[R][C]; //create a copy of the visited array
                        for (int r = 0; r < R; r++) newVis[r] = curr.vis[r].clone();
                        newVis[newR][newC] = true; //mark current dice as visited
                        q.add(new Triplet(newR, newC, newPre, newVis)); //add triplet to the queue
                        if (dict.search(newPre.toLowerCase()) && !ans.contains(newPre)) { //if the string formed is also a word itself (that hasn't already been found)
                            ans.add(newPre); //add string to the list of valid words
                        }
                    }
                }
            }
        }
    }
    private static void trim () {
        while(ans.get(0).length() < minLength)
            ans.remove(0);
    }
}