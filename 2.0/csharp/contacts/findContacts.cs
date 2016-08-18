using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Contacts.Model;
using CallfireApiClient.Api.Contacts.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        var request = new FindContactsRequest
        {
            Number = new List<string> {"16506190257", "18778973473"},
            Id = new List<long> {1, 2},
            Limit = 1,
            Offset = 0
        };
        Page<Contact> contacts = client.ContactsApi.Find(request);
    }
}
