#!/usr/bin/env bash

set -euo pipefail

mvn clean test
mvn exec:java

cat target/anagram-report/default.txt