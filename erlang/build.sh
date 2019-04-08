#!/bin/bash

set -e

mkdir -p bin
erlc -o bin src/*.erl
