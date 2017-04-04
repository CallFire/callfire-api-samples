<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getWebhook();
        $request->getOperationConfig()->setPathParameters(array("id" => 12345678));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "id,name,created"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();

