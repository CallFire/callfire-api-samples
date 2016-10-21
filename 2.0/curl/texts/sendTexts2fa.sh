#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    [
        {
            "phoneNumber":"12135551100",
            "message":"Your one-time code is 2517",
            "attributes":
            {
                "external_user_id":45450007002
            }
        }
    ]' "https://api.callfire.com/v2/texts"
