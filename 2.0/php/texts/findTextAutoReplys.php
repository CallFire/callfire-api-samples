<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findTextAutoReplys();
        $request->getOperationConfig()->setQueryParameters(array("number" => "12132000384",
                                                                 "offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(id,match,keyword,message)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
