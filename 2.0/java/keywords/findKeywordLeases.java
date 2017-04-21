import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.common.model.request.CommonFindRequest;
import com.callfire.api.client.api.keywords.model.KeywordLease;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CommonFindRequest request = CommonFindRequest.create()
            .offset(0L)
            .limit(10L)
            .fields("items(keyword,leaseBegin,leaseEnd)")
            .build();
        Page<KeywordLease> leases = client.keywordLeasesApi().find(request);
    }
}

