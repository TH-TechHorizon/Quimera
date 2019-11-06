package quimera.test.core.log;

import java.lang.reflect.Method;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import quimera.test.core.TestCoreCentralizer;

/**	
 * Classe que fará os Logs no allure ou no console.
 * <br>
**/
public class TestLogger extends TestCoreCentralizer {

	/**	
	 * Classe que fará os Logs no allure ou no console.
	 * <br>
	 * @param infos (Object) = Deverá receber um objeto contendo um String ou lista de string para que possa ser armazenada e impressa futuramente no log.
	 * <br>
	**/
	public static void logInfo(Object infos) {
		conteudoTest.add(setEnter(2) + "--->" + infos.toString());
	}

	/**	
	 * Tem como objetivo armazenar as informações das chamadas, o body de retorno da mesma como exemplo.
	 * <br>
	 * <b>[Apenas usado para as chamadas do RestAssured.io]</b>
	 * <br>
	 * @param response (Response) = Deverá receber um Response de alguma chamada do RestAssured.io.
	 * <br>
	**/
	public static void logResponse(Response response) {
		conteudoTest.add(setEnter(2) + "--->Resposta da chamada: " + response.asString());
	}

	/**	
	 * Tem como objetivo armazenar no tituloTest as informações primordiais como o nome do método do teste dos quais os logs estão sendo armazenados.
	 * <br>
	 * <b>[Apenas usado no @AfterMethod da classe TestApiExtension]</b>
	 * <br>
	 * @param testInfo (Method) = O tipo Method receberá automaticamente um valor vindo de um @AfterMethod com este parâmetro.
	 * <br>
	**/
	public static void testInfoLogger(Method testInfo) {
		tituloTest = setEnter(2) + "------------------------------------------------------------" + setEnter(1) + "Classe de Teste: " + testInfo.getName() + setEnter(1);
	}

	/**	
	 * Cria um log no console com as informações do objeto.
	 * <br>
	 * @param infos (Object) = Deverá receber um objeto contendo um String ou lista de string para que possa ser armazenada e impressa futuramente no log.
	 * <br>
	**/
	public static void printLog(Object infos) {
		System.out.println(infos.toString());
	}
	
	/**	Função para inserir uma ou mais linhas dentro de algum log. **/
	private static String setEnter(int quantidade) {
		String separadores = new String();
		while (quantidade > 0) {
			separadores = separadores + "\n";
			quantidade--;
		}
		return separadores;
	}

	/**	
	 * Criar o report do allure framework.
	 * <br>
	 * @param testInfo (Method) = Deverá receber um objeto contendo um String ou lista de string para que possa ser armazenada e impressa futuramente no log.
	 * <br>
	**/
	public static void allureReport(Method testInfo) {
		testInfoLogger(testInfo);
		String relatorioFinal = "";
		relatorTest.add(tituloTest);
		relatorTest.addAll(conteudoTest);
		for (String texto : relatorTest) {
			relatorioFinal = relatorioFinal + texto;
		}
		if (!conteudoTest.isEmpty()) {
			printLog(relatorioFinal);
			Allure.addAttachment("Relatorio do Teste", relatorioFinal);
		}
	}

}