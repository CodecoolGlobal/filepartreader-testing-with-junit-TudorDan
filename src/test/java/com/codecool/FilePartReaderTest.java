package com.codecool;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}