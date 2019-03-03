package com;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) {
        Map<String,Integer> words= new TreeMap<>((k1, k2) -> k1.compareToIgnoreCase(k2));
        for(String word:args) {
            Integer occurs = words.getOrDefault(word,0);
            words.put(word,occurs);
        }
        System.out.println(words);
    }
}
