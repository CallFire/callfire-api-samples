#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT "https://api.callfire.com/v2/webhooks/1/" -d '
    {
        "name":"API hook", 
        "resource":"textCampaign", 
        "events":["stop"], 
        "callback":"https://callfire.com/stopTextsOnly"
    }'
