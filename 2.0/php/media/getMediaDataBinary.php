<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getMediaDataBinary();
        $request->getOperationConfig()->setPathParameters(array("id" => 324324455432));
        $result = $client->request($request);
    }
}

ApiClientSample::main();
