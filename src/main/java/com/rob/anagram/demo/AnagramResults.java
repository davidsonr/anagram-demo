package com.rob.anagram.demo;

import static java.util.stream.Collectors.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnagramResults {

	List<String> fetchAnagramResults(List<AnagramWord> allAnagrams) {

		// group on sorted words, LinkedHashMap to preserve order
		Map<String, List<AnagramWord>> anagrams =
			allAnagrams
				.stream()
				.collect(groupingBy(
					AnagramWord::getSortedWord,
					LinkedHashMap::new,
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
