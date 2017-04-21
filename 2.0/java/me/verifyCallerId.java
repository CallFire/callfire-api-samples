import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.account.model.request.CallerIdVerificationRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        String phoneNumber = "12132000384";
        CallerIdVerificationRequest request = CallerIdVerificationRequest.create()
            .callerId(phoneNumber)
            .verificationCode("1234")
            .build();
        Boolean verified = callfireClient.meApi().verifyCallerId(request);
    }
}
