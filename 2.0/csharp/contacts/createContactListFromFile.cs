using System.IO;
using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        var path = "/contacts.csv";
        ResourceId listId = client.ContactListsApi.CreateFromCsv("My Contact List", Path.GetFullPath(path));
    }
}
