package test.api.extension;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import test.api.core.TestAuthentication;
import test.api.core.TestCoreCentralizer;
import test.api.core.TestLogger;


/**	
 * Esta é a classe que deverá ser extendida pelas classes de testes.
 * <br>
 * Esta classe possui alguns parâmetros universais para os testes, além da mesma extender da classe TestCoreCentralizer, ou seja, ao extender esta classe todas as funções do core poderão ser usadas.
 * <br>
 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/TestApiExtension#testapiextension">TestApiExtension</a>
**/
public class TestApiExtension extends TestCoreCentralizer {

	@BeforeClass
	protected void efetuaLoginSeNecessario(){
		relatorTest = new ArrayList<String>();
		tituloTest = new String();
		conteudoTest = new ArrayList<String>();
		if(authorizationBearer == null || authorizationBearer.isEmpty()) {
			TestAuthentication.Tenant usuario = new TestAuthentication.Tenant();
			usuario.setUsername(environment.getAmbinetConfigs().getUsername());
			usuario.setPassword(environment.getAmbinetConfigs().getPassword());
			authorizationBearer = autenticacaoPlataforma.getBearer(usuario, getUrlAPIDefault() + "platform/authentication/actions/login");
		}
	}

	@BeforeMethod
	protected void resetRelatorio(){
		relatorTest = new ArrayList<String>();
		tituloTest = new String();
		conteudoTest = new ArrayList<String>();
	}

	@AfterMethod
	protected void finalizaTesteAtual(Method testInfo) {
		TestLogger.allureReport(testInfo);
	}

}
