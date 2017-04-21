import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.UniversalDnc;
import com.callfire.api.client.api.contacts.model.request.FindUniversalDncsRequest;

import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        FindUniversalDncsRequest request = FindUniversalDncsRequest.create()
            .toNumber("12135551126")
            .fromNumber("12130021127")
            .fields("toNumber,inboundCall,outboundCall")
            .build();
        List<UniversalDnc> universalDncs = client.dncApi().findUniversalDncs(request);
    }
}

