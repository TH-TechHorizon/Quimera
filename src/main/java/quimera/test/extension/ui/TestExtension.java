package quimera.test.extension.ui;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.engine.TestUIEngine;
import quimera.test.core.log.TestLogger;


/**	
 * Esta é a classe que deverá ser extendida pelas classes de testes.
 * <br>
 * Esta classe possui alguns parâmetros universais para os testes, além da mesma extender da classe TestCoreCentralizer, ou seja, ao extender esta classe todas as funções do core poderão ser usadas.
 * <br>
**/
public class TestExtension extends TestCoreCentralizer {
	
	@BeforeTest
	protected void AbrirNavegador() {
		driver = TestUIEngine.iniciarNavegador(driver);
	}

	@BeforeClass
	protected void resetRelatorioAntesClasse(){
		resetRelatorio();
	}

	@BeforeMethod
	protected void resetRelatorioAntesDoMétodo(){
		resetRelatorio();
	}

	@AfterMethod
	protected void finalizaTesteAtual(Method testInfo) {
		TestLogger.allureReport(testInfo);
	}
	
	@AfterTest
	protected void finalizaNavegador() {
		TestUIEngine.fecharNavegador(driver);
	}
	
	private void resetRelatorio() {
		relatorTest = new ArrayList<String>();
		tituloTest = new String();
		conteudoTest = new ArrayList<String>();
	}

}
