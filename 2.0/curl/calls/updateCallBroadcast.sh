#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "name":"Example API Call Broadcast updated",
        "answeringMachineConfig":"LIVE_IMMEDIATE",
        "sounds":
        {
            "liveSoundText":"Hello! This is an updated Call Broadcast config tts"
        }
    }' "https://api.callfire.com/v2/calls/broadcasts/15"
