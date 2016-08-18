using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        Contact contact = client.ContactsApi.Get(463633187003);
    }
}
