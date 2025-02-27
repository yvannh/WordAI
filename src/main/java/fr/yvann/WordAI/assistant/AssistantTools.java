package fr.yvann.WordAI.assistant;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.langchain4j.agent.tool.Tool;
import fr.yvann.WordAI.model.User;
import fr.yvann.WordAI.service.UserService;

@Component
public class AssistantTools {
    
    private final UserService userService;

    @Autowired
    public AssistantTools(UserService userService) {
        this.userService = userService;
    }

    @Tool
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Tool
    public Optional<User> getUserById(String userId) {
        return userService.getUserById(userId);
    }
}
