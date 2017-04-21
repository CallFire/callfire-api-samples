#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    [
        {
            "phoneNumber":"12135551122",
            "message":"Hello World!"
        },
        {
            "contactId":122460000043
        },
        {
            "phoneNumber":"12135558090",
            "attributes":
            {
                "custom_external_id": 30005044,
                "custom_name": "Alice"
            },
            "message": "Hello, ${custom_name}!"
        }
    ]' "https://api.callfire.com/v2/texts?campaignId=4050600003&defaultMessage=Hello!"
