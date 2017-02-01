import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.UniversalDnc;
import com.callfire.api.client.api.contacts.model.request.FindUniversalDncsRequest;

import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        FindUniversalDncsRequest request = FindUniversalDncsRequest.create()
            // find all universal DNCs which prohibit from contacting toNumber
            .toNumber("12135551188")
            .build();
        List<UniversalDnc> universalDncs = client.dncApi().findUniversalDncs(request);
    }
}
