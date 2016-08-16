import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CampaignSound;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Long id = 12345L;
        // use second argument to limit returned fields
        CampaignSound campaignSound = client.campaignSoundsApi().get(id, "name,status,lengthInSeconds");
    }
}
