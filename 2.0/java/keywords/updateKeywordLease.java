import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.keywords.model.KeywordLease;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        KeywordLease keywordLease = new KeywordLease();
        keywordLease.setKeyword("SUN");
        keywordLease.setAutoRenew(false);
        client.keywordLeasesApi().update(keywordLease);
    }
}
