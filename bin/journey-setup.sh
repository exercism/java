#!/bin/bash

git clone https://github.com/exercism/x-api
cd x-api
git submodule init -- metadata
git submodule init -- tracks/java
git submodule update

gem install bundler
bundle install

RACK_ENV=development rackup&

sleep 5

ps aux | grep rackup

curl -i 'localhost:9292/tracks/java/hello-world'
