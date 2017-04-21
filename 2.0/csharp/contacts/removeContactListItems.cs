using System.Collections.Generic;
using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        client.ContactListsApi.RemoveListItems(11646003, new List<long> {22277003, 23377003});
    }
}
