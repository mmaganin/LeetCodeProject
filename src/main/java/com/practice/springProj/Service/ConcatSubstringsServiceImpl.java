package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.ConcatSubstringsService;

import java.util.*;
import java.util.stream.Collectors;
//number 30
public class ConcatSubstringsServiceImpl implements ConcatSubstringsService {

    @Override
    public List<Integer> findSubstring(String s, String[] words) {
        int requiredLenSubstring = words.length * words[0].length();
        List<Integer> output = new LinkedList<>();
        HashMap<String, Integer> wordsAsMap = wordsArrToMap(words);
        HashMap<String, Integer> tempMap;

        if(requiredLenSubstring > s.length()) return List.of();
//        HashSet<String> possibleSubstrings = convertPermsToSet(generateSubstringPermutations(new ArrayList<>(List.of(words))));

        for(int i = 0; i < s.length(); i++){
            if(i + requiredLenSubstring > s.length()) break;
            tempMap = new HashMap<>(wordsAsMap);
            if(isValidWord(s, words, i, tempMap)) output.add(i);
//            else if(possibleSubstrings.contains(s.substring(i, i + requiredLenSubstring))) output.add(i);
        }

        return output;
    }

    public boolean isValidWord(String s, String[] words, int sIdx, HashMap<String, Integer> wordsAsMap){
        int requiredLenSubstring = words.length * words[0].length();
        int singleWordLength = words[0].length();
        String tempWord;
        int j;

        for(j = sIdx; j <= sIdx + requiredLenSubstring - singleWordLength; j += singleWordLength){
            tempWord = s.substring(j, j + singleWordLength);
            if(!wordsAsMap.containsKey(tempWord) || wordsAsMap.get(tempWord) <= 0){
                return false;
            } else {
                wordsAsMap.replace(tempWord, wordsAsMap.get(tempWord) - 1);
            }
        }
        wordsAsMap.clear();

        return true;
    }

    public HashMap<String, Integer> wordsArrToMap(String[] words){
        HashMap<String, Integer> wordsMap = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            if(wordsMap.containsKey(words[i])) wordsMap.replace(words[i], wordsMap.get(words[i]) + 1);
            else wordsMap.put(words[i], 1);
        }
        return wordsMap;
    }

    public List<List<String>> generateSubstringPermutations(List<String> original) {
        if (original.isEmpty()) {
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        String firstElement = original.remove(0);
        List<List<String>> returnValue = new ArrayList<>();
        List<List<String>> permutations = generateSubstringPermutations(original);
        for (List<String> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                List<String> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }

    public HashSet<String> convertPermsToSet(List<List<String>> substringPermutations){
        return (HashSet<String>) substringPermutations.stream()
                .map(list -> list.stream().reduce((a,c) -> a + c).orElse(""))
                .collect(Collectors.toSet());
    }
}
