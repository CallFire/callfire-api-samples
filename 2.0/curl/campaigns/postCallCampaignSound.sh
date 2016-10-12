#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X POST -d '
    {
        "name":"Sound 1",
        "toNumber":"12135551122"
    }' "https://api.callfire.com/v2/campaigns/sounds/calls"
