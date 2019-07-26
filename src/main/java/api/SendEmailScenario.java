package api;

import base.BaseTest;
import com.jayway.restassured.response.Response;
import enums.EmailKey;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.jayway.restassured.RestAssured.given;


public class SendEmailScenario extends BaseTest {


    private static final String API = "http://api.guerrillamail.com/ajax.php";

    protected Map<String, String> genereateMail(String email_user, String token) {
        Response response = given().relaxedHTTPSValidation().log().all()
                .queryParam("f", "set_email_user")
                .queryParam("email_user", email_user)
                .queryParam("sid_token", token)
                .queryParam("lang", "en")
                .get(API);
        Assert.assertEquals(response.getStatusCode(), 200, "Incorrect status code: " + response.asString());
        return new HashMap<String, String>() {{
            put(EmailKey.EMAIL.getLabel(), genereateDifferentEmailAndToken());
            put(EmailKey.SID_TOKEN.getLabel(), genereateDifferentEmailAndToken());
        }};
    }

    private String genereateDifferentEmailAndToken() {
        String email =
                RandomStringUtils.randomAlphanumeric(new Random().nextInt(10));
        return email;
    }

    protected String getEmailAddress() {
        Response response = given().relaxedHTTPSValidation().log().all()
                .queryParam("f", "get_email_address")
                .queryParam("lang", "en")
                .get(API);
        Assert.assertEquals(response.getStatusCode(), 200, "Incorrect status code: " + response.asString());
       return response.jsonPath().getString("email_addr");
    }







}
