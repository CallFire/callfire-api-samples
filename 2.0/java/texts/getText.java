import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Text text = client.textsApi().get(379506003L, "fromNumber,toNumber,modified,finalTextResult");
    }
}
