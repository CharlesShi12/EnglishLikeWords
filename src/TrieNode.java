/**
 * a class that represents a TrieNode which is a node in the Trie class
 */
public class TrieNode<T>{
    private T data;
    private TrieNode<T>[] children;

    /**
     * a constructor that generates a TrieNode
     */
    public TrieNode(){
        this.data = null;
        this.children = new TrieNode [26];
    }

    /**
     * a method that returns the private T data variable of the TrieNode
     */
    public T getData(){
        return this.data;
    }

    /**
     * a method that sets the private T data of the TrieNode to the inputted T data parameter
     */
    public void setData(T data){
        this.data = data;
    }

    /**
     * a method which will return the TrieNode in accordance with the inputted character
     */
    public TrieNode<T> getChild(char letter){
        int index;
        if(!(Character.isLowerCase(letter))) {
            return null;
        }
        int ascii = letter;
        index = (ascii - 97);
        if(children[index] == null){
            TrieNode<T> node = new TrieNode<>();
            children[index] = node;
            return children[index];
        }
        return children[index];
    }

    /**
     * a method which calculates and returns the total occurrences of all the non-null
     * nodes in the tree as an integer
     */
    public int getTreeSize() {
        int length = 0;
        for(int i = 0; i < 26; i++) {
            if (!(children[i] == null)) {
                length += children[i].getTreeSize();
            }
        }
        length++;
        return length;
    }
}
