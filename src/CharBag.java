// a class that generates CharBags
import java.util.Random;
public class CharBag {
    private int[] CharBag = new int[27];
    private int size = 0;

    // a constructor that creates a CharBag with an private int size equal to 0
    public CharBag(){
    }

    // a method that generates and returns an integer index that accurately represents 
    // the inputted character in a certain format (in our case, char a = int 0, char b = int 1, etc.)
    private int generateIndex(char input){
        if (input == LetterSample.STOP){
            return 26;
        } else {
            int ascii = input;
            return (ascii - 'a');
        }
    }

    // a method that adds a character to the CharBag
    public void add(char input){
        input = Character.toLowerCase(input);
        if (!(Character.isAlphabetic(input))) {
            input = LetterSample.STOP;
        }
        CharBag[generateIndex(input)]++;
        size++;
    }

    // a method that removes a character from the CharBag
    public void remove(char input) {
        input = Character.toLowerCase(input);
        if (!(Character.isAlphabetic(input))) {
            input = LetterSample.STOP;
        }
        if (!(CharBag[generateIndex(input)] == 0)){
            CharBag[generateIndex(input)]--;
            size--;
        }
    }

    // a method that finds how many occurrences there are of the inputted character 
    // in the CharBag and returns the total occurrences as an integer
    public int getCount(char input){
        input = Character.toLowerCase(input);
        if (!(Character.isAlphabetic(input))) {
            input = LetterSample.STOP;
        }
        return CharBag[generateIndex(input)];
    }

    // a method that returns the current total size of the CharBag
    public int getSize(){
        return this.size;
    }

    // a method that returns a single String which represents the CharBag in a certain format
    public String toString(){
        String output = "CharBag{";
        for(int i = 0; i < 27; i++){
            if(i == 26){
                output += ".:" + this.CharBag[i] + "}";
            }else {
                char ascii = (char) (i + 'a');
                String letter = Character.toString(ascii);
                output += letter + ":" + this.CharBag[i] + ", ";
            }
        }
        return output;
    }

  
    // a method that generates and returns a random character in accordance with the CharBag, more specifically,
    // this method returns a random character based on how many times that character was in the CharBag compared to
    // all of the other characters
    public char getRandomChar() {
        if (getSize() <= 0){
            return LetterSample.STOP;
        } else {
            Random r = new Random();
            int count = r.nextInt(getSize());
            for (char c = 'a'; c <= 'z'; c++) {
                count -= getCount(c);
                if (count < 0) {
                    return c;
                }
            }
            return LetterSample.STOP;
        }
    }
}
