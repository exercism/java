#!/usr/bin/env bash

for file in `find . -name "*Test.java"`; do
  tempfile="/tmp/insert-ignores.tmp"

  echo -e "\n\n\n*** $file ******************************"
  cat $file | \
  sed 's/import org.junit.Test;/import org.junit.Test;\
import org.junit.Ignore;/' | \
  sed 's/@Test/@Ignore\
    @Test/' | \
  sed '1,/@Ignore/s/.*@Ignore//' > "$tempfile" \
  && mv "$tempfile" "$file"
done

