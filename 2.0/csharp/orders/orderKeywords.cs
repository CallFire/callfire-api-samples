using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Keywords.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new KeywordPurchaseRequest {Keywords = {"SUN", "MOON"}};
        ResourceId resourceId = client.OrdersApi.OrderKeywords(request);
    }
}
