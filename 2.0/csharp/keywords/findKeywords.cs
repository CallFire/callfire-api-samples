using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Keywords.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        List<string> keywords = new List<string> {"SUN", "MOON"};
        IList<Keyword> avaialbeKeywords = client.KeywordsApi.Find(keywords);
    }
}
