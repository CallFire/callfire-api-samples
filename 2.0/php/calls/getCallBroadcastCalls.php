<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCallBroadcastCalls();
        $request->getOperationConfig()->setPathParameters(array("id" => 617063450003));
        $request->getOperationConfig()->setQueryParameters(array("batchId" => 1233412324,
                                                                 "limit" => 5));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
