import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.account.model.CreditsUsage;
import com.callfire.api.client.api.account.model.request.DateIntervalRequest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        Date begin = new GregorianCalendar(2037, Calendar.DECEMBER, 31, 20, 53, 20).getTime();
        Date end = new GregorianCalendar(2038, Calendar.JANUARY, 1, 8, 0, 0).getTime();
        DateIntervalRequest request = DateIntervalRequest.create()
            .intervalBegin(begin)
            .intervalEnd(end)
            .build();
        CreditsUsage creditsUsage = callfireClient.meApi().getCreditUsage(request);
    }
}

