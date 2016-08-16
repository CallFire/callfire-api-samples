import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CampaignSound;
import com.callfire.api.client.api.campaigns.model.request.FindSoundsRequest;
import com.callfire.api.client.api.common.model.Page;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        FindSoundsRequest request = FindSoundsRequest.create()
            .limit(3L)
            .filter("sample")
            .build();
        Page<CampaignSound> campaignSounds = callfireClient.campaignSoundsApi().find(request);
    }
}
