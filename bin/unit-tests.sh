#!/usr/bin/env bash
trap 'exit 1' ERR

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
