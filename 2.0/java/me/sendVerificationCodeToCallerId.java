import com.callfire.api.client.CallfireClient;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        String phoneNumber = "12132000384";
        callfireClient.meApi().sendVerificationCode(phoneNumber);
    }
}
