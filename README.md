

Design Assumptions and Approach


Follow TDD approach. Starting with the test this will shape the eventual design of the system
Testing Validation of input and validation mostly done at unit test level 
Minimal depdenecies.  Add depdnecies that help with speed and consistency.
 - lombok - less boiler plate code
 - check style - use google checkstyle and auto formatting with intellij.  All set to use defaults.
 - junit for writing tests
 - Bash for integration test

 I’ve added Hamcrest to make testing collection assertions more expressive, hamcrest is included with most 
 Java spring projects and although this is not a spring project I think it is a useful test library

case insensive anagram - but allow it to be changed.  
ignore whitespace to allow better fault tolerance 
console based - provide script to run and execute
allow extensino. e.g. change the report format, file input option without needing to modify unrelated parts of the code base

Test pyriamid approach, more unit tests fewer integration tests

Java 21 is the current LTS version of java so will use this
# anagram-demo
