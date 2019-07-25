package api;

import base.BaseTest;
import com.jayway.restassured.response.Response;
import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;


public class GuerillaMailApi extends BaseTest {


    private static final String API = "http://api.guerrillamail.com/ajax.php";

    public String genereateMail(String email_user) {
        Response response = given().relaxedHTTPSValidation()
                .queryParam("f", "set_email_user")
                .queryParam("email_user", email_user)
                .queryParam("lang", "en")
                .get(API);
        Assert.assertEquals(response.getStatusCode(), 200, "Incorrect status code: " + response.asString());
        return response.jsonPath().getString("email_addr");
    }

    public String getEmailAddress() {
        Response response = given().relaxedHTTPSValidation()
                .queryParam("f", "get_email_address")
                .queryParam("lang", "en")
                .get(API);
        Assert.assertEquals(response.getStatusCode(), 200, "Incorrect status code: " + response.asString());
       return response.jsonPath().getString("email_addr");
    }







}
