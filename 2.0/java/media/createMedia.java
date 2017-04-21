import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.ResourceId;

import java.io.File;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        File file = new File("/image1.bmp");
        // second argument is filename, in case you don't specify it filename will be taken from the path
        ResourceId id = client.mediaApi().upload(file, "test image");
    }
}

