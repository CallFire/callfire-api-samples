#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "call": true,
        "text": true,
        "source": "My DNC list 1"
    }' "https://api.callfire.com/v2/contacts/dncs/12132212384"
