package com.example.dictionarylookup;

import java.util.List;

public class Word {
    private String word; // Private field
    private List<Phonetics> phonetics;
    private List<Meaning> meanings;

    // Public getter for the 'word' field
    public String getWord() {
        return word;
    }

    // Public setter for the 'word' field
    public void setWord(String word) {
        this.word = word;
    }

    public List<Phonetics> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }
}
