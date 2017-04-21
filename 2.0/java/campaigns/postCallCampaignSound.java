import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallCreateSound;
import com.callfire.api.client.api.common.model.ResourceId;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        CallCreateSound callCreateSound = new CallCreateSound();
        callCreateSound.setName("Sound 1");
        callCreateSound.setToNumber("12135551122");
        ResourceId resourceId = callfireClient.campaignSoundsApi().recordViaPhone(callCreateSound);
    }
}
