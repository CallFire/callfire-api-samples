<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findDoNotContacts();
        $request->getOperationConfig()->setQueryParameters(array("text" => true,
                                                                 "prefix" => "1424",
                                                                 "limit" => 10));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
