using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Common.Model.Request;
using CallfireApiClient.Api.Contacts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new GetByIdRequest
        {
            Id = 379506003,
            Offset = 0,
            Limit = 10,
            Fields = "items(firstName,lastName,workPhone)"
        };
        Page<Contact> contacts = client.ContactListsApi.GetListItems(request);
    }
}

