using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        ContactList contactList = client.ContactListsApi.Get(379506003, "id,name,size,created");
    }
}
