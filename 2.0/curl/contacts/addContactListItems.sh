#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "contacts":
        [
            {
                "firstName":"Alice",
                "lastName":"Moore",
                "homePhone":"12135551126"
            },
            {
                "firstName":"Bob",
                "lastName":"Smith",
                "homePhone":"12135551127",
                "properties":
                {
                    "age":30
                }
            }
        ]
    }' "https://api.callfire.com/v2/contacts/lists/3/items"

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "contactIds":
        [
            800634185003,
            800734186003,
            800834187003,
            800984185003
        ]
    }' "https://api.callfire.com/v2/contacts/lists/3/items"

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "contactNumbers":
        [
            "12132212384",
            "12136612355",
            "12133312300"
        ],
        "contactNumbersField":"workPhone"
    }' "https://api.callfire.com/v2/contacts/lists/3/items"

