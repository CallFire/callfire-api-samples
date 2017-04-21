#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X GET "https://api.callfire.com/v2/contacts/lists/379506003/items?offset=0&limit=10&fields=items(firstName,lastName,workPhone)"
