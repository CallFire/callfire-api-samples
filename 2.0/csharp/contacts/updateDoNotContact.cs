using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        UpdateDncRequest request = new UpdateDncRequest()
        {
            // prohibit dialing to phone number
            Call = true,
            // allow text messaging
            Text = false,
            Number = "12135551188"
        };
        client.DncApi.Update(request);
    }
}
