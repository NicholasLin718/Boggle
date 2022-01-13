/*=====================================================
BOGGLE GAME
Nicholas Lin & Wilbur Zhang
May 12 2021
Java 1.8.0

AI class is used to generate guesses for the PvC game option

LIST OF LOCAL VARIABLES:
valid       list of all un-guessed valid words remaining for the current board state
difficulty  the difficulty of the ai (1 = easiest, 3 = hardest)
=====================================================*/

import java.util.ArrayList;

public class AI {
    ArrayList<String> valid;
    int difficulty;

    /**
     * Constructor method of the AI class
     * Assigns values to local variables
     * @param ans           the current list of valid words
     * @param difficulty    the current difficulty of AI created
     */
    public AI(ArrayList<String> ans, int difficulty) {
        valid = ans;
        this.difficulty = difficulty;
    }
    /**
     * Returns a randomly chosen character
     * @return
     */
    public String guess () {
        if(valid.size() == 0) return null;
        int mid = valid.size() / 2;
        int sign = (Math.random() >= 0.5 ? 1 : -1);
        if(difficulty == 1) { //Easiest difficulty = randomly choose the shortest words
            return valid.remove(weightedRandom(1, valid.size()) - 1);
        } else if (difficulty == 2) { //Medium difficulty = randomly choose middle-length words
            return valid.remove(mid + (sign * weightedRandom(1, mid)) - 1);
        } else { //Hardest difficulty = randomly choose longest words
            return valid.remove(valid.size() - weightedRandom(1, valid.size()));
        }
    }
    private int weightedRandom (double min, double max) {
        return (int) (Math.round(max / (Math.random() * max + min)));
    }
}