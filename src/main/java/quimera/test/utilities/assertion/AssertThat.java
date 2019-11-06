package quimera.test.utilities.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;

public class AssertThat extends TestCoreCentralizer {
	
	public static RestAssertion rest() {
		return new RestAssertion();
	}
	public static UiAssertion ui(){
		return new UiAssertion();
	}


	public static AssertThat isEqualText(String textoEsperado, String textoValidado) {
		TestLogger.logInfo("Verificando se o texto esperado: "+textoEsperado+" |É igual a: "+textoValidado+" |");
		assertThat(textoEsperado).isEqualTo(textoValidado);
		return new AssertThat();
	}
	public static AssertThat isEqualNumber(int numeroEsperado, int numeroValidado) {
		TestLogger.logInfo("Verificando se o número esperado: "+String.valueOf(numeroEsperado)+" |É igual a: "+String.valueOf(numeroValidado) + " |");
		assertThat(numeroEsperado).isEqualTo(numeroValidado);
		return new AssertThat();
	}
	public static AssertThat isEqualDouble(Double valorEsperado, Double valorValidado) {
		TestLogger.logInfo("Verificando se os valores valorEsperado: "+valorEsperado.toString()+" |É igual a: "+valorValidado.toString()+" |");
		assertThat(valorEsperado).isEqualTo(valorValidado);
		return new AssertThat();
	}
	public static AssertThat isNotNullText(String texto) {
		TestLogger.logInfo("Verificando se o texto: " + texto + " está nulo!");
		assertThat(texto).isNotNull();
		return new AssertThat();
	}

}