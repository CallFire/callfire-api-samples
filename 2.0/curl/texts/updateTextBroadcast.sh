#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "name":"Example API SMS updated",
        "message":"a new test message"
    }' "https://api.callfire.com/v2/texts/broadcasts/13"
