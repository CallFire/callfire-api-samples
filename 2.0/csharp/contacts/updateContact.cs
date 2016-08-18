using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var contact = new Contact
        {
            Id = 463633187003,
            FirstName = "Alice",
            HomePhone = "16505044730",
            WorkPhone = "12305022730"
        };
        client.ContactsApi.Update(contact);
    }
}
