<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findKeywords();
        $request->getOperationConfig()->setQueryParameters(array("keywords" => "SUN",
                                                                 "keywords" => "MOON"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();

