#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST "https://api.callfire.com/v2/webhooks" -d '
    {
        "name":"Sms sent",
        "resource":"OutboundText",
        "events":["Finished"], 
        "callback":"https://callback-service.com/listener"
    }'
