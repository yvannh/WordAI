package fr.yvann.WordAI.controller;

import fr.yvann.WordAI.assistant.Assistant;
import fr.yvann.WordAI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final Assistant assistant;

    @Autowired
    public UserController(UserService userService, @Qualifier("aiAssistant") Assistant assistant) {
        this.userService = userService;
        this.assistant = assistant;
    }

    @GetMapping("/chat")
    public String chat(@RequestBody String userMessage) {
        return assistant.answer(userMessage);
    }

    /*
    // Créer un nouvel utilisateur
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Obtenir tous les utilisateurs
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Obtenir un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ajouter un mot à l'utilisateur
    @PostMapping("/{userId}/words")
    public ResponseEntity<User> addWordToUser(@PathVariable String userId, @RequestBody Word word) {
        User updatedUser = userService.addWordToUser(userId, word.getWord(), word.getTranslation());
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    // Mettre à jour un mot de l'utilisateur
    @PutMapping("/{userId}/words/{word}")
    public ResponseEntity<User> updateWordForUser(@PathVariable String userId, @PathVariable String word, @RequestParam boolean learnt) {
        User updatedUser = userService.updateWordForUser(userId, word, learnt);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    */
}
