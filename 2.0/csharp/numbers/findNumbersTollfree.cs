using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Numbers.Model;
using CallfireApiClient.Api.Numbers.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new FindTollfreeNumbersRequest
        {
            Pattern = "87*",
            Limit = 10,
            Fields = "number"
        };
        IList<Number> numbers = client.NumbersApi.FindNumbersTollfree(request);
    }
}
