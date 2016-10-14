#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST "https://api.callfire.com/v2/webhooks" -d '
    {
        "name":"Call finished webhook",
        "resource":"OutboundCall",
        "events":["Finished"], 
        "callback":"http://callback-service.com/webhook"
    }'
