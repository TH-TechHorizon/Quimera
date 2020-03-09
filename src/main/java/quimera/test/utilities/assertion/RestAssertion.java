package quimera.test.utilities.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.response.Response;
import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;

/**	
 * <b> Definição: </b> <br>
 * Asserções de testes, estas para testes de API REST.
**/
public class RestAssertion extends TestCoreCentralizer {

	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o status de retorno de uma resposta é igual ao esperado.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.rest().isEqualStatusCode(respostaAPI, 200);
	 * </code>
	 * @param resposta [Response] = Variável response do restassured.
	 * @param statusEsperado [int] = status de API de retorno, exemplo: <li> 200 </li> <li> 400 </li> <li> 500 </li>
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualStatusCode(Response resposta, int statusEsperado) {
		String statusValidado = String.valueOf(resposta.getStatusCode());
		TestLogger.logInfo("Verificando se o status retornado: "+statusValidado+" |É igual a: "+statusEsperado+" |");
		assertThat(statusEsperado).isEqualTo(resposta.getStatusCode());
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Em uma resposta Json, tem um texto em um caminho específico.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.rest().isEqualText(respostaAPI, "Willer", "data.nome");
	 * </code>
	 * @param resposta [Response] = Variável response do restassured.
	 * @param textoEsperado [String] = Texto experado no caminho de um Json.
	 * @param caminho [String] = Caminho no Json para a validação.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualText(Response resposta, String textoEsperado, String caminho) {
		String textoValidado = getJsonValue(resposta, caminho);
		TestLogger.logInfo("Verificando se o texto esperado: "+textoEsperado+" |É igual a: "+textoValidado+"|");
		assertThat(textoEsperado).isEqualTo(textoValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Em uma resposta Json, valida se um caminho específico possui um determinado número.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.rest().isEqualNumber(respostaAPI, 25, "data.usuario.idade");
	 * </code>
	 * @param resposta [Response] = Variável response do restassured.
	 * @param numeroEsperado [int] = Numero experado no caminho de um Json.
	 * @param caminho [String] = Caminho no Json para a validação.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualNumber(Response resposta, int numeroEsperado, String caminho) {
		int numeroValidado = Integer.parseInt(getJsonValue(resposta, caminho));
		TestLogger.logInfo("Verificando se o número esperado: "+numeroEsperado+" |É igual a: "+numeroValidado+" |");
		assertThat(numeroEsperado).isEqualTo(numeroValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Em uma resposta Json, valida se um caminho possui a quantidade esperadas de elementos filhos.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.rest().isEqualSize(respostaAPI, 25, "data.usuarios");
	 * </code>
	 * @param resposta [Response] = Variável response do restassured.
	 * @param tamanhoEsperado [int] = Tamanho esperado da quantidade de filhos de um caminho específico.
	 * @param caminho [String] = Caminho no Json para a validação.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualSize(Response resposta, int tamanhoEsperado, String caminho) {
		int tamanhoValidado = getJsonTotalElements(resposta, caminho);
		TestLogger.logInfo("Verificando se o tamanho esperado: "+tamanhoEsperado+" |É igual a: "+tamanhoValidado+" |");
		assertThat(tamanhoEsperado).isEqualTo(tamanhoValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Em uma resposta Json, valida se um caminho possui possui algum filho, ou existe.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.rest().isNotNullText(respostaAPI, "data.usuarios");
	 * </code>
	 * @param resposta [Response] = Variável response do restassured.
	 * @param caminho [String] = Caminho no Json para a validação.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isNotNullText(Response resposta, String caminho) {
		String textoValidado = getJsonValue(resposta, caminho);
		TestLogger.logInfo("Verificando se o texto: "+textoValidado+" está nulo.");
		assertThat(textoValidado).isNotNull();
		return new AssertThat();
	}

}
