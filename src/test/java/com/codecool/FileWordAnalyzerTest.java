package com.codecool;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private FileWordAnalyzer fileWordAnalyzer;
    static String path;

    @BeforeAll
    static void initPath() {
        path = "src/main/resources/test";
    }

    @BeforeEach
    public void initFilePathReader() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(path, 5, 6);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    public void testGetWordsOrderedAlphabeticallyCallsFilePartReaderReadLines() throws IOException {
        assertNotNull(fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testGetWordsOrderedAlphabeticallyReturnsCorrectValue() throws IOException {
        List<String> correctValue = Arrays.asList("Anna", "is", "Kayak", "murder", "Racecar", "Red", "Rotator", "rum"
                , "sir");
        assertEquals(correctValue, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testGetWordsContainingSubstringCallsFilePartReaderReadLines() throws IOException {
        assertNotNull(fileWordAnalyzer.getWordsContainingSubstring("e"));
    }

    @Test
    public void testGetWordsContainingSubstringReturnsCorrectValue() throws IOException {
        List<String> correctValue = Arrays.asList("Racecar", "Red", "murder");
        assertEquals(correctValue, fileWordAnalyzer.getWordsContainingSubstring("e"));
    }

    @Test
    public void testGetStringsWhichPalindromesCallsFilePartReaderReadLines() throws IOException {
        assertNotNull(fileWordAnalyzer.getStringsWhichPalindromes());
    }

    @Test
    public void testGetStringsWhichPalindromesReturnsCorrectValue() throws IOException {
        List<String> correctValue = Arrays.asList("Anna", "Rotator", "Racecar", "Kayak");
        assertEquals(correctValue, fileWordAnalyzer.getStringsWhichPalindromes());
    }
}