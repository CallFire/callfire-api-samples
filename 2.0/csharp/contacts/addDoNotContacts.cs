using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        CreateDncsRequest request = new CreateDncsRequest()
        {
        // prohibit dialing to given phone numbers
            Call = true,
            // prohibit texting to given phone numbers
            Text = true,
            // the list of phone numbers
            Numbers = new List<string> { "12135551188", "12135771124" },
            // optional the name of the source
            Source = "My DNCs List 1"
        };
        client.DncApi.Create(request);
    }
}
