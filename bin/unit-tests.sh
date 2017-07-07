#!/usr/bin/env bash
set -e
./gradlew --version

echo ""
echo ">>> Running configlet..."
bin/fetch-configlet
bin/configlet .

pushd exercises
echo ""
echo ">>> Running tests..."
TERM=dumb ../gradlew check compileStarterSourceJava --parallel --configure-on-demand --continue
popd

