package quimera.test.core.request;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;


/**	
 * <b> Definição: </b> <br>
 * Esta classe funciona como um facilitador para as chamadas do RestAssured.io, contendo basicamente uma chamada padrão para os diversos tipos de requisição.
**/
public class TestRequest extends TestCoreCentralizer{

	private TestRequest(){}

    public enum HttpMethod { POST, GET, PUT, DELETE, PATCH }

    /**	
     * <b> Definição: </b> <br>
     * Retornar o resultado de uma requisição, onde a mesma NÃO necessita de uma validação https.
     * @param httpMethod [HttpMethod] = Recebe o Enum, exemplo HttpMethod.POST para informar o tipo de requisição.
     * @param bearer [String] = Deverá receber o Token do tipo bearer, caso não possua deverá ser informado null ou apenas aspas duplas "".
     * @param body [Object] = Recebe o body do payload, Json ou uma classe. Caso informado uma classe a mesma será convertida para Json.
     * @param url [String] =  Deve receber a url da requisição.
     * @return Retorna um Response com a resposta da requisição.
    **/
    public static Response request(HttpMethod httpMethod, String bearer, Object body, String url) {
        return TestRequest.request(httpMethod, false, bearer, body, url);
    }

    /**	
     * <b> Definição: </b> <br>
     * Retornar o resultado de uma requisição, onde a mesma PODE vir a necessitar de uma validação https.
     * @param httpMethod (HttpMethod) = Recebe o Enum, exemplo HttpMethod.POST para informar o tipo de requisição.
     * @param https (boolean) = Deverá receber True para uma requisição que necessite validação https ou False para não validar o https. <br> Por padrão caso não informado, a requisição será false.
     * @param bearer (String) = Deverá receber o Token do tipo bearer, caso não possua deverá ser informado null ou apenas aspas duplas "".
     * @param body (Object) = Recebe o body do payload, Json ou uma classe. Caso informado uma classe a mesma será convertida para Json.
     * @param URL (String) =  Deve receber a url da requisição.
     * @return Retorna um Response com a resposta da requicição.
    **/
    public static Response request(final HttpMethod httpMethod, final boolean https, final String bearer, final Object body, final String URL) {
    	TestLogger.logInfo(" Body a enviar: " + body);
        String contenttype = "application/json; charset=UTF-8";
        String finalBody = "";
        RequestSpecification requestSpecification = given();
        if (body != null) {
        	finalBody = encodeJsonBody(body);
        }
        if (!https) {
            requestSpecification = requestSpecification.relaxedHTTPSValidation();
        }
        if (bearer != null && !bearer.isEmpty()) {
            requestSpecification = requestSpecification.headers("Authorization", bearer);
        }
        Response response = null;
        if (httpMethod == HttpMethod.POST) {
            response = requestSpecification.contentType(contenttype).when().body(finalBody).post(URL).then().extract().response();
        } else if (httpMethod == HttpMethod.GET) {
            response = requestSpecification.contentType(contenttype).when().body(finalBody).get(URL).then().extract().response();
        } else if (httpMethod == HttpMethod.PUT) {
            response = requestSpecification.contentType(contenttype).when().body(finalBody).put(URL).then().extract().response();
        } else if (httpMethod == HttpMethod.DELETE) {
            response = requestSpecification.contentType(contenttype).when().body(finalBody).delete(URL).then().extract().response();
        } else if (httpMethod == HttpMethod.PATCH) {
            response = requestSpecification.contentType(contenttype).when().body(finalBody).patch(URL).then().extract().response();
        }
        TestLogger.logResponse(response);
        return response;
    }

}