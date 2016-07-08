#!/bin/bash
set -e

eval "$(curl -sL https://raw.githubusercontent.com/travis-ci/gimme/master/gimme | GIMME_GO_VERSION=1.5.3 bash)"
export HOME=$HOME/build/bronhuston
export GOPATH=$HOME

REPO_ROOT=$HOME
EXERCISM_HOME=~/workspace/exercism/exercises
SET_RUBY_VER_CMD=""

mkdir -p ~/workspace/exercism
cd ~/workspace/exercism/
git clone https://github.com/exercism/x-api
cd x-api
git submodule init -- metadata
git submodule init -- tracks/java
git submodule update

$SET_RUBY_VER_CMD
gem install bundler
bundle install

RACK_ENV=development rackup&

sleep 5

export PATH=$PATH:$GOPATH/bin
go get -u github.com/exercism/cli/exercism
exercism -v

mkdir -p $EXERCISM_HOME
cd $EXERCISM_HOME
exercism configure --dir=$EXERCISM_HOME
exercism configure --api http://localhost:9292

exercism debug

cd $REPO_ROOT
EXERCISES=`cat config.json | jq '.problems []' --raw-output`

for EXERCISE in $EXERCISES; do
  exercism fetch java $EXERCISE
  cp -R -H $REPO_ROOT/exercises/$EXERCISE/src/example/java/* $EXERCISM_HOME/java/$EXERCISE/src/main/java/
  cd $EXERCISM_HOME/java/$EXERCISE/
  gradle test
done
