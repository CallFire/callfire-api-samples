import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.keywords.model.KeywordLease;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        KeywordLease keywordLease = new KeywordLease();
        keywordLease.setKeyword("CALLFIRE");
        keywordLease.setAutoRenew(true);
        client.keywordLeasesApi().update(keywordLease);
    }
}
