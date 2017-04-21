<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findNumbersTollfree();
        $request->getOperationConfig()->setQueryParameters(array("pattern" => "87*",
                                                                 "limit" => 10,
                                                                 "fields" => "number"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();

