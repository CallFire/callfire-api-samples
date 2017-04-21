using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var contact = new Contact
        {
            Id = 11646003,
            MobilePhone = "12136600123",
            WorkPhone = "14553320089"
        };
        client.ContactsApi.Update(contact);
    }
}
