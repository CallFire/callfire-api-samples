import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.account.model.CallerId;

import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        List<CallerId> callerIds = callfireClient.meApi().getCallerIds();
    }
}
