package fr.yvann.WordAI.assistant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;

@Configuration
public class AssistantConfiguration {

    @Bean
    public ChatLanguageModel chatLanguageModel() {
        return OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3.2")
                .build();
    }

    @Bean(name = "aiAssistant")
    public Assistant assistant(ChatLanguageModel chatLanguageModel, AssistantTools assistantTools) {
        return AiServices.builder(Assistant.class)
                .chatLanguageModel(chatLanguageModel)
                .tools(assistantTools)
                .build();
    }
}
