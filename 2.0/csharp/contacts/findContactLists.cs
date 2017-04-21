using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Contacts.Model;
using CallfireApiClient.Api.Contacts.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        var request = new FindContactListsRequest
        {
            Name = "my list",
            Offset = 0,
            Limit = 10,
            Fields = "items(id,name,size)"
        };
        Page<ContactList> contactLists = client.ContactListsApi.Find(request);
    }
}
