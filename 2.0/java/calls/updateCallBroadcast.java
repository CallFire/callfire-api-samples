import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallBroadcast;
import com.callfire.api.client.api.campaigns.model.LocalTimeRestriction;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CallBroadcast broadcast = client.callBroadcastsApi().get(123L);
        // time restrictions
        LocalTimeRestriction restrictions = new LocalTimeRestriction();
        restrictions.setBeginHour(10);
        restrictions.setBeginMinute(10);
        restrictions.setEndHour(22);
        restrictions.setEndMinute(0);
        restrictions.setEnabled(true);
        broadcast.setLocalTimeRestriction(restrictions);
        // update campaign
        client.callBroadcastsApi().update(broadcast);
    }
}
