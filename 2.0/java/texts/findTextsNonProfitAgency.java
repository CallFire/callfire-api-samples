package com.callfire.api.client.integration;

import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.callstexts.model.request.FindTextsRequest;
import com.callfire.api.client.api.common.model.Page;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");

        FindTextsRequest request = FindTextsRequest.create()
            // find messages sent from particular campaign or replies.
            .campaignId(7415225003L)
            // find only inbound messages
            .inbound(true)
            .build();
        Page<Text> texts = client.textsApi().find(request);
    }
}

