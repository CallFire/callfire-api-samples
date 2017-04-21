<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findDoNotContacts();
        $request->getOperationConfig()->setQueryParameters(array("prefix" => "1424",
                                                                 "number" => "12135551126",
                                                                 "number" => "12136666123",
                                                                 "campaignId" => 11646003,
                                                                 "source" => "my source",
                                                                 "call" => true,
                                                                 "text" => true,
                                                                 "offset" => 0,
                                                                 "limit" => 10,
                                                                 "limit" => "items(number,call)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
