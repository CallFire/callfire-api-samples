<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findContacts();
        $request->getOperationConfig()->setQueryParameters(array("id" => 11646003,
                                                                 "id" => 12646003,
                                                                 "id" => 13776003,
                                                                 "number" => "12135551126",
                                                                 "number" => "12136666123",
                                                                 "contactListId" => 14400809003,
                                                                 "propertyName" => "14400809003",
                                                                 "propertyValue" => "14400809003",
                                                                 "offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(id,name,size)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
