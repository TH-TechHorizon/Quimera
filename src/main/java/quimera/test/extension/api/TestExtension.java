package quimera.test.extension.api;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;


/**	
 * Esta é a classe que deverá ser extendida pelas classes de testes.
 * <br>
 * Esta classe possui alguns parâmetros universais para os testes, além da mesma extender da classe TestCoreCentralizer, ou seja, ao extender esta classe todas as funções do core poderão ser usadas.
 * <br>
**/
public class TestExtension extends TestCoreCentralizer {

	@BeforeClass
	protected void resetRelatorioAntesDaClasse(){
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

	private void resetRelatorio() {
		relatorTest = new ArrayList<String>();
		tituloTest = new String();
		conteudoTest = new ArrayList<String>();
	}
	
}
