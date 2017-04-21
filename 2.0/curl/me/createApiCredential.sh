#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X POST -d '
    {
        "name":"api-integration"
    }' "https://api.callfire.com/v2/me/api/credentials"
