package com.rob.anagram.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class AnagramWordTest {

  @DisplayName("Should convert valid word to Anagram object")
  @Test
  void shouldConvertWordToAnagramWord() {

    String word = "CBA";

    var AnagramWord = new AnagramWord(word);

    assertEquals("CBA", AnagramWord.getOriginalWord());
    assertEquals("ABC", AnagramWord.getSortedWord());
  }

  @DisplayName("Should throw exception for invalid anagram words")
  @ValueSource(strings = {"cba ", " ", "ABC12", "AB BA"})
  @ParameterizedTest(name = "invalid input: \"{0}\"")
  void shouldThrowExceptionForInvalidAnagram(String invalidAnagram) {
    assertThrows(IllegalArgumentException.class, () -> new AnagramWord(invalidAnagram));
  }

}