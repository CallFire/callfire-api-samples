#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X POST -d '
    {
        "localCount":"2",
        "zipcode":"90401"
    }' "https://api.callfire.com/v2/orders/numbers"
