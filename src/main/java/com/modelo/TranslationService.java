package com.modelo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TranslationService {

    private Map<String, String> translations;

    public TranslationService(String filePath) throws IOException {
        translations = new HashMap<>();
        loadTranslations(filePath);
    }

    private void loadTranslations(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] pair = line.split("=");
                if (pair.length == 2) {
                    translations.put(pair[0].toLowerCase(), pair[1].toLowerCase());
                }
            }
        }
    }

    public String translate(String word) {
        return translations.getOrDefault(word.toLowerCase(), word);
    }
}
