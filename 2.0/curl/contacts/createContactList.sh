#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "name":"Created Contact List",
        "contacts":
        [
            {
                "firstName":"Carl",
                "lastName":"Friar",
                "homePhone":"12135551125"
            }
        ]
    }' "https://api.callfire.com/v2/contacts/lists"
