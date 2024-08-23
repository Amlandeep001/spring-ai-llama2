package com.spring.ai.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LlamaAiService
{
    private final OllamaChatModel chatModel;
    private final String ollamaModel;

    public LlamaAiService(OllamaChatModel chatModel, @Value("${spring.ai.ollama.model}") String ollamaModel)
    {
        this.chatModel = chatModel;
        this.ollamaModel = ollamaModel;
    }

    public String generateResult(String prompt)
    {
        ChatResponse response = chatModel.call(
                new Prompt(
                        prompt,
                        OllamaOptions.create()
                                .withModel(ollamaModel)
                ));
        return response.getResult().getOutput().getContent();
    }
}
