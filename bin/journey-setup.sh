#!/bin/bash

rvm install 2.2.1
rvm 2.2.1 do rvm env --path
source $(rvm 2.2.1 do rvm env --path)

git clone https://github.com/exercism/x-api
cd x-api
git submodule init -- tracks/java
git submodule update

gem install bundler
bundle install
rackup
