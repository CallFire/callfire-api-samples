#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "contacts":
        [
            {
                "firstName":"Contact",
                "lastName":"One",
                "homePhone":"12135551126"
            },
            {
                "firstName":"Contact",
                "lastName":"Two",
                "homePhone":"12135551127"
            }
        ]
    }' "https://api.callfire.com/v2/contacts/lists/3/items"
