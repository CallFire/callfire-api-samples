#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "enabled":"false"
    }' "https://api.callfire.com/v2/campaigns/batches/1"
