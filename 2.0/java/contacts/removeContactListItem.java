import com.callfire.api.client.CallfireClient;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        client.contactListsApi().removeListItem(11646003L, 22277003L);
    }
}

