/*=====================================================
BOGGLE GAME
Nicholas Lin & Wilbur Zhang
May 12 2021
Java 1.8.0

Trie class is a classic implementation of the Trie data structure

LIST OF LOCAL VARIABLES:
root    the root node of the trie (type TrieNode())
=====================================================*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trie {
    TrieNode root = new TrieNode();
    /**
     * Constructor method of BoggleBoard class
     * Reads in every word from the wordlist and inserts it into the trie
     *
     * LIST OF LOCAL VARIABLES
     * f        File object pointing to the wordlist (type File())
     * input    Used to read in every word in wordlist (type Scanner())
     * @throws FileNotFoundException if wordlist.txt cannot be found
     */
    public Trie() throws FileNotFoundException {
        File f = new File("wordlist.txt");
        Scanner input = new Scanner(f);
        while(input.hasNext()){
            insert(root, input.nextLine(), 0);
        }
    }
    /**
     * Method used to insert a word into the trie
     *
     * LIST OF LOCAL VARIABLES
     * currChar current character of the query being inserted
     * child    neighboring node representing the current character being searched
     *
     * @param curr  the current node being traversed (type TrieNode())
     * @param val   the value of the query (type String)
     * @param index the index of the current character of the query being inserted (type int)
     */
    private void insert(TrieNode curr, String val, int index) {
        //reached the end of the word
        if(index == val.length()) {
            curr.isWord = true;
            return;
        }
        //get get child node
        char currChar = val.charAt(index);
        TrieNode child = curr.children.get(currChar);
        //if the node does not exist, create an entry
        if(child == null) {
            child = new TrieNode();
            curr.children.put(currChar, child);
        }
        //look for the corresponding node at the next index
        insert(child, val, index + 1);
    }
    /**
     * Method is used to call the recursive search method
     * @param val query being searched (type string)
     * @return whether the query exists in the tree or not (type boolean)
     */
    public boolean search(String val) {
        return search(root, val, 0);
    }

    /**
     * Method used to determine if a query exists inside of the Trie
     *
     * LIST OF LOCAL VARIABLES
     * currChar Current character of the query being inserted
     * child    Neighboring node representing the current character being searched
     *
     * @param curr  the current node being traversed (type TrieNode())
     * @param val   the value of the query (type String)
     * @param index the index of the current character of the query being searched (type int)
     * @return whether the query exists in the tree or not (type boolean)
     */
     private boolean search(TrieNode curr, String val, int index) {
        if(index == val.length()) {
            //if curr.isWord is false, that means val is just a prefix of another word
            return curr.isWord;
        }
        //get child node
        char currChar = val.charAt(index);
        TrieNode child = curr.children.get(currChar);
        //if the node doesn't exist, word is invalid
        if(child == null) {
            return false;
        }
        //look for the corresponding node at the next index
        return search(child, val, index + 1);
    }

    /**
     * Method used to determine if a query is a prefix of a word
     *
     * LIST OF LOCAL VARIABLES
     * curr Current node being traversed
     * next Neighboring node representing the current character being searched
     *
     * @param val   query being searched (type String)
     * @return whether the query is a prefix or not (type boolean)
     */
    public Boolean searchPrefix(String val) {
        //initialize curr node
        TrieNode curr = root;
        for (int i = 0; i < val.length(); i++){ //loop through every character of the query
            TrieNode child = curr.children.get(val.charAt(i)); //get child node
            if (child == null) { //if the node doesn't exist, word is invalid
                return false;
            }
            curr = child; //update curr node
        }
        return true; //if no null children were encountered, the query was either a valid prefix or a full valid word (which also counts as a prefix)
    }
}
