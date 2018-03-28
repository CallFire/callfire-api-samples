#!/usr/bin/env bash

curl -u "api_login:api_password" -H "Content-Type:application/json" -X POST -d '
    {
        "verificationCode":"1234"
    }' "https://api.callfire.com/v2/me/callerids/12132000384/verification-code"
