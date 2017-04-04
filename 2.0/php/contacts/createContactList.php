<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->createContactList();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '{
                    "name":"Created Contact List",
                    "contacts":
                    [
                        {
                            "firstName":"Carl",
                            "lastName":"Friar",
                            "homePhone":"12135551125"
                        }
                    ]
                }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
