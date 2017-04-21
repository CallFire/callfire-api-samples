#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/contacts/dncs?prefix=1424&number=12135551126&number=12136666123&campaignId=11646003&source=my source&call=true&text=true&offset=0&limit=10&fields=items(number,call)"
