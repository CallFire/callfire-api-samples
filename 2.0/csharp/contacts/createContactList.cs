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

        var request1 = new CreateContactListRequest<Contact>
        {
            Contacts = new List<Contact>
            {
                new Contact
                {
                    FirstName = "Alice",
                    LastName = "Moore",
                    HomePhone = "12135551126"
                },
                new Contact
                {
                    FirstName = "Bob",
                    LastName = "Smith",
                    HomePhone = "12135551127",
                    Properties = new Dictionary<string, string>
                    {
                        {"age", "30"}
                    }
                }
            },
            Name = "My Contact List"
        };
        ResourceId resourceId1 = client.ContactListsApi.Create(request1);

        var request2 = new CreateContactListRequest<string>
        {
            Contacts = new List<string> {"12132212384", "12136612355", "12133312300"},
            ContactNumbersField = "workPhone",
            Name = "My Contact List"
        };
        ResourceId resourceId2 = client.ContactListsApi.Create(request2);

        var request3 = new CreateContactListRequest<long>
        {
            Contacts = new List<long> {800634185003, 800734186003, 800834187003, 800984185003},
            Name = "My Contact List"
        };
        ResourceId resourceId3 = client.ContactListsApi.Create(request3);
    }
}
