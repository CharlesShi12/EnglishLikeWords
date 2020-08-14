/**
 * a class that combines LetterSample, CharBag, TrieNode, and Trie to generate random English words
 * that are pronounceable
 */
public class EnglishWords {
    private Trie<CharBag> model;
    private int segmentLength;
    private int processed;

    /**
     * a constructor that generates the Gibberisher object according to the inputted segmentLength
     */
    public EnglishWords(int segmentLength){
        this.segmentLength = segmentLength;
        this.model = new Trie<CharBag>();
        this.processed = 0;
    }

    /**
     * a method that will add the given LetterSample input to the private Trie<CharBag> model in Gibberisher
     */
    public void train(LetterSample input){
        if (this.model.get(input.getSegment()) == null){
            CharBag c = new CharBag();
            c.add(input.getNextLetter());
            this.model.put(input.getSegment(), c);
        }else{
            this.model.get(input.getSegment()).add(input.getNextLetter());
        }
        this.processed++;
    }

    /**
     * a method that will make a corresponding LetterSample to the given String input, the LetterSample will then be
     * used by the public void train(LetterSample input) method to add the given LetterSample to private Trie<CharBag> model
     * allowing us to ultimately add the String input to the private Trie<CharBag> model
     */
    public void train(String input){
        LetterSample[] sample = LetterSample.toSamples(input, this.segmentLength);
        for(int i = 0; i < sample.length; i++){
            train(sample[i]);
        }
    }

    /**
     * a method that will perform the public void train(String input) method for every String element in the inputted,
     * ultimately adding the given String[] input to the private Trie<CharBag> model through the other train methods
     */
    public void train(String[] input){
        for(int i = 0; i < input.length; i++){
            train(input[i]);
        }
    }

    /**
     * a method that will return the number of times a sample has been processed to the model
     */
    public int getSampleCount(){
        return this.processed;
    }

    /**
     * a method that generates a random String which represents an English word that is pronounceable
     */
    public String generate(){
        String word = "";
        while(word.length() == 0|| word.charAt(word.length() - 1) != LetterSample.STOP){
            String sample = "";
            if(word.length() <= segmentLength){
                sample = word;
            }else{
                sample = word.substring(word.length() - segmentLength);
            }
            word += model.get(sample).getRandomChar();
        }
        return word.substring(0, word.length() - 1);
    }
}
