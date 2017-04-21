#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/texts/broadcasts/5500030002/texts?offset=0&limit=10&fields=items(fromNumber,toNumber,state,message)"

