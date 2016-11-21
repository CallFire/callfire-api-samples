import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.account.model.CreditsUsage;
import com.callfire.api.client.api.account.model.request.DateIntervalRequest;

import java.util.Calendar;
import java.util.Date;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        Calendar endDateCal = Calendar.getInstance();
        endDateCal.add(Calendar.MONTH, -3);
        DateIntervalRequest request = DateIntervalRequest.create()
            .intervalBegin(endDateCal.getTime())
            .intervalEnd(new Date())
            .build();
        CreditsUsage creditsUsage = callfireClient.meApi().getCreditUsage(request);
    }
}
