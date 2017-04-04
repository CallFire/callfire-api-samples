<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findContacts();
        $request->getOperationConfig()->setQueryParameters(array("limit" => 1,
                                                                 "offset" => 5,
                                                                 "id" => 463633187003,
                                                                 "id" => 466225637003));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
