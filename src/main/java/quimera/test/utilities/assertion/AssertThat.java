package quimera.test.utilities.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;

/**	
 * <b> Definição: </b> <br>
 * Asserções de testes, estas para testes de API ou UI.
**/
public class AssertThat extends TestCoreCentralizer {

	/**	
	 * <b> Definição: </b> <br>
	 * Todos os asserts referente aos testes de REST.<br><br>
	 * @return Retorna os asserts de testes REST
	**/
	public static RestAssertion rest() {
		return new RestAssertion();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Todos os asserts referente aos testes de UI.<br><br>
	 * @return Retorna os asserts de testes UI
	**/
	public static UiAssertion ui(){
		return new UiAssertion();
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Compara dois textos, validando se são iguais.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.isEqualText("Teste", "Teste");
	 * </code>
	 * @param textoEsperado [String] =  Texto origem, que será comparada com outro.
	 * @param textoValidado [String] = Texto que será comparado com o texto experado.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public static AssertThat isEqualText(String textoEsperado, String textoValidado) {
		TestLogger.logInfo("Verificando se o texto esperado: "+textoEsperado+" |É igual a: "+textoValidado+" |");
		assertThat(textoEsperado).isEqualTo(textoValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Compara dois números, validando se são iguais.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.isEqualNumber(150, 150);
	 * </code>
	 * @param numeroEsperado [int] = Número de origem, que será comparada com outro.
	 * @param numeroValidado [int] = Número que será comparado com o texto experado.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public static AssertThat isEqualNumber(int numeroEsperado, int numeroValidado) {
		TestLogger.logInfo("Verificando se o número esperado: "+String.valueOf(numeroEsperado)+" |É igual a: "+String.valueOf(numeroValidado) + " |");
		assertThat(numeroEsperado).isEqualTo(numeroValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Compara dois números doubles (Moeda...), validando se são iguais.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.isEqualDouble(150.55, 150.55);
	 * </code>
	 * @param numeroEsperado [Double] = Número de origem, que será comparada com outro.
	 * @param numeroValidado [Double] = Número que será comparado com o texto experado.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public static AssertThat isEqualDouble(Double valorEsperado, Double valorValidado) {
		TestLogger.logInfo("Verificando se os valores valorEsperado: "+valorEsperado.toString()+" |É igual a: "+valorValidado.toString()+" |");
		assertThat(valorEsperado).isEqualTo(valorValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Valdia se o texto está nulo.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * String texto = "Novo Texto";<br>
	 * AssertThat.isNotNullText(texto);
	 * </code>
	 * @param texto [String] = Texto a ser validado.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public static AssertThat isNotNullText(String texto) {
		TestLogger.logInfo("Verificando se o texto: " + texto + " está nulo!");
		assertThat(texto).isNotNull();
		return new AssertThat();
	}

}