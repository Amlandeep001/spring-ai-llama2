package com.spring.ai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ai.service.LlamaAiService;

@RestController
public class AIController
{
    private final LlamaAiService aiService;

    public AIController(LlamaAiService aiService)
    {
        this.aiService = aiService;
    }

    @GetMapping("/api/v1/generate")
    public String generate(@RequestParam String promptMessage)
    {
        return aiService.generateResult(promptMessage);
    }
}
