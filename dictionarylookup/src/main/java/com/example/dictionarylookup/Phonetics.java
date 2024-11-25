package com.example.dictionarylookup;

public class Phonetics {
    private String text; // Phonetic transcription of the word
    private String audio; // URL to an audio file for pronunciation

    // Getter for the phonetic text
    public String getText() {
        return text;
    }

    // Setter for the phonetic text
    public void setText(String text) {
        this.text = text;
    }

    // Getter for the audio URL
    public String getAudio() {
        return audio;
    }

    // Setter for the audio URL
    public void setAudio(String audio) {
        this.audio = audio;
    }

    @Override
    public String toString() {
        return "Phonetics{" +
                "text='" + text + '\'' +
                ", audio='" + audio + '\'' +
                '}';
    }
}
