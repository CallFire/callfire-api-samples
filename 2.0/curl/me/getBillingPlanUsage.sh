#!/usr/bin/env bash

curl -u "api_login:api_password" -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/me/billing/plan-usage"
