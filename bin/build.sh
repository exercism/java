#!/bin/bash
set -e
pushd exercises
gradle --version
echo ""
echo ">>> Running tests..."
TERM=dumb gradle check compileStarterSourceJava --continue
popd

echo ""
echo ">>> Running configlet..."
bin/fetch-configlet
bin/configlet .
