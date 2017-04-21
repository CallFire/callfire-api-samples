import java.util.Arrays;

import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.contacts.model.DoNotContact;
import com.callfire.api.client.api.contacts.model.request.FindDncNumbersRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        FindDncNumbersRequest request = FindDncNumbersRequest.create()
                .prefix("1424")
                .numbers(Arrays.asList("12135551126", "12136666123"))
                .campaignId(11646003L)
                .source("my source")
                .call(true)
                .text(true)
                .offset(0L)
                .limit(10L)
                .fields("items(number,call)")
                .build();
        Page<DoNotContact> dncContacts = client.dncApi().find(request);
    }
}

