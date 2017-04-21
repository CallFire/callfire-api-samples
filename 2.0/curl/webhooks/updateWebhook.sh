#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT "https://api.callfire.com/v2/webhooks/11646003" -d '
    {
        "name":"sms sent update",
        "events":["Finished"],
        "callback":"https://callback-service.com/listener2"
    }'
