/*=====================================================
BOGGLE GAME
Nicholas Lin & Wilbur Zhang
May 12 2021
Java 1.8.0

Class contains two numbers that represents a coordinate pair

LIST OF LOCAL VARIABLES
r   A row index (type int)
c   A column index (type int)
=====================================================*/
public class Coordinate {
    int r, c;
    /**
     * Constructor method of boggleBoard class
     * used to initialize
     * @param r the number of rows of the board
     * @param c the number of columns of the board
     */
    public Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
