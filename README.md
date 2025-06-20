
# anagram-demo

This Java program parses `words-utf8.txt` (one word per line) and writes all detected anagram groups to `target/anagram-report/default.txt`.


## Project setup requirements

- Java 21
- Apache Maven

## Getting Started

```bash

## 1. execute the tests
mvn test

## 2. execute the application
mvn compile exec:java

## 3. view the report
cat target/anagram-report/default.txt
```

Or just run

`run-app.sh`

## Architecture & Design Decisions

- **TDD-based design.** Tests drove implementation and system structure.

- **Minimal dependencies:**
    - Lombok (reduces boilerplate)
    - Google Checkstyle auto-format code style consistency
    - Hamcrest for testing with expressive collection assertions
- **Behavior:**
    - Console-based, scriptable execution
- **Excluded:** Spring Framework

## Out of Scope

Things considered but ruled out of scope to keep the app small but could be explored further

- Building an executable JAR (used `mvn exec` for simplicity)
- CI pipeline setup
- Ability to use different anagrams files on demand
- Fault tolerance
   - Assumes case-insensitive matching.
   - Error handling. Could do better on whitespaces
   - Error exceptions e.g. file not found
