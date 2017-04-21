<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getMedia();
        $request->getOperationConfig()->setPathParameters(array("id" => 379506003));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "name,publicUrl"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();

