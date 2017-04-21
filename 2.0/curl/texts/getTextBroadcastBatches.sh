#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/texts/broadcasts/11646003/batches?offset=0&limit=10&fields=items(name,status,size,remaining)"
