#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/texts/broadcasts?name=broadcast name&label=my label&running=true&offset=0&limit=10&fields=items(id,name,status,message)&scheduled=false&intervalBegin=1473781817000&intervalEnd=1473781817000"
