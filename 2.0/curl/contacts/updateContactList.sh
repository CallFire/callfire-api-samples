#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "name":"contact list updated"
    }' "https://api.callfire.com/v2/contacts/lists/11646003"
