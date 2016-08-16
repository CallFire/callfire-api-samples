#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "name":"contact batch for text",
        "recipients":
        [
                {
                    "phoneNumber":"12135551122"
                }
        ],
        "scrubDuplicates":"true"
    }' "https://api.callfire.com/v2/texts/broadcasts/13/batches"
