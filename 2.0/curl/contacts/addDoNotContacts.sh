#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "source": "My DNC list 1",
        "call": true,
        "text": true,
        "numbers": ["12132000381", "12132000382", "12132000383"]
    }' "https://api.callfire.com/v2/contacts/dncs"
