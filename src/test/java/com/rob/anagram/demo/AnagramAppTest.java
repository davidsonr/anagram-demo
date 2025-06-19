package com.rob.anagram.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnagramAppTest {

  @DisplayName("should generate multiple lines of anagrams matching example from email")
  @Test
  void shouldGenerateMultipleLinesOfAnagrams() throws IOException {

    // arrange
    String[] args = new String[2];
    args[0] = "--anagram-file";
    args[1] = "/test-anagram-email-example2.txt";

    // act
    AnagramApp.main(args);

    String expectedResult = """
        akte teak kate
        aldri arild
        aller ralle
        alt tal
        andre rande denar ander
        """.trim();

    Path report = Path.of("target", "anagram-report", "default.txt");

    assertTrue(Files.exists(report),
        () -> "Expected report at " + report.toAbsolutePath());

    String actualResult = Files.readString(report);

    assertEquals(expectedResult, actualResult, "multiple line anagrams should match");

  }

}
