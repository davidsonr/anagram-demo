package com.rob.anagram.demo;

import java.io.IOException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnagramApp {

  public static void main(String[] args) throws IOException {

		log.info("App started");

		// load anagram file
    AnagramFiles anagramFileReader = new AnagramFiles();
    InputStream inputStream;
    if (args != null && args.length == 2 && args[0].equals("--anagram-file")) {
      String filename = args[1];
      inputStream = anagramFileReader.getAnagramInputStream(filename);
    } else {
      inputStream = anagramFileReader.getDefaultAnagramInputStream();
    }

		// get results
    var allAnagramWords = anagramFileReader.getAnagramWordsFromStream(inputStream);
		AnagramResults anagramResults = new AnagramResults();
		var results = anagramResults.fetchAnagramResults(allAnagramWords);

		// save report
		anagramFileReader.saveAnagramReport(results);

		log.info("Successfully finished");
  }
}
