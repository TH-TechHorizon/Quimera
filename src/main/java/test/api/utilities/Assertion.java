package test.api.utilities;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.response.Response;
import test.api.core.TestCoreCentralizer;
import test.api.core.TestLogger;


/**
 * Esta classe pode ser importada e usada em validações dos testes.
 * <br>
 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion">Assertion</a>
**/
public class Assertion extends TestCoreCentralizer {

	/** Objetivo: Efetuar a validação do statusCode retornado por algum response do RestAssured.IO.
	 *	<br>
	 *	Tem o mesmo efeito que chamar:
	 *	<br><br>
	 *	<code>Response resposta  = requestPost.jsonSemValidacaoHTTPS(authorizationBearer, "", bodyData, URLAPI);</code>
	 *	<br>
	 *	<code>assertThat(200).isEqualTo(resposta.getStatusCode());</code>
	 *	<br>
	 *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion#equalstatuscoderesponse-resposta-int-statusesperado">equalStatusCode</a>
	 *	<br>
	 * 	@param resposta (Response) = Response de uma chamada do restAssured.
	 * 	@param statusEsperado (int) = Status da chamada "200", "400"...
	**/
	public static void equalStatusCode(Response resposta, int statusEsperado) {
		String statusValidado = String.valueOf(resposta.getStatusCode());
		TestLogger.logInfo("Verificando se o status retornado: "+statusValidado+" |É igual a: "+statusEsperado+" |");
		assertThat(statusEsperado).isEqualTo(resposta.getStatusCode());
	}

	/**
	 * O assertion If(se) é responsável pelas validações básicas de valores, levando em consideração geralmente dois valores.
	 * <br>
	 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.If">Assertion.If</a>
	**/
	public static class If{

		/**
		 * O Have(possui), tem como objetivo servir como facilitador para encontrar apenas as assertivas referentes a validações positivas.
		 * <br>
		 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.If#assertionifhave">Assertion.If.Have</a>
		**/
		public static class Have {

			/** Objetivo: Efetuar a validação se um texto é igual a outro.
			 *	<br>
			 *	Tem o mesmo efeito que chamar:
			 *	<br>
			 *	<code>assertThat("Texto A").isEqualTo("Texto B");</code>
			 *	<br>
			 *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.If#equaltextstring-textoesperado-string-textovalidado">equalText</a>
			 *	<br>
			 * 	@param textoEsperado (String) = Texto esperado na validacao.
			 * 	@param textoValidado (String) = Texto que terá que ser igual ao texto esperado.
			**/
			public static void equalText(String textoEsperado, String textoValidado) {
				TestLogger.logInfo("Verificando se o texto esperado: "+textoEsperado+" |É igual a: "+textoValidado+" |");
				assertThat(textoEsperado).isEqualTo(textoValidado);
			}

			/** Objetivo: Efetuar a validação se um número é igual a outro.
			 *	<br>
			 *	Tem o mesmo efeito que chamar:
			 *	<br><br>
			 *	<code>assertThat(1).isEqualTo(2);</code>
			 *	<br>
			 *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.If#equalnumberint-numeroesperado-int-numerovalidado">equalNumber</a>
			 *	<br>
			 *	@param numeroEsperado = (int) Número que é esperado.
			 *	@param numeroValidado = (int) Número que será validado.
			 **/
			public static void equalNumber(int numeroEsperado, int numeroValidado) {
				TestLogger.logInfo("Verificando se o número esperado: "+String.valueOf(numeroEsperado)+" |É igual a: "+String.valueOf(numeroValidado) + " |");
				assertThat(numeroEsperado).isEqualTo(numeroValidado);
			}

			/** Objetivo: Efetuar a validação entre dois valores doubles.
			 *	<br>
			 *	Tem o mesmo efeito que chamar:
			 *	<br>
			 *	<code>assertThat(12.5).isEqualTo(5.5);</code>
			 *	<br>
			 *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.If#equaldoubledouble-valoresperado-double-valorvalidado">equalDouble</a>
			 *	<br>
			 * 	@param valorEsperado (Double) = Valor esperado na validacao.
			 * 	@param valorValidado (Double) = Valor que terá que ser igual ao valorEsperado.
			**/
			public static void equalDouble(Double valorEsperado, Double valorValidado) {
				TestLogger.logInfo("Verificando se os valores valorEsperado: "+valorEsperado.toString()+" |É igual a: "+valorValidado.toString()+" |");
				assertThat(valorEsperado).isEqualTo(valorValidado);
			}
		}

		/**
		 * O DontHave(não possui), tem como objetivo servir como facilitador para encontrar apenas as assertivas referentes a validações negativas.
		 * <br>
		 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.If#assertionifdonthave">Assertion.If.DontHave</a>
		**/
		public static class DontHave {

			/** Objetivo: Efetuar a validação de um texto verificando se o mesmo possui um valor nulo.
			 *	<br>
			 *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.If#nulltextstring-texto">nullText</a>
			 *	<br>
			 *	@param texto = (String) Variável ou retorno que seja esperado que o texto seja nulo.
			 **/
			public static void nullText(String texto) {
				TestLogger.logInfo("Verificando se o texto: " + texto + " está nulo!");
				assertThat(texto).isNotNull();
			}
		}

	}

	/**
	 * O assertion IfJson(se Json) é responsável pelas validações básicas de valores vindos do Json de respostas do RestAssured.IO, levando em consideração geralmente dois valores.
	 * <br>
	 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.IfJson">Assertion.IfJson</a>
	**/
	public static class IfJson{

		/**
		 * O Have(possui), tem como objetivo servir como facilitador para encontrar apenas as assertivas referentes a validações positivas. 
		 * <br>
		 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.IfJson#assertionifjsonhave">Assertion.IfJson.Have</a>
		**/
		public static class Have{
			
			/** Objetivo: Efetuar a validação de um elemento Json, vendo se o texto de um elemento é igual ao esperado.
			 *	<br>
			 *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.IfJson#equaltextresponse-resposta-string-textoesperado-string-caminho">equalText</a>
			 *	<br>
			 *	@param resposta = (Response) Response de uma chamada do restAssured.
			 *	@param textoEsperado = (String) Texto que o campo do json deverá conter.
			 *	@param caminho = (String) Caminho do patch json do campo.
			**/
			public static void equalText(Response resposta, String textoEsperado, String caminho) {
				String textoValidado = getJsonValue(resposta, caminho);
				TestLogger.logInfo("Verificando se o texto esperado: "+textoEsperado+" |É igual a: "+textoValidado+"|");
				assertThat(textoEsperado).isEqualTo(textoValidado);
			}

			/** Objetivo: Efetuar a validação de um elemento Json, vendo se o número de um elemento é igual ao esperado.
			 *	<br>
			 *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.IfJson#equalnumberresponse-resposta-int-numeroesperado-string-caminho">equalNumber</a>
			 *	<br>
			 *	@param resposta = (Response) Response de uma chamada do restAssured.
			 *	@param numeroEsperado = (int) Número que o campo do json deverá conter.
			 *	@param caminho = (String) Caminho do patch json do campo.
			 **/
			public static void equalNumber(Response resposta, int numeroEsperado, String caminho) {
				int numeroValidado = Integer.parseInt(getJsonValue(resposta, caminho));
				TestLogger.logInfo("Verificando se o número esperado: "+numeroEsperado+" |É igual a: "+numeroValidado+" |");
				assertThat(numeroEsperado).isEqualTo(numeroValidado);
			}

			/** Objetivo: Efetuar a validação de um elemento Json, validando se a quantidade de elementos filhos é igual ao esperado.
			 *	<br>
			 *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.IfJson#equalsizeresponse-resposta-int-tamanhoesperado-string-caminho">equalSize</a>
			 *	<br>
			 *	@param resposta = (Response) Response de uma chamada do restAssured.
			 *	@param tamanhoEsperado = (int) Número de filhos que o campo do json deverá conter.
			 *	@param caminho = (String) Caminho do patch json do campo.
			 **/
			public static void equalSize(Response resposta, int tamanhoEsperado, String caminho) {
				int tamanhoValidado = getJsonTotalElements(resposta, caminho);
				TestLogger.logInfo("Verificando se o tamanho esperado: "+tamanhoEsperado+" |É igual a: "+tamanhoValidado+" |");
				assertThat(tamanhoEsperado).isEqualTo(tamanhoValidado);
			}
		}

		/**
		 * O DontHave(não possui), tem como objetivo servir como facilitador para encontrar apenas as assertivas referentes a validações negativas. 
		 * <br>
		 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.IfJson#assertionifjsondonthave">Assertion.IfJson.DontHave</a>
		**/
		public static class DontHave{

			/** Objetivo: Efetuar a validação de um elemento Json, validando se o texto do valor de um elemento é igual a null.
			 *	<br>
			 *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/Assertion.IfJson#nulltextresponse-resposta-string-caminho">nullText</a>
			 *	<br>
			 *	@param resposta = (Response) Response de uma chamada do restAssured.
			 *	@param caminho = (String) Caminho do patch json do campo.
			**/
			public static void nullText(Response resposta, String caminho) {
				String textoValidado = getJsonValue(resposta, caminho);
				TestLogger.logInfo("Verificando se o texto: "+textoValidado+" está nulo.");
				assertThat(textoValidado).isNotNull();
			}

		}

	}

}