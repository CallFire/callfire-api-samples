using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Account.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        IList<CallerId> callerIds = client.MeApi.GetCallerIds();
    }
}
