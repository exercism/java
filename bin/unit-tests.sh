#!/usr/bin/env bash
set -e
./gradlew --version

echo ""
echo ">>> Running configlet..."
bin/fetch-configlet
bin/configlet lint .

pushd exercises
echo ""
echo ">>> Running tests..."
TERM=dumb ../gradlew check compileStarterSourceJava --parallel --continue
popd
