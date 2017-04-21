#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/numbers/leases/configs?prefix=14245&city=Los Angeles&state=CA&zipcode=90940&lata=123&rateCenter=123&labelName=my label&offset=0&limit=10&fields=items(number,configType)"
