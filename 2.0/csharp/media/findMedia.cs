using System;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;
using CallfireApiClient.Api.CallsTexts.Model.Request;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        var request = new FindMediaRequest
        {
            Filter = "image1.jpeg"
        };

        Page<Media> media = client.MediaApi.Find(request);
        // check media.Items for stored data
    }
}