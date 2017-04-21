<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request1 = $client->addContactListItems();
        $request1->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $request1->getOperationConfig()->setPathParameters(array("id" => 45006708003));
        $body = '{
                    "contacts":
                    [
                        {
                            "firstName":"Alice",
                            "lastName":"Moore",
                            "homePhone":"12135551126"
                        },
                        {
                            "firstName":"Bob",
                            "lastName":"Smith",
                            "homePhone":"12135551127",
                            "properties":
                            {
                                "age":30
                            }
                        }
                    ]
                 }';
        $request1->getOperationConfig()->setBodyParameter($body);
        $result1 = $client->request($request1);
        $json = json_decode($result1->getBody());

        $request2 = $client->addContactListItems();
        $request2->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $request2->getOperationConfig()->setPathParameters(array("id" => 45006708003));
        $body = '{
                    "contactIds":
                    [
                        800634185003,
                        800734186003,
                        800834187003,
                        800984185003
                    ]
                 }';
        $request2->getOperationConfig()->setBodyParameter($body);
        $result2 = $client->request($request2);
        $json = json_decode($result2->getBody());

        $request3 = $client->addContactListItems();
        $request3->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $request3->getOperationConfig()->setPathParameters(array("id" => 45006708003));
        $body = '{
                    "contactNumbers":
                    [
                        "12132212384",
                        "12136612355",
                        "12133312300"
                    ],
                    "contactNumbersField":"workPhone"
                 }';
        $request3->getOperationConfig()->setBodyParameter($body);
        $result3 = $client->request($request3);
        $json = json_decode($result3->getBody());
    }
}

ApiClientSample::main();
