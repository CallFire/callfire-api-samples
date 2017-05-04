<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->createContacts();
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
                            "custom_ext_system_id":100200301
                        }
                    },
                    {
                        "firstName":"Bob",
                        "lastName":"Smith",
                        "homePhone":"12135551127",
                        "properties":
                        {
                            "custom_age":30,
                            "custom_position":"Manager"
                        }
                    }
                 ]';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}
