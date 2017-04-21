#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/contacts/379506003/history?offset=0&limit=10&fields=calls/fromNumber,calls/toNumber,texts/message"

