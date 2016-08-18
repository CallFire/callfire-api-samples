using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model;
using CallfireApiClient.Api.Contacts.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        // this sample shows how add contacts to existing list from 3 different 
        // sources: list of numbers, list of existing contact IDs, list of contact objects
        var request1 = new AddContactListContactsRequest<string>
        {
            Contacts = new List<string> {"12135678881", "12135678882"},
            ContactListId = 123456
        };
        client.ContactListsApi.AddListItems(request1);

        var request2 = new AddContactListContactsRequest<long>
        {
            Contacts = new List<long> {123, 456, 789},
            ContactListId = 123456
        };
        client.ContactListsApi.AddListItems(request2);

        var request3 = new AddContactListContactsRequest<Contact>
        {
            Contacts = new List<Contact> {new Contact {FirstName = "John", HomePhone = "16505044730"}},
            ContactListId = 123456
        };
        client.ContactListsApi.AddListItems(request3);
    }
}
