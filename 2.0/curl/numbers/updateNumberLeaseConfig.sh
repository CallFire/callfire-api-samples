#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X PUT -d '
    {
        "configType":"TRACKING",
        "callTrackingConfig":
        {
            "screen":"false",
            "recorded":"true",
            "transferNumbers":
            [
                "12135551122",
                "12135551189"
            ]
        }
    }' "https://api.callfire.com/v2/numbers/leases/configs/19206596476"
