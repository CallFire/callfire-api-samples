#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/keywords/leases?offset=0&limit=10&fields=items(keyword,leaseBegin,leaseEnd)"
