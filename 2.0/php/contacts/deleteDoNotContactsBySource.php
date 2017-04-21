<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->deleteDoNotContactsBySource();
        $request->getOperationConfig()->setPathParameters(array("source" => "My DNC List 1"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
