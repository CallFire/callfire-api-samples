#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "call": true,
        "text": false
    }' "https://api.callfire.com/v2/contacts/dncs/12132000381"
