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
            "properties":
            {
                "custom_ext_system_id":100200301
            }
        },
        {
            "firstName":"Bob",
            "lastName":"Smith",
            "homePhone":"12135551127",
            "properties":
            {
                "custom_age":30,
                "custom_position":"Manager"
            }
        }
    ]' "https://api.callfire.com/v2/contacts"
