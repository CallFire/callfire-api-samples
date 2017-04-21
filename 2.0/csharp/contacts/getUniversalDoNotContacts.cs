using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model;
using CallfireApiClient.Api.Contacts.Model.Request;
using System.Collections.Generic;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        FindUniversalDncsRequest request = new FindUniversalDncsRequest()
        {
            ToNumber = "12135551126",
            FromNumber = "12130021127",
            Fields = "toNumber,inboundCall,outboundCall"
        };
        IList<UniversalDnc> universalDncs = client.DncApi.FindUniversalDncs(request);
    }
}
