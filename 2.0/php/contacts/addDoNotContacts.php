<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->addDoNotContacts();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '{
                    "source": "My DNC list 1",
                    "call": true,
                    "text": true,
                    "numbers": ["12132000381", "12132000382", "12132000383"]
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
