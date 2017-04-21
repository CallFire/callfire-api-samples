using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new UpdateContactListRequest
        {
            Id = 11646003,
            Name = "contact list updated"
        };
        client.ContactListsApi.Update(request);
    }
}
