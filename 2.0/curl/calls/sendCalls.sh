#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    [
        {
            "phoneNumber":"12135551100",
            "liveMessage":"Why hello there!"
        },
        {
            "phoneNumber":"12135551101",
            "liveMessage":"And hello to you too."
        }
    ]' "https://api.callfire.com/v2/calls"
