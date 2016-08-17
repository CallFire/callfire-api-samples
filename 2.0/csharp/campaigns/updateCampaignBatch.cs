using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var batch = client.BatchesApi.Get(1234);
        batch.Enabled = false;
        client.BatchesApi.Update(batch);
    }
}
