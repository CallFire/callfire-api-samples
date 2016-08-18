using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Numbers.Model;
using CallfireApiClient.Api.Numbers.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new FindNumbersLocalRequest {Limit = 2, State = "LA"};
        IList<Number> numbers = client.NumbersApi.FindNumbersLocal(request);
    }
}
