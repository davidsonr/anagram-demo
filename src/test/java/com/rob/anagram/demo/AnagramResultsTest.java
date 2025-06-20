package com.rob.anagram.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnagramResultsTest {


	@DisplayName("should not return null for list of valid anagrams")
	@Test
	void shouldNotReturnNullForValidAnagrams() {

		// arrange
		List<AnagramWord> allAnagrams = Arrays.asList(
			new AnagramWord("abc"),
			new AnagramWord("bac"),
			new AnagramWord("aba")
		);

		AnagramResults anagramResults = new AnagramResults();

		// act
		var actualReport = anagramResults.fetchAnagramResults(allAnagrams);

		// assert
		assertNotNull(actualReport);
	}


	@DisplayName("should generate a report for basic anagram input")
	@Test
	void shouldGenerateReportForValidAnagrams() {

		// arrange
		List<AnagramWord> allAnagrams = Arrays.asList(
			new AnagramWord("abc"),
			new AnagramWord("bac"),
			new AnagramWord("cba")
		);

		AnagramResults anagramResults = new AnagramResults();

		// act
		var actualReport = anagramResults.fetchAnagramResults(allAnagrams);

		// assert
		assertEquals("abc bac cba", actualReport.getFirst());
	}


	@DisplayName("should skip words not part of anagram")
	@Test
	void shouldSkipWordsNotPartOfAnagram() {

		// arrange
		List<AnagramWord> allAnagrams = Arrays.asList(
			new AnagramWord("abc"),
			new AnagramWord("bac"),
			new AnagramWord("cbz")  // not part of anagram
		);

		AnagramResults anagramResults = new AnagramResults();

		// act
		var actualReport = anagramResults.fetchAnagramResults(allAnagrams);

		// assert
		assertEquals("abc bac", actualReport.getFirst());
	}


	@DisplayName("should generate a report for multiple anagrams")
	@Test
	void shouldGenerateReportForMultipleValidAnagrams() {

		// arrange
		List<AnagramWord> allAnagrams = Arrays.asList(
			new AnagramWord("abc"),
			new AnagramWord("bac"),
			new AnagramWord("cba"),
			new AnagramWord("xyza"),
			new AnagramWord("zyxa")
		);

		AnagramResults anagramResults = new AnagramResults();

		// act
		var actualReport = anagramResults.fetchAnagramResults(allAnagrams);

		String expectedReport = """
			abc bac cba
			xyza zyxa
			""".strip();

		// assert
		assertEquals(expectedReport, String.join("\n", actualReport));
	}

}