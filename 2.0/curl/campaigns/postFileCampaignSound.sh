#!/usr/bin/env bash

curl -u username:password -X POST -F 'file=@/home/user1/Desktop/testsound.mp3' "https://api.callfire.com/v2/campaigns/sounds/files"
