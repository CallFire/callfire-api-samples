#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST "https://api.callfire.com/v2/webhooks" -d '
    {
        "name":"inbound sms webhook",
        "resource":"InboundText",
        "events":["Finished"],
        "callback":"https://callback-service.com/listener"
    }'
