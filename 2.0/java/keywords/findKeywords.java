import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.keywords.model.Keyword;

import java.util.Arrays;
import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        List<Keyword> keywords = client.keywordsApi().find(Arrays.asList("KEYWORD1", "KEYWORD2"));
    }
}
