#!/usr/bin/env bash

curl -u username:password -X POST -F 'name=test image' -F 'file=@image1.bmp;type=image/bmp;' "https://api.callfire.com/v2/media"
