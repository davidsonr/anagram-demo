#!/usr/bin/env bash
set -euo pipefail

mvn clean install
mvn compile exec:java