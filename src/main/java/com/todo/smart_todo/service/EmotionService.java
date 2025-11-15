package com.todo.smart_todo.service;

import org.springframework.stereotype.Service;
import com.todo.smart_todo.analyzer.*;

@Service
public class EmotionService {

    private final LocalEmotionAnalyzer localAnalyzer;
    private final EmotionAiAnalyzer aiAnalyzer;

    public EmotionService(LocalEmotionAnalyzer localAnalyzer,
                          EmotionAiAnalyzer aiAnalyzer) {
        this.localAnalyzer = localAnalyzer;
        this.aiAnalyzer = aiAnalyzer;
    }

     /**
     * 1) Try local analyzer.
     * 2) If local returns a definite non-neutral result (positive/negative/angry) -> use it.
     * 3) If local returns "neutral" or "unknown" -> call AI fallback and return that.
     */
    
    public String analyzeEmotion(String text) {
        String localResult = localAnalyzer.analyze(text); 
        if(localResult == null) localResult="unknown";

           // If local found a clear emotion (not neutral/unknown), trust it.
        if(!"neutral".equals(localResult) && !"unknown".equals(localResult)){
            return localResult;
        }

        String aiResult = aiAnalyzer.analyze(text);
        if(aiResult == null) aiResult="unkown";
        return aiResult;
    }
}

