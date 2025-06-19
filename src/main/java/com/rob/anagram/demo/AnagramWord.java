package com.rob.anagram.demo;

import java.util.Arrays;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class AnagramWord {

  private final String originalWord;
  private final String sortedWord;

  public AnagramWord(String originalWord) {
    validateAnagram(originalWord);
    this.originalWord = originalWord;
    this.sortedWord = sortWordAlphabetically(originalWord);
  }

  private static String sortWordAlphabetically(String originalWord) {
    char[] chars = originalWord.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  private static void validateAnagram(String word) {
    // null check
    if (word == null) {
      throw new IllegalArgumentException("Word must not be null");
    }
    // empty or whitespace-only
    if (word.trim().isEmpty()) {
      throw new IllegalArgumentException("Word must contain at least one non-space character");
    }
    // only letters
    if (!word.chars().allMatch(Character::isLetter)) {
      throw new IllegalArgumentException("Word must contain only letters: " + word);
    }
  }

}