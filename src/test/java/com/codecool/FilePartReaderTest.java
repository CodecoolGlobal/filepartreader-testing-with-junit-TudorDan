package com.codecool;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private FilePartReader filePartReader;
    static String path;

    @BeforeAll
    static void initPath() {
        path = "src/main/resources/test";
    }

    @BeforeEach
    public void initFilePathReader() {
        filePartReader = new FilePartReader();
    }

    @Test
    public void testSetupHasParameters() {
        filePartReader.setup(path, 1, 1);
        assertAll("parameters",
                () -> assertNotNull(filePartReader.getFilePath()),
                () -> assertNotNull(filePartReader.getFromLine()),
                () -> assertNotNull(filePartReader.getToLine()));
    }

    @Test
    public void testToLineIsSmallerThanFromLine() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(path, 2, 1));
    }

    @Test
    public void testFromLineIsSmallerThan1() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(path, 0, 1));
    }

    @Test
    public void testReadReturnsFileContent() throws IOException {
        filePartReader.setup(path, 1, 1);
        assertNotNull(filePartReader.read());
    }

    @Test
    public void testFileNotInFilePathThrowsException() {
        String wrongPath = "src/main/resources/noFile";
        filePartReader.setup(wrongPath, 1, 1);
        assertThrows(IOException.class, () -> filePartReader.read());
    }

    @Test
    public void testReadLinesReadsFileWithRead() throws IOException {
        filePartReader.setup(path, 1, 1);
        assertNotNull(filePartReader.readLines());
    }

    @Test
    public void testReadReturnsCorrectValue() throws IOException {
        String correctValue = "With death being the only certainty of life, life is just a bit too short for regrets" +
                "." + "\n" + "In all chaotic beauty lies a wounded work of art." + "\n" + "Beautiful but torn, " +
                "wreaking havoc on my heart." + "\n" + "Camouflaged by insecurities, blinded by it all." + "\n" +
                "Anna, Rotator, Racecar, Kayak." + "\n" + "Red rum, sir, is murder.";
        filePartReader.setup(path, 1, 1);
        assertEquals(correctValue, filePartReader.read());
    }

    @Test
    public void testReadLinesReturnsCorrectValue() throws IOException {
        String correctValue = "Beautiful but torn, wreaking havoc on my heart." + "\n" + "Camouflaged by " +
                "insecurities, blinded by it all.";
        filePartReader.setup(path, 3, 4);
        assertEquals(correctValue, filePartReader.readLines());
    }
}