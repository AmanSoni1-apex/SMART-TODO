package com.todo.smart_todo.analyzer;
/**
 * Simple analyzer interface. Implementations return one of:
 * "positive", "negative", "angry", "neutral", or "unknown".
 * All results must be lowercase.
 */
public interface EmotionAnalyzer {
    String analyze(String text);
}
