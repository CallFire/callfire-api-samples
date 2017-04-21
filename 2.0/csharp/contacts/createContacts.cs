using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Contacts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        var contact1 = new Contact
        {
            FirstName = "Alice",
            LastName = "Moore",
            HomePhone = "12135551126",
            MobilePhone = "12136666123",
            WorkPhone = "14553327789",
            Zipcode = "40460",
            Properties = new Dictionary<string, string>
            {
                {"custom_ext_system_id", "100200301"}
            }
        };

        var contact2 = new Contact
        {
            FirstName = "Bob",
            LastName = "Smith",
            HomePhone = "12135551127",
            Properties = new Dictionary<string, string>
            {
                {"age", "30"},
                {"custom_position", "Manager"}
            }
        };

        IList<ResourceId> contacts = client.ContactsApi.Create(new List<Contact> { contact1, contact2 });
    }
}
