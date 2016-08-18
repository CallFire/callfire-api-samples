using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var dnc = new DoNotContact
        {
            ListId = 1975140003,
            Text = true,
            Call = true,
            Number = "12563505052"
        };
        client.DncApi.Update(dnc);
    }
}
