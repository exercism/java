#!/bin/bash
set -e
gradle --version

echo ""
echo ">>> Running configlet..."
bin/fetch-configlet
bin/configlet .

pushd exercises
echo ""
echo ">>> Running tests..."
TERM=dumb gradle check compileStarterSourceJava --continue
popd

