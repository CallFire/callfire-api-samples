#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/calls/379506003/recordings?fields=items(callId,campaignId,lengthInBytes,mp3Url)"
