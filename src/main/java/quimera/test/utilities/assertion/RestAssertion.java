package quimera.test.utilities.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.response.Response;
import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;

public class RestAssertion extends TestCoreCentralizer {

	public AssertThat isEqualStatusCode(Response resposta, int statusEsperado) {
		String statusValidado = String.valueOf(resposta.getStatusCode());
		TestLogger.logInfo("Verificando se o status retornado: "+statusValidado+" |É igual a: "+statusEsperado+" |");
		assertThat(statusEsperado).isEqualTo(resposta.getStatusCode());
		return new AssertThat();
	}

	public AssertThat isEqualText(Response resposta, String textoEsperado, String caminho) {
		String textoValidado = getJsonValue(resposta, caminho);
		TestLogger.logInfo("Verificando se o texto esperado: "+textoEsperado+" |É igual a: "+textoValidado+"|");
		assertThat(textoEsperado).isEqualTo(textoValidado);
		return new AssertThat();
	}
	public AssertThat isEqualNumber(Response resposta, int numeroEsperado, String caminho) {
		int numeroValidado = Integer.parseInt(getJsonValue(resposta, caminho));
		TestLogger.logInfo("Verificando se o número esperado: "+numeroEsperado+" |É igual a: "+numeroValidado+" |");
		assertThat(numeroEsperado).isEqualTo(numeroValidado);
		return new AssertThat();
	}
	public AssertThat isEqualSize(Response resposta, int tamanhoEsperado, String caminho) {
		int tamanhoValidado = getJsonTotalElements(resposta, caminho);
		TestLogger.logInfo("Verificando se o tamanho esperado: "+tamanhoEsperado+" |É igual a: "+tamanhoValidado+" |");
		assertThat(tamanhoEsperado).isEqualTo(tamanhoValidado);
		return new AssertThat();
	}
	
	public AssertThat isNotNullText(Response resposta, String caminho) {
		String textoValidado = getJsonValue(resposta, caminho);
		TestLogger.logInfo("Verificando se o texto: "+textoValidado+" está nulo.");
		assertThat(textoValidado).isNotNull();
		return new AssertThat();
	}

}
