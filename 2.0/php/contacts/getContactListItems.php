<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getContactListItems();
        $request->getOperationConfig()->setPathParameters(array("id" => 379506003));
        $request->getOperationConfig()->setQueryParameters(array("offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(firstName,lastName,workPhone)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
