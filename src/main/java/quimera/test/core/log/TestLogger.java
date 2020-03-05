package quimera.test.core.log;

import java.lang.reflect.Method;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import quimera.test.core.TestCoreCentralizer;

/**	
 * <b> Definição: </b> <br>
 * Classe que fará os Logs no allure ou no console.
 * <br>
**/
public class TestLogger extends TestCoreCentralizer {

	/**	
	 * <b> Definição: </b> <br>
	 * Classe que fará os Logs no allure ou no console.
	 * @param infos (Object) = Deverá receber um objeto contendo um String ou lista de string para que possa ser armazenada e impressa futuramente no log.
	**/
	public static void logInfo(Object infos) {
		conteudoTest.add(setEnter(2) + "--->" + infos.toString());
	}

	/**	
	 * <b>[Apenas usado para as chamadas do RestAssured.io]</b> <br>
	 * <b> Definição: </b> <br>
	 * Tem como objetivo armazenar as informações das chamadas, o body de retorno da mesma como exemplo. <br>
	 * @param response [Response] = Deverá receber um Response de alguma chamada do RestAssured.io.
	**/
	public static void logResponse(Response response) {
		conteudoTest.add(setEnter(2) + "--->Resposta da chamada: " + response.asString());
	}

	/**	
	 * <b>[Apenas usado no @AfterMethod da classe TestApiExtension]</b> <br>
	 * <b> Definição: </b> <br>
	 * Tem como objetivo armazenar no tituloTest as informações primordiais como o nome do método do teste dos quais os logs estão sendo armazenados.
	 * @param testInfo [Method] = O tipo Method receberá automaticamente um valor vindo de um @AfterMethod com este parâmetro.
	**/
	public static void testInfoLogger(Method testInfo) {
		tituloTest = setEnter(2) + "------------------------------------------------------------" + setEnter(1) + "Classe de Teste: " + testInfo.getName() + setEnter(1);
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Cria um log no console com as informações do objeto.
	 * @param infos [Object] = Deverá receber um objeto contendo um String ou lista de string para que possa ser armazenada e impressa futuramente no log.
	**/
	public static void printLog(Object infos) {
		System.out.println(infos.toString());
	}
	
	/**	
	 * <b> Definição: </b> <br>
	 * Função para inserir uma ou mais linhas dentro de algum log.
	 * @param quantidade [int] = Quantidade de enters que o texto irá receber.
	**/
	private static String setEnter(int quantidade) {
		String separadores = new String();
		while (quantidade > 0) {
			separadores = separadores + "\n";
			quantidade--;
		}
		return separadores;
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Criar o report do allure framework.
	 * @param testInfo [Method] = Deverá receber um objeto contendo um String ou lista de string para que possa ser armazenada e impressa futuramente no log.
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