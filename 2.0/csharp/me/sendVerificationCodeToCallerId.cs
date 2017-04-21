using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        const string phoneNumber = "12132000384";
        client.MeApi.SendVerificationCode(phoneNumber);
    }
}
