package com.example.dictionarylookup;

import java.util.List;

public class Meaning {
    private String partOfSpeech; // Part of speech for the word
    private List<Definition> definitions; // List of definitions for this part of speech

    // Getter for part of speech
    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    // Setter for part of speech
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    // Getter for definitions
    public List<Definition> getDefinitions() {
        return definitions;
    }

    // Setter for definitions
    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }

    @Override
    public String toString() {
        return "Meaning{" +
                "partOfSpeech='" + partOfSpeech + '\'' +
                ", definitions=" + definitions +
                '}';
    }
}
