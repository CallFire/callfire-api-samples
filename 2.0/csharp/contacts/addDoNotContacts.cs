using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model.Request;
using System.Collections.Generic;

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
            Numbers = new List<string> {"12132000381", "12132000382", "12132000383"},
            // optional the name of the source
            Source = "My DNC list 1"
        };
        client.DncApi.Create(request);
    }
}
