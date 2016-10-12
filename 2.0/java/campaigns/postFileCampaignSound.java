import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CampaignSound;

import java.io.File;
import java.net.URISyntaxException;

class ApiClientSample {
    public static void main(String[] args) throws URISyntaxException {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        File mp3File = new File(ApiClientSample.class.getClassLoader().getResource("/path/to/sound.mp3").toURI());
        CampaignSound mp3Sound = client.campaignSoundsApi().uploadAndGetSoundDetails(mp3File, "Sound 1");
    }
}
