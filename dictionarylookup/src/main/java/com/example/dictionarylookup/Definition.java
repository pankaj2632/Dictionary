package com.example.dictionarylookup;

public class Definition {
    private String definition; // The definition of the word
    private String example;    // An example sentence using the word

    // Getter for the definition
    public String getDefinition() {
        return definition;
    }

    // Setter for the definition
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    // Getter for the example
    public String getExample() {
        return example;
    }

    // Setter for the example
    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "Definition{" +
                "definition='" + definition + '\'' +
                ", example='" + example + '\'' +
                '}';
    }
}
