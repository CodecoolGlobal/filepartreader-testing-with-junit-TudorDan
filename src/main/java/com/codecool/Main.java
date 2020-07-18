package com.codecool;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        String path = "src/main/resources/test";

        filePartReader.setup(path, 5, 6);

        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        List<String> words = fileWordAnalyzer.getWordsContainingSubstring("e");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("----------------------------------------------------");
        List<String> palindromes = fileWordAnalyzer.getStringsWhichPalindromes();
        for(String palindrome : palindromes) {
            System.out.println(palindrome);
        }
    }
}
