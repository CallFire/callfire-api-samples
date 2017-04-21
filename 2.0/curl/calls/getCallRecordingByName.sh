#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/calls/379506003/recordings/call-recording1?fields=callId,campaignId,lengthInBytes,mp3Url"
