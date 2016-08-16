#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    [
        {
            "firstName":"Test",
            "lastName":"Contact",
            "homePhone":"12135551124"
        }
    ]' "https://api.callfire.com/v2/contacts"
