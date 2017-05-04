<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->createTextBroadcast();
        $body = '{
                    "name":"Charity SMS Campaign",
                    "labels":
                    [
                        "charity",
                        "id-10003"
                    ],
                    "fromNumber":"19206596476",
                    "recipients":
                    [
                        {
                            "phoneNumber":"13233834422",
                            "attributes":
                            {
                                "u_name": "Alice",
                                "age": 30
                            }
                        },
                        {
                            "phoneNumber":"13233834433",
                            "attributes":
                            {
                                "u_name": "Mark",
                                "age": 45
                            }
                        },
                        {
                            "phoneNumber":"13233834488",
                            "message": "Hi ${u_name}, the megic number is ${magic_number}",
                            "attributes":
                            {
                                "u_name": "Jane",
                                "magic_number": "10"
                            }
                        }
                    ],
                    "message":"Hello {u_name} ..."
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
