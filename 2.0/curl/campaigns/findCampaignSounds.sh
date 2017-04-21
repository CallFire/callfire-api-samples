#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/campaigns/sounds?filter=name&includeArchived=true&includePending=true&includeScrubbed=true&offset=0&limit=10&fileds=items(id,name,callback)"
