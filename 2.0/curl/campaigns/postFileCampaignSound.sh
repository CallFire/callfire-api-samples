#!/usr/bin/env bash

curl -u username:password -X POST -F 'file=@/path/to/sound.mp3' "https://api.callfire.com/v2/campaigns/sounds/files"
