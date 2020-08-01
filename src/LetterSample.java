/**
 * a class that generates letter samples provided there are valid private String segment
 * and private char nextLetter
 */
public class LetterSample {
    private String segment;
    private char nextLetter;
    public static final char STOP = '.';

    /**
     * a constructor which takes in any single string and single char and creates a LetterSample Object
     * @param segment a string which represents the private String segment in LetterSample
     * @param nextLetter a char which represents the private char nextLetter in LetterSample
     */
    public LetterSample(String segment, char nextLetter) {
        this.segment = segment;
        this.nextLetter = nextLetter;
    }

    /**
     * a method that returns a String whose content represents the private String segment variable
     * in the LetterSample class
     */
    public String getSegment() {
        return this.segment;
    }

    /**
     * a method that returns a char whose content represents the private char nextLetter variable
     * in the LetterSample class
     */
    public char getNextLetter() {
        return this.nextLetter;
    }

    /**
     * a method that returns a string that is in a certain format outlining the private variables
     * (private String segment and private char nextLetter) in the LetterSample class
     */
    public String toString() {
        return ("\"" + this.segment + "\"" + " -> " + this.nextLetter);
    }

    /**
     * a method that creates and returns an array of letter samples based on a String input and int segmentSize
     * and terminates once it reaches the private static char STOP variable
     * @param input a string that our letter samples will be generated and based off of
     * @param segmentSize an int that represents the maximum possible size of each letter sample
     */
    public static LetterSample[] toSamples(String input, int segmentSize) {
        String modified = "";
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))) {
                modified += input.charAt(i);
            }
        }
        modified += STOP;
        LetterSample[] output = new LetterSample[modified.length()];
        for (int j = 0; j < modified.length(); j++) {
            if(j <= segmentSize){
                LetterSample ls = new LetterSample(modified.substring(0, j), modified.charAt(j));
                output[j] = ls;
            }else{
                LetterSample ls = new LetterSample(modified.substring(j - segmentSize, j), modified.charAt(j));
                output[j] = ls;
            }
        }
        return output;
    }
}