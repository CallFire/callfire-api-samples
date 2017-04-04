<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->createMedia();
        $request->getOperationConfig()->setFileUpload(__dir__.'\media.mp3', 'Test Media');
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
