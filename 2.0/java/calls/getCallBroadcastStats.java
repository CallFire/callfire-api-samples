import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallBroadcastStats;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Date end = new GregorianCalendar(2016, Calendar.SEPTEMBER, 15, 50, 17, 0).getTime();
        Date begin = new GregorianCalendar(2016, Calendar.SEPTEMBER, 15, 50, 17, 0).getTime();
        // limit returned fields if needed
        String fields = "totalOutboundCount,billedAmount,callsAttempted";
        CallBroadcastStats stats = client.callBroadcastsApi().getStats(11646003L, fields, begin, end);
    }
}
