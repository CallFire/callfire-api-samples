#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "name":"Contact Batch 1",
        "contactListId": 300555001,
        "scrubDuplicates": true
    }' "https://api.callfire.com/v2/calls/broadcasts/15/batches"
