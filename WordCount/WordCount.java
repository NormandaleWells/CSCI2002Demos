import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordCount {

    private static String cleanString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c))
                sb.append(c);
            else if (Character.isUpperCase(c))
                sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fs = new FileInputStream("tale.txt");
        Scanner fileScanner = new Scanner(fs);
        HashSet<String> uniqueWords = new HashSet<String>();
        HashMap<String,Integer> wordCounts = new HashMap<String,Integer>();
        int totalWords = 0;
        while (fileScanner.hasNext()) {
            String s = fileScanner.next();
            s = cleanString(s);
            if (s.length() > 0) {
                uniqueWords.add(s);
                if (wordCounts.containsKey(s)) {
                    wordCounts.put(s, wordCounts.get(s) + 1);
                } else {
                    wordCounts.put(s, 1);
                }
                totalWords += 1;
            }
        }
        fileScanner.close();

        System.out.printf("There were %d words in the file, "
                + "of which %d were unique.\n",
                totalWords, uniqueWords.size());

        // for (String s : wordCounts.keySet()) {
        //     int count = wordCounts.get(s);
        //     System.out.printf("%s occured %d times.\n", s, count);
        // }

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            if (wordCounts.containsKey(s)) {
                System.out.printf("%s occurs %d times.\n", s, wordCounts.get(s));
            } else {
                System.out.printf("%s does not occur in the text.\n", s);
            }
        }
        sc.close();
    }
}
