#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    [
        {
            "phoneNumber":"12135551100",
            "message":"Hello World!"
        },
        {
            "phoneNumber":"12135551101",
            "message":"Testing 1 2 3"
        }
    ]' "https://api.callfire.com/v2/texts"
