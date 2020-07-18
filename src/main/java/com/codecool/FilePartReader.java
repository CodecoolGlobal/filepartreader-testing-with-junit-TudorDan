package com.codecool;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine) {
            throw new IllegalArgumentException("fromLine greater than toLine");
        }
        if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine smaller than 1");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        // read file content
        StringBuilder fileContent = new StringBuilder();

        //get file path
        Path file = Paths.get(filePath).toRealPath();

        //read file content
        BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.US_ASCII);
        String line;
        while ((line = reader.readLine()) != null) {
            fileContent.append(line).append("\n");
        }
        fileContent.deleteCharAt(fileContent.length() - 1); //delete last new line

        return fileContent.toString();
    }

    public String readLines() throws IOException {
        String text = read();
        String[] lines = text.split("\n");
        StringBuilder result = new StringBuilder();

        int lineNr = toLine;
        if (toLine > lines.length) {
            lineNr = lines.length;
        }

        for (int i = fromLine - 1; i < lineNr; i++) {
            result.append(lines[i]).append("\n");
        }
        result.deleteCharAt(result.length() - 1);  //delete last new line

        return  result.toString();
    }
}
