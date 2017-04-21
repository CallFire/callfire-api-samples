<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findCallBroadcasts();
        $queryParameters = array('name' => 'broadcast name',
                                 'label' => 'my label',
                                 'running' => true,
                                 'offset' => 10,
                                 'limit' => 10,
                                 'fields' => "items(id,name,status,sounds)");
        $request->getOperationConfig()->setQueryParameters($queryParameters);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
