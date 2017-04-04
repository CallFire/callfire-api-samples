<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->orderNumbers();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '{
                    "numbers":
                    [
                        "12131234567",
                        "12131234568"
                    ]
                }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());

        $request1 = $client->orderNumbers();
        $request1->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '{
                    "localCount":"2",
                    "zipcode":"90401"
                }';
        $request1->getOperationConfig()->setBodyParameter($body);
        $result1 = $client->request($request1);
        $json = json_decode($result1->getBody());
    }
}

ApiClientSample::main();
