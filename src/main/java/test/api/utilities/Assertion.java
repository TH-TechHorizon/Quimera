package test.api.utilities;

import static org.assertj.core.api.Assertions.assertThat;
import io.restassured.response.Response;
import test.api.core.TestCoreCentralizer;


/**
 * Classe asserções para os testes
 * @author Gerson.Willer
**/
public class Assertion extends TestCoreCentralizer {

	/** Objetivo: Função que tem como objetivo efetuar a validação do statusCode retornado por algum response.
	 *	<br>
	 *	Tem o mesmo efeito que chamar:
	 *	<br><br>
	 *	<code>Response resposta  = requestPost.jsonSemValidacaoHTTPS(authorizationBearer, "", bodyData, URLAPI);</code>
	 *	<br>
	 *	<code>assertThat(200).isEqualTo(resposta.getStatusCode());</code>
	 *	<br>
	 * 	@param resposta (Response) = Response de uma chamada do restAssured.
	 * 	@param statusEsperado (int) = Status da chamada "200", "400"...
	**/
	public static void equalStatusCode(Response resposta, int statusEsperado) {
		String statusValidado = String.valueOf(resposta.getStatusCode());
		logInfo("Verificando se o status retornado: "+statusValidado+" |É igual a: "+statusEsperado+" |");
		assertThat(statusEsperado).isEqualTo(resposta.getStatusCode());
	}

	public static class If{

		public static class Have {

			/** Objetivo: Função que tem como objetivo efetuar a validação se um texto é igual a outro.
			 *	<br>
			 *	Tem o mesmo efeito que chamar:
			 *	<br>
			 *	<code>assertThat("Texto A").isEqualTo("Texto B");</code>
			 *	<br>
			 * 	@param textoEsperado (String) = Texto esperado na validacao.
			 * 	@param textoValidado (String) = Texto que terá que ser igual ao texto esperado.
			**/
			public static void equalText(String textoEsperado, String textoValidado) {
				logInfo("Verificando se o texto esperado: "+textoEsperado+" |É igual a: "+textoValidado+" |");
				assertThat(textoEsperado).isEqualTo(textoValidado);
			}

			/** Objetivo: Função que tem como objetivo efetuar a validação se um número é igual a outro.
			 *	<br>
			 *	Tem o mesmo efeito que chamar:
			 *	<br><br>
			 *	<code>assertThat(1).isEqualTo(2);</code>
			 *	<br>
			 *	@param numeroEsperado = (int) Número que é esperado.
			 *	@param numeroValidado = (int) Número que será validado.
			 **/
			public static void equalNumber(int numeroEsperado, int numeroValidado) {
				logInfo("Verificando se o número esperado: "+String.valueOf(numeroEsperado)+" |É igual a: "+String.valueOf(numeroValidado) + " |");
				assertThat(numeroEsperado).isEqualTo(numeroValidado);
			}

			/** Objetivo: Função que tem como objetivo efetuar a validação entre dois valores doubles.
			 *	<br>
			 *	Tem o mesmo efeito que chamar:
			 *	<br>
			 *	<code>assertThat(12.5).isEqualTo(5.5);</code>
			 *	<br>
			 * 	@param valorEsperado (Double) = Valor esperado na validacao.
			 * 	@param valorValidado (Double) = Valor que terá que ser igual ao valorEsperado.
			**/
			public static void equalDouble(Double valorEsperado, Double valorValidado) {
				logInfo("Verificando se os valores valorEsperado: "+valorEsperado.toString()+" |É igual a: "+valorValidado.toString()+" |");
				assertThat(valorEsperado).isEqualTo(valorValidado);
			}
		}

		public static class DontHave {

			/** Objetivo: Função que tem como objetivo efetuar a validação um texto possui um valor nulo.
			 *	<br>
			 *	@param texto = (String) Variável ou retorno que seja esperado que o texto seja nulo.
			 **/
			public static void nullText(String texto) {
				logInfo("Verificando se o texto: " + texto + " está nulo!");
				assertThat(texto).isNotNull();
			}
		}

	}

	public static class IfJson{

		public static class Have{
			
			/** Objetivo: Função que tem como objetivo efetuar a validação se o valor de um elemento é igual a outro.
			 *	<br>
			 *	@param resposta = (Response) Response de uma chamada do restAssured.
			 *	@param textoEsperado = (String) Texto que o campo do json deverá conter.
			 *	@param caminho = (String) Caminho do patch json do campo.
			**/
			public static void equalText(Response resposta, String textoEsperado, String caminho) {
				String textoValidado = getValorJson(resposta, caminho);
				logInfo("Verificando se o texto esperado: "+textoEsperado+" |É igual a: "+textoValidado+"|");
				assertThat(textoEsperado).isEqualTo(textoValidado);
			}

			/** Objetivo: Função que tem como objetivo efetuar a validação se o valor de um elemento é igual a um outro valor.
			 *	<br>
			 *	@param resposta = (Response) Response de uma chamada do restAssured.
			 *	@param numeroEsperado = (int) Número que o campo do json deverá conter.
			 *	@param caminho = (String) Caminho do patch json do campo.
			 **/
			public static void equalNumber(Response resposta, int numeroEsperado, String caminho) {
				int numeroValidado = Integer.parseInt(getValorJson(resposta, caminho));
				logInfo("Verificando se o número esperado: "+numeroEsperado+" |É igual a: "+numeroValidado+" |");
				assertThat(numeroEsperado).isEqualTo(numeroValidado);
			}

			/** Objetivo: Função que tem como objetivo efetuar a validação se um node do Json tem a quantidade de elementos igual a informada.
			 *	<br>
			 *	@param resposta = (Response) Response de uma chamada do restAssured.
			 *	@param tamanhoEsperado = (int) Número de filhos que o campo do json deverá conter.
			 *	@param caminho = (String) Caminho do patch json do campo.
			 **/
			public static void equalSize(Response resposta, int tamanhoEsperado, String caminho) {
				int tamanhoValidado = getQuantidadeDeElementos(resposta, caminho);
				logInfo("Verificando se o tamanho esperado: "+tamanhoEsperado+" |É igual a: "+tamanhoValidado+" |");
				assertThat(tamanhoEsperado).isEqualTo(tamanhoValidado);
			}
		}

		public static class DontHave{

			/** Objetivo: Função que tem como objetivo efetuar a validação um texto possui um valor nulo.
			 *	<br>
			 *	@param resposta = (Response) Response de uma chamada do restAssured.
			 *	@param caminho = (String) Caminho do patch json do campo.
			**/
			public static void nullText(Response resposta, String caminho) {
				String textoValidado = getValorJson(resposta, caminho);
				logInfo("Verificando se o texto: "+textoValidado+" está nulo.");
				assertThat(textoValidado).isNotNull();
			}

		}

	}

}