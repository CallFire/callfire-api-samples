#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "number":"67076",
        "keyword":"CALLFIRE",
        "message":"I am a leaf on the wind"
    }' "https://api.callfire.com/v2/texts/auto-replys"
