#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "name":"Example API Call Broadcast",
        "fromNumber":"12135551189",
        "recipients":[
            {
                "phoneNumber":"2135551133"
            }
        ],
        "answeringMachineConfig":"AM_AND_LIVE",
        "sounds":{
            "liveSoundText":"Hello! This is a live answer text to speech recording",
            "machineSoundText":"This is an answering machine text to speech recording"
        },
        "resumeNextDay":"true"
    }' "https://api.callfire.com/v2/calls/broadcasts"
