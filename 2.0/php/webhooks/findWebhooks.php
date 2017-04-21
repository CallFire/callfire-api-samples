<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findWebhooks();
        $request->getOperationConfig()->setQueryParameters(array("name" => "my webhook",
                                                                 "resource" => "TextBroadcast",
                                                                 "event" => "Started",
                                                                 "callback" => "https://myservice/callback",
                                                                 "enabled" => true,
                                                                 "offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(id,name,callback)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
