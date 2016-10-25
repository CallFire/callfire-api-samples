import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;
import com.callfire.api.client.api.callstexts.model.request.FindCallsRequest;
import com.callfire.api.client.api.common.model.Page;

import java.util.Calendar;
import java.util.GregorianCalendar;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        // find all calls made through campaign with id = 10, label = reminders is assigned to such campaign,
        // between 2015-12-01 and 2015-12-10, return first 10 records if any
        FindCallsRequest request = FindCallsRequest.create()
            .campaignId(10L)
            .label("reminders")
            .intervalBegin(new GregorianCalendar(2015, Calendar.DECEMBER, 1, 0, 0, 0).getTime())
            .intervalEnd(new GregorianCalendar(2015, Calendar.DECEMBER, 10, 0, 0, 0).getTime())
            .limit(10L)
            .build();
        Page<Call> calls = client.callsApi().find(request);
        // see Call.records.questionResponses list for stored data
    }
}
