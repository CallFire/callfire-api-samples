using CallfireApiClient;
using CallfireApiClient.Api.Common.Model.Request;
using CallfireApiClient.Api.Contacts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new GetByIdRequest
        {
            Id = 123456
        };
        ContactHistory contactHistory = client.ContactsApi.GetHistory(request);
    }
}
