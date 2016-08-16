#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X PUT -d '
    {
        "callFeatureStatus":"DISABLED",
        "autoRenew":"false"
    }' "https://api.callfire.com/v2/numbers/leases/19206596476"
