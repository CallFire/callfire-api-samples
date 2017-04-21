#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/webhooks?name=my webhook&resourse=TextBroadcast&event=Started&callback=https://myservice/callback&enabled=true&offset=0&limit=10&fields=items(id,name,callback)"
