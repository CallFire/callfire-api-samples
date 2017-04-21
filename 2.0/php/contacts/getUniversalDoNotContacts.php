<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getUniversalDoNotContacts();
        $request->getOperationConfig()->setPathParameters(array("toNumber" => "12135551126"));
        $request->getOperationConfig()->setQueryParameters(array("fromNumber" => "12130021127",
                                                                 "fields" => "toNumber,inboundCall,outboundCall"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
