#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/numbers/leases/configs/12132000384?fields=number,configType"

