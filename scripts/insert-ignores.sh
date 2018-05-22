#!/usr/bin/env bash

# This script will add @Ignore for all the testcases except first testcase. It will also add import org.junit.Ignore;, if it will be missing
# post adding @Ignore.


for file in `find . -name "*Test.java"`; do

	tempfile="/tmp/insert-ignores.tmp"

	echo -e "\n\n\n*** $file ******************************"


	## This AWK code will check for missing Ignore with the @Test and add it

	awk 'BEGIN{igonreset=0;firsttest=1}{if($0~/.*@Ignore.*/){igonreset=1}if($0 ~ /^.*@Test/){if(igonreset!=1 && firsttest==0){print "    @Ignore(\"Remove to run test\")";}firsttest=0;igonreset=0}print $0}' $file > $tempfile
	mv "$tempfile" "$file"

	## Checking if @Ignore is added. If @Ignore is added then only import org.junit.Ignore; will be added
	ignoreAdded=`grep -q '@Ignore' $file ; echo $?` > /dev/null

	if [ $ignoreAdded -eq 0 ]
	then
		#ignoreFound variable will check if already Ignore is imported or not.
		ignoreFound=`grep -q 'import org.junit.Ignore;' $file ; echo $?` > /dev/null

		#if ignore is not imported then add line for import
		if [ $ignoreFound -ne 0 ]
		then
		  cat $file | sed 's/import org.junit.Test;/import org.junit.Test;\
import org.junit.Ignore;/' >  $tempfile
		  mv "$tempfile" "$file"
		  pwd
		fi
	fi

done
