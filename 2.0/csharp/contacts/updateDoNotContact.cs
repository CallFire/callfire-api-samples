using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        UpdateDncRequest request = new UpdateDncRequest()
        {
            Call = true,
            Text = false,
            Number = "12132000381"
        };
        client.DncApi.Update(request);
    }
}
