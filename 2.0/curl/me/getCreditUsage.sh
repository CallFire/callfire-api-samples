#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/me/billing/credit-usage?intervalBegin=2145905600000&intervalEnd=2145945600000"
