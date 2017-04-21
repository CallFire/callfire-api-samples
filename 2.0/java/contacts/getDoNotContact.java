import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.DoNotContact;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        DoNotContact dnc = client.dncApi().get("12135551126");
    }
}
