import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class TestHttp {

    public static final String BASE_URL = "https://reqres.in";
    public static final String POST_USER = "/api/users/";
    public static final String GET_USER_PARAM = "?page=2";
    public static final String REQUEST_BODY = "{\n" +
            "  \"name\": \"morpheus\",\n" +
            "  \"job\": \"leader\" \n}";
    public static final String REQUEST_BODY_PUT = "{\n" +
            "  \"name\": \"morpheus\",\n" +
            "  \"job\": \"zion resident\" \n}";
    public static final String USER_ID = "2";


    @Test
    public void getList() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_URL + POST_USER + GET_USER_PARAM);
        HttpResponse response = HttpClientBuilder.create().build().execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    }

    @Test
    public void postCreate() throws IOException {

        HttpPost request = new HttpPost(BASE_URL + POST_USER);
        request.setHeader("Content-type", "application/json");
        request.setEntity(new StringEntity(REQUEST_BODY));
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusLine().getStatusCode());
    }

    @Test
    public void putList() throws IOException {
        HttpPut request = new HttpPut(BASE_URL + POST_USER);
        request.setHeader("Content-type", "application/json");
        request.setEntity(new StringEntity(REQUEST_BODY_PUT));
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    }

    @Test
    public void deleteList() throws IOException {
        HttpDelete request = new HttpDelete(BASE_URL + POST_USER + USER_ID);
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusLine().getStatusCode());
    }
}


