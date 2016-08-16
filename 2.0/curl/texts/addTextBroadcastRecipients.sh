#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    [
        {
            "phoneNumber":"12135551123"
        }
    ]' "https://api.callfire.com/v2/texts/broadcasts/13/recipients"
