#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/texts/broadcasts/11646003/stats?begin=1473781817000&end=1473781817000&fields=totalOutboundCount,billedAmount,sentCount"
