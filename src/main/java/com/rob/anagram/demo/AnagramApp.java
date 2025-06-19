package com.rob.anagram.demo;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Slf4j
public class AnagramApp {

  public static void main(String[] args) throws IOException {

		log.info("App started");
    AnagramFiles anagramFileReader = new AnagramFiles();

    InputStream inputStream;
    if (args != null && args.length == 2 && args[0].equals("--anagram-file")) {
      String filename = args[1];
      inputStream = anagramFileReader.getAnagramInputStream(filename);
    } else {
      inputStream = anagramFileReader.getDefaultAnagramInputStream();
    }

    // read the file -- throw exception here
    var allAnagramWords = anagramFileReader.getAnagramWordsFromStream(inputStream);

    // get the results
    AnagramResults anagramResults = new AnagramResults();
    var results = anagramResults.fetchAnagramResults(allAnagramWords);

    // output to a file
    String report = String.join("\n", results);
    Path outDir = Path.of("target", "anagram-report");
    Files.createDirectories(outDir);

    Path outFile = outDir.resolve("default.txt");
    // write the single String; uses UTF-8 by default
    Files.writeString(
        outFile,
        report,
        StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING
    );

		log.info("Application Finished file written to: [{}] ", outFile);
  }
}
