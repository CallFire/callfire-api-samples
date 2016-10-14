#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/texts?inbound=true&campaignId=1003002&limit=10"
