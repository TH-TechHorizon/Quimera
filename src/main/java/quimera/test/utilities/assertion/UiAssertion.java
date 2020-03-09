package quimera.test.utilities.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;

/**	
 * <b> Definição: </b> <br>
 * Asserções de testes, estas para testes de Interface.
**/
public class UiAssertion extends TestCoreCentralizer {

	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o título da página é igual ao título esperado.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.ui().isEqualTitle(driver, "Login");
	 * </code>
	 * @param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 * @param tituloEsperado [String] = Texto a ser validado, comparado com o título da página.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualTitle(WebDriver driver, String tituloEsperado) {
		String tituloValidado = driver.getTitle().toString();
		TestLogger.logInfo("Verificando se o título esperado: " + tituloEsperado + " |É igual a: " + tituloValidado + "|");
		assertThat(tituloEsperado).isEqualTo(tituloValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o título da página é igual ao título esperado.<br>WebDriver utilizado será o da variável padrão (driver)<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.ui().isEqualTitle("Login");
	 * </code>
	 * @param tituloEsperado [String] = Texto a ser validado, comparado com o título da página.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualTitle(String tituloEsperado) {
		String tituloValidado = driver.getTitle().toString();
		TestLogger.logInfo("Verificando se o título esperado: " + tituloEsperado + " |É igual a: " + tituloValidado + "|");
		assertThat(tituloEsperado).isEqualTo(tituloValidado);
		return new AssertThat();
	}
	
	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o texto de um campo é igual ao texto esperado!.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.ui().isEqualText(driver, By.id("email"), "teste@gmail.com");
	 * </code>
	 * @param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 * @param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 * @param textoEsperado [String] = Texto a ser validado, comparado com o texto adquirido pelo campo.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualText(WebDriver driver, By campo, String textoEsperado) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String textoValidado = field.getText();
		TestLogger.logInfo("Verificando se o texto esperado: " + textoEsperado + " |É igual a: " + textoValidado + "|");
		assertThat(textoEsperado).isEqualTo(textoValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o texto de um campo é igual ao texto esperado!.<br>WebDriver utilizado será o da variável padrão (driver)<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.ui().isEqualText(By.id("email"), "teste@gmail.com");
	 * </code>
	 * @param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 * @param textoEsperado [String] = Texto a ser validado, comparado com o texto adquirido pelo campo.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualText(By campo, String textoEsperado) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String textoValidado = field.getText();
		TestLogger.logInfo("Verificando se o texto esperado: " + textoEsperado + " |É igual a: " + textoValidado + "|");
		assertThat(textoEsperado).isEqualTo(textoValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o texto de um campo é igual ao texto esperado!<br>WebDriver utilizado será o da variável padrão (driver)<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campoEmail = uiTools.locateWebElement(By.id("email"));<br>
	 * AssertThat.ui().isEqualText(campoEmail, "teste@gmail.com");
	 * </code>
	 * @param campo [WebElement] = Campo a ser usado, deverá já ser um WebElement
	 * @param textoEsperado [String] = Texto a ser validado, comparado com o texto adquirido pelo campo.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualText(WebElement campo, String textoEsperado) {
		String textoValidado = campo.getText();
		TestLogger.logInfo("Verificando se o texto esperado: " + textoEsperado + " |É igual a: " + textoValidado + "|");
		assertThat(textoEsperado).isEqualTo(textoValidado);
		return new AssertThat();
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o valor de um campo é igual ao valor esperado!<br> A busca do valor do campo se dá pela função getAttribute("Value")<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.ui().isEqualValue(driver, By.id("email"), "teste@gmail.com");
	 * </code>
	 * @param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 * @param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 * @param valorEsperado [String] = Texto a ser validado, comparado com o valor buscado do campo.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualValue(WebDriver driver, By campo, String valorEsperado) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String valorValidado = field.getAttribute("value").toString();
		TestLogger.logInfo("Verificando se o texto esperado: "+valorEsperado+" |É igual a: "+valorValidado+"|");
		assertThat(valorEsperado).isEqualTo(valorValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o valor de um campo é igual ao valor esperado!<br> A busca do valor do campo se dá pela função getAttribute("Value")<br>WebDriver utilizado será o da variável padrão (driver)<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.ui().isEqualValue(By.id("email"), "teste@gmail.com");
	 * </code>
	 * @param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 * @param valorEsperado [String] = Texto a ser validado, comparado com o valor buscado do campo.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualValue(By campo, String valorEsperado) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String valorValidado = field.getAttribute("value").toString();
		TestLogger.logInfo("Verificando se o texto esperado: "+valorEsperado+" |É igual a: "+valorValidado+"|");
		assertThat(valorEsperado).isEqualTo(valorValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o valor de um campo é igual ao valor esperado!<br> A busca do valor do campo se dá pela função getAttribute("Value")<br>WebDriver utilizado será o da variável padrão (driver)<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campoEmail = uiTools.locateWebElement(By.id("email"));<br>
	 * AssertThat.ui().isEqualValue(campoEmail, "teste@gmail.com");
	 * </code>
	 * @param campo [WebElement] = Campo a ser usado, deverá já ser um WebElement
	 * @param valorEsperado [String] = Texto a ser validado, comparado com o valor buscado do campo.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualValue(WebElement campo, String valorEsperado) {
		String valorValidado = campo.getAttribute("value").toString();
		TestLogger.logInfo("Verificando se o texto esperado: " + valorEsperado + " |É igual a: " + valorValidado + "|");
		assertThat(valorEsperado).isEqualTo(valorValidado);
		return new AssertThat();
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o valor de um campo é igual ao valor esperado!<br> A busca do valor da classe do campo se dá pela função getClass().getName().toString()<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.ui().isEqualClass(driver, By.id("email"), "button");
	 * </code>
	 * @param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 * @param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 * @param classeEsperada [String] = Nome da classe que o campo deverá possuir.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualClass(WebDriver driver, By campo, String classeEsperada) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String campoValidado = field.getClass().getName().toString();
		TestLogger.logInfo("Verificando se a classe esperada: " + classeEsperada + " |Existe entre as classes: " + campoValidado + " do campo.");
		assertThat(campoValidado).contains(campoValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o valor de um campo é igual ao valor esperado!<br> A busca do valor da classe do campo se dá pela função getClass().getName().toString()<br>WebDriver utilizado será o da variável padrão (driver)<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * AssertThat.ui().isEqualClass(driver, By.id("email"), "button");
	 * </code>
	 * @param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 * @param classeEsperada [String] = Nome da classe que o campo deverá possuir.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualClass(By campo, String classeEsperada) {
		WebElement field;
		uiTool.waitField(driver, campo, true);
		field = driver.findElement(campo);
		String campoValidado = field.getClass().getName().toString();
		TestLogger.logInfo("Verificando se a classe esperada: " + classeEsperada + " |Existe entre as classes: " + campoValidado + " do campo.");
		assertThat(campoValidado).contains(campoValidado);
		return new AssertThat();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Valida se o valor de um campo é igual ao valor esperado!<br> A busca do valor da classe do campo se dá pela função getClass().getName().toString()<br>WebDriver utilizado será o da variável padrão (driver)<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campoEmail = uiTools.locateWebElement(By.id("email"));<br>
	 * AssertThat.ui().isEqualClass(campoEmail, "button");
	 * </code>
	 * @param campo [WebElement] = Campo a ser usado, deverá já ser um WebElement
	 * @param classeEsperada [String] = Nome da classe que o campo deverá possuir.
	 * @return Retorna um novo AssertThat para uma próxima validação.
	**/
	public AssertThat isEqualClass(WebElement campo, String classeEsperada) {
		uiTool.waitFieldEnableOrDisplayed(campo);
		String campoValidado = campo.getClass().getName().toString();
		TestLogger.logInfo("Verificando se a classe esperada: " + classeEsperada + " |Existe entre as classes: " + campoValidado + " do campo.");
		assertThat(campoValidado).contains(campoValidado);
		return new AssertThat();
	}

}
