#!/usr/bin/env bash

curl -u username:password -X POST -F 'file=@test2.png;type=image/png;' "https://api.callfire.com/v2/media"
