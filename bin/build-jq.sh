#!/usr/bin/env bash
set -ex

pushd bin
curl --location https://github.com/stedolan/jq/releases/download/jq-1.5/jq-1.5.tar.gz >jq-1.5.tar.gz
tar xvf jq-1.5.tar.gz
cd jq-1.5
./configure --disable-maintainer-mode && make
mv jq ..
popd

