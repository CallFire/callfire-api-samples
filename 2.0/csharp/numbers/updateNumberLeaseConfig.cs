using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Numbers.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        // create new call tracking config
        var callTrackingConfig = new CallTrackingConfig
        {
            Screen = true,
            Recorded = true,
            TransferNumbers = new List<string> {"16502572136", "16502572137"}
        };
        NumberConfig config = new NumberConfig
        {
            Number = "16502572135",
            ConfigType = NumberConfig.NumberConfigType.TRACKING,
            CallTrackingConfig = callTrackingConfig
        };
        client.NumberLeasesApi.UpdateConfig(config);
    }
}
