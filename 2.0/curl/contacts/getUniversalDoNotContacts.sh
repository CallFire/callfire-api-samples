#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/contacts/dncs/universals/12135551126?fromNumber=12130021127&fields=toNumber,inboundCall,outboundCall"
