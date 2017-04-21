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
            Id = new List<long> { 11646003, 12646003, 13776003 },
            Number = new List<string> { "12135551126", "12136666123" },
            ContactListId = 14400809003,
            PropertyName = "14400809003",
            PropertyValue = "14400809003",
            Offset = 0,
            Limit = 10,
            Fields = "items(id,name,size)"
        };
        Page<Contact> contacts = client.ContactsApi.Find(request);
    }
}
