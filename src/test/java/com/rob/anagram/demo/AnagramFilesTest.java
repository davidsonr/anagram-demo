package com.rob.anagram.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class AnagramFilesTest {

  @Test
  void shouldReadValidFile() {

    // arrange
    AnagramFiles anagramFileReader = new AnagramFiles();
    InputStream stream = getClass().getResourceAsStream("/test-anagram1.txt");

    // act
    List<AnagramWord> anagrams = anagramFileReader.getAnagramWordsFromStream(stream);

    assertTrue(StringUtils.isBlank("   "), "StringUtils should detect blank strings");

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