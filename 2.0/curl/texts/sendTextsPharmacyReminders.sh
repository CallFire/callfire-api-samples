#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    [
        {
            "phoneNumber":"12135551100",
            "message":"Hello ${contact_name}, you have an appointment with Dr. Andrew tomorrow at 3:00 PM, if you need to reschedule please call (855)-555-4477",
            "attributes":
            {
                "contact_name":"Alice",
                "external_user_id":"45450007002"
            }
        }
    ]' "https://api.callfire.com/v2/texts"
