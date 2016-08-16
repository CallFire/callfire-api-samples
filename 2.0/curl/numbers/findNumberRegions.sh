#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/numbers/regions?zipcode=90401&limit=2"
