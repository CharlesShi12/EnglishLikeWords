import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    /**
     * Get the words stored in words.txt Generally you should put the words.txt file in the proejct folder, but NOT in the src folder.
     * @return
     */
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
        //Testing Dictionary Class
        String[] words = getWords();
        System.out.println(words.length);
        for (int i = 0; i < words.length; i += words.length/15) {
            System.out.println("\"" + words[i] + "\"");
        }
    }
}
