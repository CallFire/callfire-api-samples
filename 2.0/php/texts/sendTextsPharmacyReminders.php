<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->sendTexts();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '[
                    {
                        "phoneNumber":"12135551123",
                        "message":"Hello ${contact_name}, you have an appointment with Dr. Andrew tomorrow at 3:00 PM, if you need to reschedule please call (855)-555-4477",
                        "attributes":
                        {
                            "contact_name":"Alice",
                            "external_user_id":"45450007002"
                        }
                    }
                ]';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
