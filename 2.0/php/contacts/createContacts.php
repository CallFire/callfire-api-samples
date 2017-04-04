<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->createContacts();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '[
                    {
                        "firstName":"Alice",
                        "lastName":"Moore",
                        "homePhone":"12135551124",
                        "mobilePhone":"12136666123",
                        "workPhone":"14553327789",
                        "zipcode":"40460",
                        "properties":
                        {
                            "custom_age":30,
                            "custom_position":"Manager"
                        }
                    },
                    {
                        "firstName":"Bob",
                        "lastName":"Smith",
                        "homePhone":"17885551111",
                        "mobilePhone":"17886666122",
                        "workPhone":"17883327700",
                        "zipcode":"25600",
                        "properties":
                        {
                            "custom_ext_system_id":100200301
                        }
                    }
                ]';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
