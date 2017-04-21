<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getTextBroadcastStats();
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "totalOutboundCount,billedAmount,sentCount",
                                                                 "begin" => 1473781817000,
                                                                 "end" => 1473781817000));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
