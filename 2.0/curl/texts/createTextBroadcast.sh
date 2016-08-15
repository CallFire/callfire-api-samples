#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "name":"Example API SMS",
        "fromNumber":"19206596476",
        "recipients":[
            {
                "phoneNumber":"13233832214"
            },
            {
                "phoneNumber":"13233832214"
            }
        ],
        "message":"Hello World!",
        "resumeNextDay":"true"
    }' "https://api.callfire.com/v2/texts/broadcasts"
