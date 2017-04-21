<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request1 = $client->orderNumbers();
        $request1->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '{
                    "numbers":
                    [
                        "12131234567",
                        "12131234568"
                    ]
                 }';
        $request1->getOperationConfig()->setBodyParameter($body);
        $result1 = $client->request($request1);
        $json = json_decode($result1->getBody());

        $request2 = $client->orderNumbers();
        $request2->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '{
                    "localCount":"2",
                    "zipcode":"90401"
                 }';
        $request2->getOperationConfig()->setBodyParameter($body);
        $result2 = $client->request($request2);
        $json = json_decode($result2->getBody());
    }
}

ApiClientSample::main();
