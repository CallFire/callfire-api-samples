#!/usr/bin/env bash

curl https://www.callfire.com/api/1.1/rest/subscription.json \
    -X POST \
    -u login:password \
    -d Endpoint=https://callback-service.com/listener \
    -d NotificationFormat=JSON \
    -d TriggerEvent=OUTBOUND_TEXT_FINISHED
