/**
 * a class that represents a Tree-type data structure with individual nodes as TrieNode objects
 */
public class Trie<T> {
    private TrieNode<T> root;

    /**
     * a constructor which generates a Trie
     */
    public Trie(){
        this.root = new TrieNode<>();
    }

    /**
     * a method that returns the corresponding TrieNode in accordance with the String input
     * @param input this method will return a TrieNode based off of this inputted string
     */
    private TrieNode<T> getNode(String input){
        TrieNode<T> node = root;
        for(int i = 0; i < input.length(); i++){
            node = node.getChild(input.charAt(i));
        }
        return node;
    }

    /**
     * a method that returns the private T data variable in the TrieNode class based on the String input
     * @param input this method will return the private T data variable in the TrieNode based off
     *              of this inputted string
     */
    public T get(String input){
        return getNode(input).getData();
    }

    /**
     * a method that sets the private T data variable in the TrieNode in accordance with the String input
     * @param input a string that is used to locate the private T data variable in the TrieNode
     *              whose content is based off of the String input
     * @param value a T parameter which is used to set the private T data variable in the TrieNode
     *              in accordance with the String input
     */
    public void put(String input, T value){
        getNode(input).setData(value);
    }

    /**
     * a method which returns the TrieNode root which is the root node of the Trie
     */
    public TrieNode<T> getRoot(){
        return this.root;
    }
}
