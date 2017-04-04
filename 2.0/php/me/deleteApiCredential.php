<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("account_login", "account_password");
        $request = $client->deleteApiCredential();
        $request->getOperationConfig()->setPathParameters(array("id" => 123456));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
