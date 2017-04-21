#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "name":"Campaign name updated",
        "message":"a new test message"
    }' "https://api.callfire.com/v2/texts/broadcasts/11646003"
