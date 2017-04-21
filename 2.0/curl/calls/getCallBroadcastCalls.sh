#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/calls/broadcasts/11646003/calls?batchId=5500030002&offset=0&limit=10&fields=items(fromNumber,toNumber,state,modified)"
