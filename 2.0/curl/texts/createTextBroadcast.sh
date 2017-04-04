#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X POST -d '
    {
        "name":"Charity SMS Campaign",
        "labels": [
            "charity",
            "id-10003"
        ],
        "fromNumber":"19206596476",
        "recipients":[
            {
                "phoneNumber":"13233834422",
                "attributes": {
                    "u_name": "Alice",
                    "age": 30
                }
            },
            {
                "phoneNumber":"13233834433",
                "attributes": {
                    "u_name": "Mark",
                    "age": 45
                }
            },
            {
                "phoneNumber":"13233834488",
                "message": "Hi ${u_name}, the megic number is ${magic_number}",
                "attributes": {
                    "u_name": "Jane",
                    "magic_number": "10"
                }
            }
        ],
        "message":"Hello {u_name}, Missing for a great event ? We invite you to participate in a charity fair which takes place at first Saturday of November. You can order tickets by calling us: 855-555-5555. We are looking forward to meet you there"
    }' "https://api.callfire.com/v2/texts/broadcasts"
