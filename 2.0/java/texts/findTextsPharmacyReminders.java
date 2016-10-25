import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.callstexts.model.request.FindTextsRequest;
import com.callfire.api.client.api.common.model.Page;

import java.util.Calendar;
import java.util.GregorianCalendar;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindTextsRequest request = FindTextsRequest.create()
            .campaignId(13L)
            .label("reminders")
            .intervalBegin(new GregorianCalendar(2015, Calendar.DECEMBER, 1, 0, 0, 0).getTime())
            .intervalEnd(new GregorianCalendar(2015, Calendar.DECEMBER, 10, 0, 0, 0).getTime())
            .limit(10L)
            .build();
        Page<Text> texts = client.textsApi().find(request);
    }
}
