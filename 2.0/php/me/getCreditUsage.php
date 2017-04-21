<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("account_login", "account_password");
        $request = $client->getCreditUsage();
        $request->getOperationConfig()->setQueryParameters(array("intervalBegin" => 2145905600000,
                                                                 "intervalEnd" => 2145945600000));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
