import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.TextBroadcastStats;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ApiClientSample {
    public static void main(String[] args) throws ParseException {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-09-13 15:50:17");
        Date begin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-09-13 15:50:17");
        // limit returned fields if needed
        String fields = "totalOutboundCount,billedAmount,sentCount";
        TextBroadcastStats stats = client.textBroadcastsApi().getStats(11646003L, fields, begin, end);
    }
}
