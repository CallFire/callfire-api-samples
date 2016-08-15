#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    [
        {
            "phoneNumber":"12135551100"
        },
        {
            "phoneNumber":"12135551101"
        }
    ]' "https://api.callfire.com/v2/calls/broadcasts/15/recipients"
