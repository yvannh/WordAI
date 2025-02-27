package fr.yvann.WordAI.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private List<Word> words;

    public User(String name, String email, List<Word> words) {
        this.name = name;
        this.email = email;
        this.words = words;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }   

    public void setEmail(String email) {
        this.email = email;
    }   

    public void setWords(List<Word> words) {
        this.words = words;
    }
    
}