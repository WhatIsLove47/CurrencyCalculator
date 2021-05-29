package com.calc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class XMLParser {

    private final static String databaseFilename = "database.xml";

    public static HashMap<String, Float> parse() throws IOException {
        BufferedReader reader;
        HashMap<String, Float> cubes = new HashMap<>();
        reader = new BufferedReader(new FileReader(databaseFilename));
        String line = reader.readLine();
        while (line != null) {
            line = line.replaceAll("^\\s+", "");
            if (line.startsWith("<Cube currency")) {
                String[] tokens = line.split("\"");
                cubes.put(tokens[1], Float.parseFloat(tokens[3]));
            }
            line = reader.readLine();
        }
        return cubes;
    }
}
