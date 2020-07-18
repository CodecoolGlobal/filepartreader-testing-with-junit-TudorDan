import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader filePartReader = new FilePartReader();

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String fileText = filePartReader.readLines();
        String[] words = fileText.split("\\b");
        Arrays.sort(words);
        return new ArrayList<>(Arrays.asList(words));
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        String fileText = filePartReader.readLines();
        String[] words = fileText.split("\\b");
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.contains(subString)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean isPalindrome(String word) {
        String reverse = new StringBuilder(word).reverse().toString();
        return word.equals(reverse);
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        String fileText = filePartReader.readLines();
        String[] words = fileText.split("\\b");
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (isPalindrome(word)) {
                result.add(word);
            }
        }
        return result;
    }
}