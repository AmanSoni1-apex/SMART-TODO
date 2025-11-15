package com.todo.smart_todo.analyzer;

import org.springframework.stereotype.Component;

@Component
public class EmotionAiAnalyzer implements EmotionAnalyzer {

    @Override
    public String analyze(String text) {
        if (text == null)
            return "unknown";
        String lower = text.trim().toLowerCase();

        // Exclamation heuristics: often strong feeling
        if (lower.contains("!!") || (lower.contains("!") && lower.length() < 200)) {
            if (lower.contains("not") || lower.contains("never") || lower.contains("hate")) {
                return "angry";
            }
            return "positive";
        }

        // Simple negation heuristics
        if (lower.contains("not") || lower.contains("never") || lower.contains("can't") || lower.contains("cannot")) {
            return "negative";
        }

        // Emoji heuristics
        if (lower.contains(":)") || lower.contains(":-)") || lower.contains("😊") || lower.contains("😃")) {
            return "positive";
        }

        if (lower.contains("😡") || lower.contains("😠")) {
            return "angry";
        }

        // Default AI guess: neutral (helps pipeline avoid unknown)
        return "neutral";
    }
}