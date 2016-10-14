#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    [
        {
            "firstName":"Alice",
            "lastName":"Moore",
            "homePhone":"12135551124",
            "mobilePhone":"12136666123",
            "workPhone":"14553327789",
            "zipcode":"40460",
            "properties": {
                "custom_age":30,
                "custom_position":"Manager"
            }
        },
        {
            "firstName":"Bob",
            "lastName":"Smith",
            "homePhone":"17885551111",
            "mobilePhone":"17886666122",
            "workPhone":"17883327700",
            "zipcode":"25600",
            "properties": {
                "custom_ext_system_id":100200301
            }
        }
    ]' "https://api.callfire.com/v2/contacts"
