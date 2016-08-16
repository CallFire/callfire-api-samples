import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.numbers.model.CallTrackingConfig;
import com.callfire.api.client.api.numbers.model.NumberConfig;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        NumberConfig config = new NumberConfig();
        config.setNumber("16502572135");
        config.setConfigType(NumberConfig.ConfigType.TRACKING);
        // create call tracking config
        CallTrackingConfig callTrackingConfig = new CallTrackingConfig();
        callTrackingConfig.setScreen(true);
        callTrackingConfig.setRecorded(true);
        callTrackingConfig.setTransferNumbers(Arrays.asList("16502572136", "16502572137"));
        config.setCallTrackingConfig(callTrackingConfig);
        // update number lease
        client.numberLeasesApi().updateConfig(config);
    }
}
