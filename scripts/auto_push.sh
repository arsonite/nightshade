#!/bin/bash

# Define a timestamp function
DATE_WITH_TIME=`date "+%d.%m.%Y - %H:%M:%S"`
git add . && git commit -m "auto_push ($DATE_WITH_TIME)" && git push