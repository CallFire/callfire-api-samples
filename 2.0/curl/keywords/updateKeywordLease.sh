#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "autoRenew":"false"
    }' "https://api.callfire.com/v2/keywords/leases/CALLFIRE"
