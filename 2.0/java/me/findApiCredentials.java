import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.account.model.ApiCredentials;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.common.model.request.CommonFindRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("account_login", "account_password");
        CommonFindRequest request = CommonFindRequest.create()
            .limit(2L)
            .build();
        Page<ApiCredentials> credentials = callfireClient.meApi().findApiCredentials(request);
    }
}
