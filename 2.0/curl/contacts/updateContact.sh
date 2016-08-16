#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "workPhone":"1213555115"
    }' "https://api.callfire.com/v2/contacts/4103"
