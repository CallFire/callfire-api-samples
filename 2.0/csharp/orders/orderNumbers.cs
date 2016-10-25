using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Numbers.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        // request for buying particular numbers
        var request1 = new NumberPurchaseRequest
        {
            Numbers = new List<string> {"12131234567", "12131234568"}
        };
        ResourceId resourceId1 = client.OrdersApi.OrderNumbers(request1);

        // request for buying numbers in specific area
        var request2 = new NumberPurchaseRequest {Zipcode = "90401", LocalCount = 2};
        ResourceId resourceId2 = client.OrdersApi.OrderNumbers(request2);
    }
}
