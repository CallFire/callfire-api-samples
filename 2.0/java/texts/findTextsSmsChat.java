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
            .fromNumber("12135551100")
            .intervalBegin(new GregorianCalendar(2016, Calendar.SEPTEMBER, 9, 15, 50, 17).getTime())
            .intervalEnd(new GregorianCalendar(2016, Calendar.DECEMBER, 10, 0, 0, 0).getTime())
            .offset(100L)
            .limit(50L)
            .fields("items(id,message,created)")
            .build();
        Page<Text> texts = client.textsApi().find(request);
    }
}
