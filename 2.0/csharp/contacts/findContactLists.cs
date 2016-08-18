using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Contacts.Model;
using CallfireApiClient.Api.Contacts.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        var request = new FindContactListsRequest {Limit = 1, Offset = 0};
        Page<ContactList> contactLists = client.ContactListsApi.Find(request);
    }
}
