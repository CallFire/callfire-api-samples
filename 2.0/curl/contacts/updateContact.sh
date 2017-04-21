#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "mobilePhone":"12136600123",
        "workPhone":"14553320089"
    }' "https://api.callfire.com/v2/contacts/11646003"
