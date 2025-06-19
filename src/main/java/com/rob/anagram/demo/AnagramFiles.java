package com.rob.anagram.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnagramFiles {

  final static String DEFAULT_ANAGRAM_FILE = "/ordbok-utf8.txt";


  public List<AnagramWord> getAnagramWordsFromStream(InputStream inputStream) {

    try (var reader = new BufferedReader(
        new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
      return reader.lines()
          .filter(line -> !line.isBlank())
          .map(String::trim)
          .map(AnagramWord::new)
          .toList();
    } catch (IOException e) {
      log.error("Error reading anagram input stream", e);
      throw new RuntimeException(e);
    }
  }

  public InputStream getAnagramInputStream(String fileName) {
    try {
      return getClass().getResourceAsStream(fileName);
    } catch (Exception e) {
      log.error("Unable to read the default ordbok-utf8.txt file ", e);
      throw new RuntimeException(e);
    }
  }

  public InputStream getDefaultAnagramInputStream() {
    try {
      return getClass().getResourceAsStream(DEFAULT_ANAGRAM_FILE);
    } catch (Exception e) {
      log.error("Unable to read the default ordbok-utf8.txt file ", e);
      throw new RuntimeException(e);
    }
  }
}