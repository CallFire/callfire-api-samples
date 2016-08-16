#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "number":"12135551130",
        "call":"false",
        "text":"true"
    }' "https://api.callfire.com/v2/contacts/dncs"
