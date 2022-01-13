/*=====================================================
BOGGLE GAME
Nicholas Lin & Wilbur Zhang
May 12 2021
Java 1.8.0

TrieNode class represents all prefixes stored in the Trie. Each node contains 2 components explained below

LIST OF LOCAL VARIABLES:
children    list of all words that begin with the current prefix (type HashMap<Character, TrieNode>)
isWord      Stores whether the current prefix is also a complete word
=====================================================*/

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;

    /**
     * Constructor method of TrieNode class
     * initializes parameters and assumes current node is not a complete word
     */
    public TrieNode () {
        children = new HashMap <> ();
        isWord = false;
    }
}