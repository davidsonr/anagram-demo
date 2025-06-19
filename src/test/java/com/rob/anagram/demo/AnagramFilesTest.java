package com.rob.anagram.demo;

import java.io.InputStream;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnagramFilesTest {

  @Test
  @DisplayName("Should read file and extra multiple anagrams")
	void shouldReadValidFile() {

    // arrange
    AnagramFiles anagramFileReader = new AnagramFiles();
    InputStream stream = getClass().getResourceAsStream("/test-anagram1.txt");

    // act
    List<AnagramWord> anagrams = anagramFileReader.getAnagramWordsFromStream(stream);

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





}