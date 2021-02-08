#!/bin/bash

# Define a timestamp function
DATE_WITH_TIME=`date "+%d.%m.%Y-%H:%M:%S(auto_push)"`
git add . && git commit -m "$DATE_WITH_TIME" && git push