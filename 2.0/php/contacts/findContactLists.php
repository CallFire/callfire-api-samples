<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findContactLists();
        $request->getOperationConfig()->setQueryParameters(array("limit" => 1,
                                                                 "offset" => 1,
                                                                 "name" => "listName"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
