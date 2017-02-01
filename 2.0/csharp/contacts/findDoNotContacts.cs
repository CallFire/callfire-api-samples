using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Contacts.Model;
using CallfireApiClient.Api.Contacts.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new FindDncNumbersRequest()
        {
            // search only Do-Not-Text numbers
            Text = true,
            // search numbers starting 1-(424)
            Prefix = "1424",
            // limit response to 10 entries
            Limit = 10
        };
        Page<DoNotContact> dncs = client.DncApi.Find(request);
    }
}
