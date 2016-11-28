#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    [
        {
            "phoneNumber":"12135551100",
            "liveMessage":"Hello, Alice, this is message for live answer",
            "machineMessage":"Hello, Alice, this is message for answering machine"
        },
        {
            "phoneNumber":"12135551101",
            "liveMessage":"Hello, Bob, this is message for live answer",
            "machineMessage":"Hello, Bob, this is message for answering machine"
        }
    ]' "https://api.callfire.com/v2/calls"
