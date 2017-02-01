using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model;
using CallfireApiClient.Api.Contacts.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        FindUniversalDncsRequest request = new FindUniversalDncsRequest()
        {
            // find all universal DNCs which prohibit from contacting toNumber
            ToNumber = "12135551188"
        };
        IList<UniversalDnc> universalDncs = client.DncApi.FindUniversalDncs(request);
    }
}
