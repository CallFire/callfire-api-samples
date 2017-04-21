using CallfireApiClient;
using CallfireApiClient.Api.Common.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new GetByIdRequest
        {
            Id = 5500030002,
            Offset = 0,
            Limit = 10,
            Fields = "items(fromNumber,toNumber,state,message)"
        };
        var texts = client.TextBroadcastsApi.GetTexts(request);
    }
}
