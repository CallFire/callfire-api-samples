<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCallBroadcastStats();
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003));
        $request->getOperationConfig()->setQueryParameters(array("begin" => 1473781817000,
                                                                 "end" => 1473781817000,
                                                                 "fields" => "totalOutboundCount,billedAmount,callsAttempted"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
