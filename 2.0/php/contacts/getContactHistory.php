<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getContactHistory();
        $request->getOperationConfig()->setPathParameters(array("id" => 379506003,
                                                                "offset" => 0,
                                                                "limit" => 10,
                                                                "fields" => "calls/fromNumber,calls/toNumber,texts/message"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
