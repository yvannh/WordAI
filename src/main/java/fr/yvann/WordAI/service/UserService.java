// src/main/java/fr/yvann/WordAI/service/UserService.java
package fr.yvann.WordAI.service;

import fr.yvann.WordAI.model.User;
import fr.yvann.WordAI.model.Word;
import fr.yvann.WordAI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Créer un nouvel utilisateur
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Obtenir tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtenir un utilisateur par ID
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // Ajouter un nouveau mot à l'utilisateur
    public User addWordToUser(String userId, String word, String translation) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Word newWord = new Word(word, translation);
            user.getWords().add(newWord);
            return userRepository.save(user);
        }
        return null; // ou lancer une exception
    }

    // Mettre à jour un mot de l'utilisateur
    public User updateWordForUser(String userId, String word, boolean learnt) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            for (Word w : user.getWords()) {
                if (w.getWord().equals(word)) {
                    w.setLearnt(learnt);
                    return userRepository.save(user);
                }
            }
        }
        return null; // ou lancer une exception
    }
}