#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/texts?fromNumber=12135551100&intervalBegin=1473781817000&intervalEnd=1473781917000&offset=100&limit=50&fields=items(id,message,created)"
