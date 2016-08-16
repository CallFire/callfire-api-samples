#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X POST -d '
    {
        "verificationCode":"1234"
    }' "https://api.callfire.com/v2/me/callerids/12135551175/verification-code"
