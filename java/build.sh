#!/bin/bash

set -e

find src -name "*.java" | xargs javac -d bin/classes
jar -cfe bin/main.jar Main -C bin/classes .
