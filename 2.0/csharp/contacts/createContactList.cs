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

        // this sample shows how add create contact list from 3 different
        // sources: list of numbers, list of existing contact IDs, list of contact objects
        var request1 = new CreateContactListRequest<string>
        {
            Contacts = new List<string> {"12135678881", "12135678882"},
            Name = "listFromNumbers"
        };
        ResourceId resourceId1 = client.ContactListsApi.Create(request1);

        var request2 = new CreateContactListRequest<long>
        {
            Contacts = new List<long> {123, 456, 789},
            Name = "listFromIds"
        };
        ResourceId resourceId2 = client.ContactListsApi.Create(request2);

        var request3 = new CreateContactListRequest<Contact>
        {
            Contacts = new List<Contact> {new Contact {FirstName = "John", HomePhone = "16505044730"}},
            Name = "listFromContacts"
        };
        ResourceId resourceId3 = client.ContactListsApi.Create(request3);
    }
}
