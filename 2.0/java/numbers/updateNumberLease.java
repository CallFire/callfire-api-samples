import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.numbers.model.NumberLease;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        NumberLease lease = new NumberLease();
        lease.setNumber("16502572135");
        lease.setAutoRenew(true);
        client.numberLeasesApi().update(lease);
    }
}
