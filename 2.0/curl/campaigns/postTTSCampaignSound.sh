#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X POST -d '
    {
        "voice":"MALE1",
        "message":"This is a TTS sound"
    }' "https://api.callfire.com/v2/campaigns/sounds/tts"
