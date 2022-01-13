/*=====================================================
BOGGLE GAME
Nicholas Lin & Wilbur Zhang
May 12 2021
Java 1.8.0

Triplet class used by the DFS to solve the current board state
Refer to solve() in BoggleBoard for more details

LIST OF LOCAL VARIABLES:
coords  The current row and column being visited (type Coordinate())
prefix  The prefix formed using all previously visited dice (type String)
vis     Stores all visited dice (type boolean[][])
=====================================================*/

public class Triplet {
    Coordinate coords;
    String prefix;
    boolean [][] vis;
    /**
     * Constructor method for Triplet class
     * Assigns appropriate values
     * @param r         current row
     * @param c         current column
     * @param prefix    current prefix formed
     * @param vis       current state of visited array
     */
    public Triplet(int r, int c, String prefix, boolean [][] vis) {
        coords = new Coordinate(r, c);
        this.prefix = prefix;
        this.vis = vis;
    }
}
