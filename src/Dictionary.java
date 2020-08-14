import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    // gets the words stored in words.txt
    public static String[] getWords() {
        Scanner scan = null;
        try {
            scan = new Scanner(new FileInputStream("words.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<String> words = new ArrayList<>();
        while(scan.hasNext()) {
            words.add(scan.next());
        }

        return words.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // testing Dictionary class
        String[] words = getWords();
        System.out.println(words.length);
        for (int i = 0; i < words.length; i += words.length/15) {
            System.out.println("\"" + words[i] + "\"");
        }
    }
}
