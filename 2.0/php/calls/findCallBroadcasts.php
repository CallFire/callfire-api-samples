<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findCallBroadcasts();
        $queryParameters = array('name' => 'campaign',
                                 'limit' => 2);
        $request->getOperationConfig()->setQueryParameters($queryParameters);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();



