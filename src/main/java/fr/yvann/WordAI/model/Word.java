package fr.yvann.WordAI.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "words")
public class Word {
    private String word;
    private String translation;
    private LocalDateTime lastAsked;
    private boolean learnt;

    public Word(String word, String translation) {
        this.word = word;
        this.translation = translation;
        this.lastAsked = null;
        this.learnt = false;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }

    public LocalDateTime getLastAsked() {
        return lastAsked;
    }

    public boolean isLearnt() {
        return learnt;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public void setLastAsked(LocalDateTime lastAsked) {
        this.lastAsked = lastAsked;
    }

    public void setLearnt(boolean learnt) {
        this.learnt = learnt;
    }
}