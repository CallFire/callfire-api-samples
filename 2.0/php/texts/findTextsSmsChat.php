<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findTexts();
        $request->getOperationConfig()->setQueryParameters(array("fromNumber" => "12135551100",
                                                                 "fields" => "items(id,message,created)",
                                                                 "intervalBegin" => 1473781817000,
                                                                 "intervalEnd" => 1473781917000,
                                                                 "limit" => 50,
                                                                 "offset" => 100));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
