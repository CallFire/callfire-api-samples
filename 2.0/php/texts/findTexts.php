<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findTexts();
        $request->getOperationConfig()->setQueryParameters(array("id" => 11646003,
                                                                 "id" => 12646003,
                                                                 "id" => 13776003,
                                                                 "campaignId" => 449060003,
                                                                 "batchId" => 447060003,
                                                                 "fromNumber" => "12135551126",
                                                                 "toNumber" => "12136666123",
                                                                 "label" => "my label",
                                                                 "states" => "READY,FINISHED,INVALID",
                                                                 "results" => "RECEIVED",
                                                                 "inbound" => true,
                                                                 "intervalBegin" => 1473781817000,
                                                                 "intervalEnd" => 1473781817000,
                                                                 "offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(id,fromNumber,toNumber,modified,message)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
