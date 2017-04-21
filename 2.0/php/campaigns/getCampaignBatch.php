<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCampaignBatch();
        $request->getOperationConfig()->setPathParameters(array("id" => 379506003));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "name,status,size"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
