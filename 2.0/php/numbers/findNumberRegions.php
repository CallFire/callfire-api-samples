<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findNumberRegions();
        $request->getOperationConfig()->setQueryParameters(array("prefix" => "14245",
                                                                 "city" => "Los Angeles",
                                                                 "state" => "CA",
                                                                 "zipcode" => "90940",
                                                                 "lata" => "123",
                                                                 "rateCenter" => "123",
                                                                 "offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(number,nationalFormat,leaseBegin,leaseEnd,region/city)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
