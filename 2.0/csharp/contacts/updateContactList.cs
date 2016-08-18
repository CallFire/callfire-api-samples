using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new UpdateContactListRequest
        {
            Id = 1026694003,
            Name = "new name"
        };
        client.ContactListsApi.Update(request);
    }
}
