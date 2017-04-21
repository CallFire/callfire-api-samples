using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Numbers.Model;
using CallfireApiClient.Api.Numbers.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new FindNumberLeaseConfigsRequest()
        {
            Prefix = "14245",
            City = "Los Angeles",
            State = "CA",
            Zipcode = "90940",
            Lata = "123",
            RateCenter = "123",
            LabelName = "my label",
            Offset = 0,
            Limit = 10,
            Fields = "items(number,configType)"
        };
        Page<NumberConfig> configs = client.NumberLeasesApi.FindConfigs(request);
    }
}
