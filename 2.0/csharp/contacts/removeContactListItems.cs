using System.Collections.Generic;
using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        client.ContactListsApi.RemoveListItems(123456, new List<long> {30344411, 30355511});
    }
}
