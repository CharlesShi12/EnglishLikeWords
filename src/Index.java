public class Index {
    // runs and tests the whole project
    public static String[] runTest(int segmentLength, int wordTests) {
        EnglishWords g = new EnglishWords(segmentLength);
        long start = System.currentTimeMillis();
        g.train(Dictionary.getWords());
        long stop = System.currentTimeMillis();
        System.out.println("Loaded " + g.getSampleCount() + " samples in " + (stop - start) + "ms.");

        String[] words = new String[wordTests];
        start = System.currentTimeMillis();
        for (int i = 0; i < words.length; i++) {
            words[i] = g.generate();
        }
        stop = System.currentTimeMillis();
        System.out.println("Generated " + words.length + " words in Loaded in " + (stop - start) + "ms.");
        return words;
    }
    // prints out useful information about the tests
    public static void printSome(String[] words, int length) {
        System.out.println("Here's a few words:");
        for (int i = 0; i < length; i++) {
            System.out.println(" * "+words[i]);
        }
    }
    // runs the tests
    public static void main(String[] args) {
        printSome(runTest(4, 2000), 20);
    }
}
