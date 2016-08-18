using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Contacts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        var contact = new Contact
        {
            HomePhone = "16505044730",
            FirstName = "John",
            LastName = "Doe",
            Properties = new Dictionary<string, string>
            {
                {"age", "30"},
                {"customFieldN", "customValue"}
            }
        };
        IList<ResourceId> contacts = client.ContactsApi.Create(new List<Contact> {contact});
    }
}
