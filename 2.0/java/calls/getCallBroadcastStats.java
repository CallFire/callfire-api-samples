import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallBroadcastStats;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Date end = new Date();
        Date begin = DateUtils.addDays(end, -5);
        // limit returned fields if needed
        String fields = "callsAttempted,callsPlaced,callsDuration";
        CallBroadcastStats stats = client.callBroadcastsApi().getStats(8624192003L, fields, begin, end);
    }
}
