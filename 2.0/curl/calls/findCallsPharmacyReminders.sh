#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/calls?campaignId=10&label=reminders&intervalBegin=1448920800000&intervalEnd=1449698400000&limit=10"
