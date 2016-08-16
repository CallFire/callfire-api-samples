#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "name":"Created Contact List updated"
    }' "https://api.callfire.com/v2/contacts/lists/3"
