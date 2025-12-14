#!/bin/sh

FILE=$1
DIR=$2

cat $FILE | grep error | awk '{print $1}'

if [ $FILE = test.txt ]; then
    echo File is test
fi

for f in `ls $DIR`; do
    echo Processing $f
done

NOW=`date +%Y-%m-%d`

echo $NOW | sed 's/-/_/g'

[[ $FILE == *.txt ]] && echo Text file

rm -rf $DIR/*

COUNT=$((COUNT + 1))

while read line; do
    echo $line
done < $FILE

cd $DIR

export TEMP=123

false
if [ $? -eq 0 ]; then
    echo "This will never happen"
fi

if test $COUNT -gt 10; then
    echo "Big number"
fi

(cat $FILE)

PATH=$PATH:/tmp/mybin

. ./config.sh

echo *

if [ `whoami` = root ]; then
    echo "Running as root"
fi
