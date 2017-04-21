#!/usr/bin/env bash

curl -u username:password -X POST -F "name=My Contact List" -F "file=@contacts.csv" "https://api.callfire.com/v2/contacts/lists/upload"
