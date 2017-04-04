<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCallBroadcastStats();
        $request->getOperationConfig()->setPathParameters(array("id" => 617063450003));
        $request->getOperationConfig()->setQueryParameters(array("begin" => 1448920800000,
                                                                 "end" => 1449698400000));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
