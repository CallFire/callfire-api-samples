<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findContactLists();
        $request->getOperationConfig()->setQueryParameters(array("name" => "my list",
                                                                 "offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(id,name,size)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
