<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findCampaignSounds();
        $request->getOperationConfig()->setQueryParameters(array("filter" => "name",
                                                                 "includeArchived" => true,
                                                                 "includePending" => true,
                                                                 "includeScrubbed" => true,
                                                                 "offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(id,name,callback)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
