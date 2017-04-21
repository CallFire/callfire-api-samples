<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findTextBroadcasts();
        $request->getOperationConfig()->setQueryParameters(array("name" => "broadcast name",
                                                                 "label" => "my label",
                                                                 "running" => true,
                                                                 "offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(id,name,status,message)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
