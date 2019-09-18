package test.api.core;

import org.testng.Assert;

import io.restassured.response.Response;
import test.api.core.TestRequest.HttpMethod;

/**	Dados para criar o JSon de Login **/
public class TestAuthentication extends TestCoreCentralizer {

    /**	Função para retorno do bearer de autenticação, utilizando o usuario e senha definido no Initial Engine.
     *	@param loginData = (Login) Classe de login.
     *	@param URLBase = (String) URL da primitiva de login.
    **/
	public String getBearer(classLogin loginData, String URLBase) {
		Response Auth = TestRequest.request(HttpMethod.POST, null, loginData, URLBase);
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
	
	public static class classLogin{
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
