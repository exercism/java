#!/usr/bin/env bash

LOGGING_CHUNK_FILE=/tmp/test-logging.gradle

cat <<-EOF > $LOGGING_CHUNK_FILE
test {
  testLogging {
    exceptionFormat = 'full'
    events = ["passed", "failed", "skipped"]
  }
}
EOF

for file in `find . -name "build.gradle"`; do
  tempfile="/tmp/increase-test-logging.tmp"

  echo -e "\n\n\n*** $file ******************************"
  cat $file $LOGGING_CHUNK_FILE > "$tempfile"
  mv "$tempfile" "$file"
done

