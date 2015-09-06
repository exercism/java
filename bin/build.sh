#!/bin/bash
set -e
gradle --version
echo ""
echo ">>> Running tests..."
TERM=dumb gradle check compileStarterSourceJava --continue


echo ""
echo ">>> Running configlet..."
bin/fetch-configlet
bin/configlet .
