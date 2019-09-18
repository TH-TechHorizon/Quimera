package test.api.core;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.api.core.TestCoreCentralizer;


/**	Chamdas requests padrões, POSTs e GETs, novos poderão ser acrescentados! **/
public class TestRequest extends TestCoreCentralizer{

	private TestRequest() {
        // Static class
    }

    public enum HttpMethod {
        POST, GET, PUT, DELETE, PATCH
    }

    /**
     * Request do tipo POST, para requisições que NECESSITEM de uma validação HTTPS.
     **/
    public static Response request(HttpMethod httpMethod, String bearer, Object body, String url) {
        return TestRequest.request(httpMethod, false, bearer, body, url);
    }

    /**
     * Request do tipo POST, para requisições que NECESSITEM de uma validação HTTPS.
     **/
    public static Response request(final HttpMethod httpMethod, final boolean https, final String bearer, final Object body, final String URL) {
    	logInfo(" Body a enviar: " + body);
        String contenttype = "application/json; charset=UTF-8";
        RequestSpecification requestSpecification = given();
        if (!https) {
            requestSpecification = requestSpecification.relaxedHTTPSValidation();
        }
        if (bearer != null && !bearer.isEmpty()) {
            requestSpecification = requestSpecification.headers("Authorization", bearer);
        }
        Response response = null;
        if (httpMethod == HttpMethod.POST) {
            response = requestSpecification.contentType(contenttype).when().body(body).post(URL).then().extract().response();
        } else if (httpMethod == HttpMethod.GET) {
            response = requestSpecification.contentType(contenttype).when().body(body).get(URL).then().extract().response();
        } else if (httpMethod == HttpMethod.PUT) {
            response = requestSpecification.contentType(contenttype).when().body(body).put(URL).then().extract().response();
        } else if (httpMethod == HttpMethod.DELETE) {
            response = requestSpecification.contentType(contenttype).when().body(body).delete(URL).then().extract().response();
        } else if (httpMethod == HttpMethod.PATCH) {
            response = requestSpecification.contentType(contenttype).when().body(body).patch(URL).then().extract().response();
        }
        logResponse(response);
        return response;
    }

}