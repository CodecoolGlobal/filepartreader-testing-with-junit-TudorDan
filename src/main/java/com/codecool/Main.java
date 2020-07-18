package com.codecool;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        String path = "src/main/resources/test";

        filePartReader.setup(path, 1, 1);
        System.out.println(filePartReader.readLines());
    }
}
