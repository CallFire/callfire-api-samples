#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    [
        {
            "phoneNumber":"12135551122"
        },
        {
            "contactId":122460000043
        },
        {
            "phoneNumber":"12135558090",
            "attributes":
            {
                "custom_external_id": 30005044,
                "custom_property_1": "value1"
            }
        }
    ]' "https://api.callfire.com/v2/texts/broadcasts/11646003/recipients"
