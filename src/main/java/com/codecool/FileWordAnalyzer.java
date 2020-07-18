package com.codecool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    private final FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String fileText = filePartReader.readLines();
        String[] words = fileText.split("\\W+");
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        wordsList.sort(String.CASE_INSENSITIVE_ORDER);
        return wordsList;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        String fileText = filePartReader.readLines();
        String[] words = fileText.split("\\W+");
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().contains(subString.toLowerCase())) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean isPalindrome(String word) {
        String reverse = new StringBuilder(word).reverse().toString().toLowerCase();
        return word.toLowerCase().equals(reverse);
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        String fileText = filePartReader.readLines();
        String[] words = fileText.split("\\W+");
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (isPalindrome(word)) {
                result.add(word);
            }
        }
        return result;
    }
}
