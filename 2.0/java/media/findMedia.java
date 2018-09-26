import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Media;
import com.callfire.api.client.api.callstexts.model.request.FindMediaRequest;
import com.callfire.api.client.api.common.model.Page;

class ApiClientSample {
    public static void main(String[] args) throws ParseException {
        CallfireClient client = new CallfireClient("api_login", "api_password");

        FindMediaRequest request = FindMediaRequest.create()
                .filter("image1.jpeg")
                .build();

        Page<Media> media = client.mediaApi().find(request);
        // check media.getItems() list for stored data
    }
}