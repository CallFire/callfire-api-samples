#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/keywords/leases/SUN?fields=items(keyword,leaseBegin,leaseEnd)"
