package com.rob.anagram.demo;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramResults {

  List<String> fetchAnagramResults(List<AnagramWord> allAnagrams) {

    // group on sorted words
    Map<String, List<AnagramWord>> anagrams =
        allAnagrams
            .stream()
            .collect(groupingBy(
                e -> e.getSortedWord(),
                toList()));

    // once you have the grouping you only want anagrams
    // with more than one match
    return anagrams.entrySet()
            .stream()
            .filter(e -> e.getValue().size() > 1)
            .map(e -> e.getValue()
                .stream()
                .map(AnagramWord::getOriginalWord)
                .collect(joining(" ")))
            .toList();
  }


}
