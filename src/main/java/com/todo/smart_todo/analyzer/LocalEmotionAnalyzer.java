package com.todo.smart_todo.analyzer;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class LocalEmotionAnalyzer implements EmotionAnalyzer{
   
    // rule/keyword based detector
    private static final List<String> POSITIVE_KEYWORDS = List.of(
        "happy","great","good","awesome","nice","love","pleased","accomplishment","success"
    );

    private static final List<String> NEGATIVE_KEYWORDS = List.of(
        "sad","depressed","unhapppy","down","disappointed","bad","terrible","fail","failed"
    ); 

    private static final List<String> ANGRY_KEYWORD = List.of(
        "angry","furious","mad","irritated","annoyed","pissed","frustrated","hate"
    );

    private static final List<String> NEUTAL_KEYWORDS = List.of(
        "meeting","email","doc","documentation","update","revive","review","schedule","task","routine"
    );

    @Override
    public String analyze(String text){
        if(text == null){
            return "unknown";
        }
        String trimmed = text.trim();
        if(trimmed.isEmpty()){
            return "unknown";
        }

        String lower = trimmed.toLowerCase();

        
        if(ANGRY_KEYWORD.stream().anyMatch(lower::contains)) return "angry";
        if(NEGATIVE_KEYWORDS.stream().anyMatch(lower::contains)) return "negative";
        if(POSITIVE_KEYWORDS.stream().anyMatch(lower::contains)) return "positive";
        if(NEUTAL_KEYWORDS.stream().anyMatch(lower::contains)) return "neutral";

        // .stream -> This converts the list into a stream (a pipeline to check each item).
        // ANGRY -> This is your list of angry words
        // anyMatch(..) -> Is any one of the keywords matching the condition?
        // lower::contains This is the same as: k -> lower.contains(k)
        // If any keyword from ANGRY_KEYWORDS is found inside lower, then anyMatch(...) returns true.

        
        return "unknown";
    }
















}