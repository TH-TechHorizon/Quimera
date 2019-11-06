package quimera.test.utilities.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;

public class UiAssertion extends TestCoreCentralizer {

	public AssertThat isEqualTitle(WebDriver driver, String tituloEsperado) {
		String tituloValidado = driver.getTitle().toString();
		TestLogger.logInfo("Verificando se o título esperado: " + tituloEsperado + " |É igual a: " + tituloValidado + "|");
		assertThat(tituloEsperado).isEqualTo(tituloValidado);
		return new AssertThat();
	}
	public AssertThat isEqualTitle(String tituloEsperado) {
		String tituloValidado = driver.getTitle().toString();
		TestLogger.logInfo("Verificando se o título esperado: " + tituloEsperado + " |É igual a: " + tituloValidado + "|");
		assertThat(tituloEsperado).isEqualTo(tituloValidado);
		return new AssertThat();
	}

	public AssertThat isEqualText(WebDriver driver, By campo, String textoEsperado) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String textoValidado = field.getText();
		TestLogger.logInfo("Verificando se o texto esperado: " + textoEsperado + " |É igual a: " + textoValidado + "|");
		assertThat(textoEsperado).isEqualTo(textoValidado);
		return new AssertThat();
	}
	public AssertThat isEqualText(By campo, String textoEsperado) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String textoValidado = field.getText();
		TestLogger.logInfo("Verificando se o texto esperado: " + textoEsperado + " |É igual a: " + textoValidado + "|");
		assertThat(textoEsperado).isEqualTo(textoValidado);
		return new AssertThat();
	}
	public AssertThat isEqualText(WebElement campo, String textoEsperado) {
		String textoValidado = campo.getText();
		TestLogger.logInfo("Verificando se o texto esperado: " + textoEsperado + " |É igual a: " + textoValidado + "|");
		assertThat(textoEsperado).isEqualTo(textoValidado);
		return new AssertThat();
	}

	public AssertThat isEqualValue(WebDriver driver, By campo, String valorEsperado) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String valorValidado = field.getAttribute("value").toString();
		TestLogger.logInfo("Verificando se o texto esperado: "+valorEsperado+" |É igual a: "+valorValidado+"|");
		assertThat(valorEsperado).isEqualTo(valorValidado);
		return new AssertThat();
	}
	public AssertThat isEqualValue(By campo, String valorEsperado) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String valorValidado = field.getAttribute("value").toString();
		TestLogger.logInfo("Verificando se o texto esperado: "+valorEsperado+" |É igual a: "+valorValidado+"|");
		assertThat(valorEsperado).isEqualTo(valorValidado);
		return new AssertThat();
	}
	public AssertThat isEqualValue(WebElement campo, String valorEsperado) {
		String valorValidado = campo.getAttribute("value").toString();
		TestLogger.logInfo("Verificando se o texto esperado: " + valorEsperado + " |É igual a: " + valorValidado + "|");
		assertThat(valorEsperado).isEqualTo(valorValidado);
		return new AssertThat();
	}

	public AssertThat isEqualClass(WebDriver driver, By campo, String classeEsperada) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String campoValidado = field.getClass().getName().toString();
		TestLogger.logInfo("Verificando se a classe esperada: " + classeEsperada + " |Existe entre as classes: " + campoValidado + " do campo.");
		assertThat(campoValidado).contains(campoValidado);
		return new AssertThat();
	}
	public AssertThat isEqualClass(By campo, String classeEsperada) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String campoValidado = field.getClass().getName().toString();
		TestLogger.logInfo("Verificando se a classe esperada: " + classeEsperada + " |Existe entre as classes: " + campoValidado + " do campo.");
		assertThat(campoValidado).contains(campoValidado);
		return new AssertThat();
	}
	public AssertThat isEqualClass(WebElement campo, String classeEsperada) {
		uiTool.waitFieldEnableOrDisplayed(campo);
		String campoValidado = campo.getClass().getName().toString();
		TestLogger.logInfo("Verificando se a classe esperada: " + classeEsperada + " |Existe entre as classes: " + campoValidado + " do campo.");
		assertThat(campoValidado).contains(campoValidado);
		return new AssertThat();
	}

}
