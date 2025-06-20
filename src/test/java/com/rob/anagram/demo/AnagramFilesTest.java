package com.rob.anagram.demo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramFilesTest {

	private final Path REPORT_TARGET_PATH = Path.of("target", "anagram-report/default.txt");

	@Test
	@DisplayName("Should read file and extra multiple anagrams")
	void shouldReadValidFile() {

		// arrange
		AnagramFiles anagramFiles = new AnagramFiles();
		InputStream stream = getClass().getResourceAsStream("/test-anagram1.txt");

		// act
		List<AnagramWord> anagrams = anagramFiles.getAnagramWordsFromStream(stream);

		// assert
		MatcherAssert.assertThat(anagrams.size(), Matchers.is(6));
		MatcherAssert.assertThat(anagrams, Matchers.contains(
			new AnagramWord("abc"),
			new AnagramWord("cba"),
			new AnagramWord("abc"),
			new AnagramWord("a"),
			new AnagramWord("abcdef"),
			new AnagramWord("abcdfe")
		));
	}

	@Test
	@DisplayName("Should write expected content to file")
	void shouldWriteExpectedContentToFile() throws IOException {

		// arrange
		AnagramFiles anagramFiles = new AnagramFiles();
		List<String> data = List.of("foo", "manchester", "bar");

		// act
		anagramFiles.saveAnagramReport(data);

		// assert
		assertTrue(Files.exists(REPORT_TARGET_PATH));
		String content = Files.readString(REPORT_TARGET_PATH);
		assertEquals(String.join("\n", data), content);
	}


	@DisplayName("Should overwrite existing file with new content")
	@RepeatedTest(2)
	void overwritesExistingFile(RepetitionInfo repetitionInfo) throws IOException {

		int current = repetitionInfo.getCurrentRepetition();

		// arrange
		AnagramFiles anagramFiles = new AnagramFiles();
		Files.createDirectories(REPORT_TARGET_PATH.getParent());
		Files.writeString(REPORT_TARGET_PATH, "OLD CONTENT " + current);
		List<String> data = List.of("foo", "new");

		// act
		anagramFiles.saveAnagramReport(data);

		//assert
		String content = Files.readString(REPORT_TARGET_PATH);
		assertEquals("foo\nnew", content);
	}

}