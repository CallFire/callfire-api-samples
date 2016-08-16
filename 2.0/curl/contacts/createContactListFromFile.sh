#!/usr/bin/env bash

curl -u username:password -X POST -F "name=testing" -F "file=@small_contact_upload.csv" "https://api.callfire.com/v2/contacts/lists/upload"
