#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/numbers/tollfree?pattern=87*&limit=10&fields=number"
