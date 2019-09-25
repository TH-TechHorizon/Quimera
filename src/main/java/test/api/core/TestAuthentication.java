package test.api.core;

import org.testng.Assert;

import io.restassured.response.Response;
import test.api.core.TestRequest.HttpMethod;

/**	
 * Classe com o objetivo de conter as informações de login na plataforma. A mesma poderá ser importada para manipulação das informações de login.
 * <br>
 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/TestAuthentication#testauthentication">Testauthentication</a>
**/
public class TestAuthentication extends TestCoreCentralizer {

    /**	Função para retorno do bearer de autenticação, utilizando o usuario e senha definido no Initial Engine.
     *	@param loginData = (Tenant) Classe de login.
     *	@param loginURL = (String) URL da primitiva de login.
     *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/TestAuthentication#m%C3%A9todo-getbearertenant-logindata-string-loginurl">getBearer(Tenant loginData, String loginURL)</a>
    **/
	public String getBearer(Tenant loginData, String loginURL) {
		Response Auth = TestRequest.request(HttpMethod.POST, null, loginData, loginURL);
		String autorization = Auth.asString();
		String getBearer = "";
		try {
			int a = autorization.indexOf("access_token")+17;
			int b = autorization.indexOf("refresh_token")-5;
			getBearer = "Bearer " + autorization.substring(a, b);
		}catch (Exception e) {
			Assert.fail("Ocorreu erro no login!");
		}
		return getBearer;
	}

	/**
	 * Esta sub classe tem como objetivo servir como um facilitador para login e obter o Tenant e password Default do nosso teste.
	 * <br>
	 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/TestAuthentication#sub-classe-tenant">Sub Classe Tenant</a>
	**/
	public static class Tenant{
		private String username;
		private String password;
	
		public void setDataLogin(String tenant, String password) {
			this.setUsername(tenant);
			this.setPassword(password);
		}
	
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			username = "admin@" + username + ".com.br";
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

	}

}
