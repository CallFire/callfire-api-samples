using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Common.Model.Request;
using CallfireApiClient.Api.Numbers.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new CommonFindRequest {Limit = 2, Offset = 1};
        IList<Number> numbers = client.NumbersApi.FindNumbersTollfree(request);
    }
}
