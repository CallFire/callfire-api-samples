#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X POST -d '
    {
        "keywords": [
            "SUN", "MOON"
        ]
    }' "https://api.callfire.com/v2/orders/keywords"
