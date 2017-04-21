<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCallBroadcastCalls();
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003));
        $request->getOperationConfig()->setQueryParameters(array("batchId" => 5500030002,
                                                                 "offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(fromNumber,toNumber,state,modified)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}
