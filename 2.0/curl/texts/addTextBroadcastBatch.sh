#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "name":"contact batch for text",
        "recipients":
        [
            {
                "phoneNumber":"12135551122"
            },
            {
                "phoneNumber":"12135553434"
            },
            {
                "phoneNumber":"12135558090",
                "attributes":
                {
                    "custom_external_id": 30005044,
                    "custom_property_1": "value1"
                }
            }
        ],
        # or you can add contacts from particular contact list
        # contactListId: 70055003
        "scrubDuplicates":"true"
    }' "https://api.callfire.com/v2/texts/broadcasts/11646003/batches"
