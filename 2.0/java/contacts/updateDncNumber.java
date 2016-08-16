import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.DoNotContact;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        DoNotContact dnc = new DoNotContact();
        dnc.setCall(true);
        dnc.setListId(1975140003L);
        dnc.setNumber("12563505052");
        dnc.setText(true);
        client.dncApi().update(dnc);
    }
}
