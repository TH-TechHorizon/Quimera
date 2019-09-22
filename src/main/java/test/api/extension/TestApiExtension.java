package test.api.extension;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.qameta.allure.Allure;
import test.api.core.TestAuthentication;
import test.api.core.TestCoreCentralizer;
import test.api.core.TestLogger;


/**	Engine inicial para AmbientDefault e validações primárias dos testes. **/
public class TestApiExtension extends TestCoreCentralizer {

	@BeforeClass
	protected void efetuaLoginSeNecessario(){
		relatorTest = new ArrayList<String>();
		tituloTest = new String();
		conteudoTest = new ArrayList<String>();
		if(authorizationBearer == null || authorizationBearer.isEmpty()) {
			TestAuthentication.Tenant usuario = new TestAuthentication.Tenant();
			usuario.setUsername(environment.getAmbinetConfigs().getTenant());
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
		TestLogger.testInfoLogger(testInfo);
		String relatorioFinal = "";
		relatorTest.add(tituloTest);
		relatorTest.addAll(conteudoTest);
		for (String texto : relatorTest) {
			relatorioFinal = relatorioFinal + texto;
		}
		if (!conteudoTest.isEmpty()) {
			TestLogger.printLog(relatorioFinal);
			Allure.addAttachment("Relatorio do teste", relatorioFinal);
		}
	}

}
