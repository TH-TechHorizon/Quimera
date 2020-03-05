package quimera.test.utilities;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;

/**	
 * <b> Definição: </b> <br>
 * Core de facilitadores para os elementos de selenium. <br>
 * Toda função pode chamar outra a partir da mesma chamada. <br>
 * <b>Exemplo:</b><br>
 * <code>
 * uiTool <br>
 * 	.navegateTo("www.google.com.br") <br>
 * 	.waitField(By.linkText("Sign in"), false) <br>
 *	.click(By.linkText("Sign in")) <br>
 * ;
 * </code>
**/
public class UiUtilities extends TestCoreCentralizer {

	/**	
	 * <b> Definição: </b> <br>
	 * Localiza um elemento esperando pelo tempo "TimeOutTime" definido no json de configuração.
	 * @param driver [WebDriver] = Driver do selenium, geralmente definido no TestCoreCentralizer como "driver".
	 * @param campo [By] = Elemento do tipo WebElement por By, por exemplo: By.xpath("//input[@title='Pesquisar']").
	 * @return [WebElement] retorna o elemento do campo bsucado.
	**/
	public WebElement locateWebElement(WebDriver driver, By campo) {
		WebElement c = null;
		int espera = 0;
		while (espera < (Integer.parseInt(environment.getUIEnvConfigs().getTimeOutTime()) * 1000)) {
			try {
				c = driver.findElement(campo);
				return c;
			}
			catch (Exception e) {
				campo = null;
			}
			espera = espera + 1000;
			try {
				Thread.sleep(1000);
			}catch (Exception e1) {}
		}
		return c;
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Localiza um elemento esperando pelo tempo "TimeOutTime" definido no json de configuração. <br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * uiTools.locateWebElement(By.xpath("//input[@title='Pesquisar']"));
	 * </code>
	 * @param driver [WebDriver] = Driver do selenium, geralmente definido no TestCoreCentralizer como "driver".
	 * @return [WebElement] retorna o elemento do campo bsucado.
	**/
	public WebElement locateWebElement(By campo) {
		WebElement c = null;
		int espera = 0;
		while (espera < (Integer.parseInt(environment.getUIEnvConfigs().getTimeOutTime()) * 1000)) {
			try {
				c = driver.findElement(campo);
				return c;
			}
			catch (Exception e) {
				campo = null;
			}
			espera = espera + 1000;
			try {
				Thread.sleep(1000);
			}catch (Exception e1) {}
		}
		return c;
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Espera um campo ficar visível em tela ou ficar habilitado.<br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement buscar = uiTools.locateWebElement(By.xpath("//input[@title='Pesquisar']")) <br>
	 * uiTools.waitFieldEnableOrDisplayed(buscar);
	 * </code>
	 * @param campo [WebElement] = Elemento do tipo WebElement.
	 * @return Não possui nenhum retorno.
	**/
	public UiUtilities waitFieldEnableOrDisplayed(WebElement campo) {
		int espera = 0;
		while (espera < (Integer.parseInt(environment.getUIEnvConfigs().getTimeOutTime()) * 1000)) {
			try {
				if (campo.isDisplayed()) {
					return new UiUtilities();
				}
				if (campo.isEnabled()) {
					return new UiUtilities();
				}
			}catch (Exception e) {
				TestLogger.logInfo("Estouro de Tempo ao Tentar Localizar campo! Erro: " + e.getMessage());
			}
			espera = espera + 1000;
			try {
				Thread.sleep(1000);
			}catch (Exception e1) {}
		}
		fail("Estouro de Tempo ao Tentar Localizar campo!");
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Espera um campo ficar visível em tela.<br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement buscar = uiTools.locateWebElement(By.xpath("//input[@title='Pesquisar']")) <br>
	 * uiTools.waitFieldDisplayed(buscar);
	 * </code>
	 * @param campo [WebElement] = Elemento do tipo WebElement.
	 * @return Não possui nenhum retorno.
	**/
	public UiUtilities waitFieldDisplayed(WebElement campo) {
		int espera = 0;
		while (espera < (Integer.parseInt(environment.getUIEnvConfigs().getTimeOutTime()) * 1000)) {
			try {
				if (campo.isDisplayed()) {
					return new UiUtilities();
				}
			}catch (Exception e) {
				TestLogger.logInfo("Estouro de Tempo ao Tentar Localizar campo! Erro: " + e.getMessage());
			}
			espera = espera + 1000;
			try {
				Thread.sleep(1000);
			}catch (Exception e1) {}
		}
		fail("Estouro de Tempo ao Tentar Localizar campo!");
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Espera um campo ficar habilitado.<br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement buscar = uiTools.locateWebElement(By.xpath("//input[@title='Pesquisar']"))<br>
	 * uiTools.waitFieldEnabled(buscar);
	 * </code>
	 * @param campo [WebElement] = Elemento do tipo WebElement.
	 * @return Não possui nenhum retorno.
	**/
	public UiUtilities waitFieldEnabled(WebElement campo) {
		int espera = 0;
		while (espera < (Integer.parseInt(environment.getUIEnvConfigs().getTimeOutTime()) * 1000)) {
			try {
				if (campo.isEnabled()) {
					return new UiUtilities();
				}
			}catch (Exception e) {
				TestLogger.logInfo("Estouro de Tempo ao Tentar Localizar campo! Erro: " + e.getMessage());
			}
			espera = espera + 1000;
			try {
				Thread.sleep(1000);
			}catch (Exception e1) {}
		}
		fail("Estouro de Tempo ao Tentar Localizar campo!");
		return new UiUtilities();
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Navegar ate uma URL específica.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * uiTools.navegateTo(driver,"www.google.com.br");
	 * </code>
	 *	@param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 *	@param url [String] = Link qual será direcionado.
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities navegateTo(WebDriver driver, String url) {
		driver.get(url);
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Navegar ate uma URL específica.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * uiTools.navegateTo("www.google.com.br");
	 * </code>
	 *	@param url [String] = Link qual será direcionado.
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities navegateTo(String url) {
		driver.get(url);
		return new UiUtilities();
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Maximizar a janela do navegador.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * uiTools.maximizeBrowser(driver);
	 * </code>
	 *	@param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
		return new UiUtilities();
		
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Maximizar a janela do navegador.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * uiTools.maximizeBrowser();
	 * </code>
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities maximizeBrowser() {
		driver.manage().window().maximize();
		return new UiUtilities();
		
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Maximizar a janela do navegador e deixar como fullscreen.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * uiTools.maximizeBrowser(driver, true);
	 * </code>
	 *	@param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 *	@param serFullScreen [boolean] = true para maximar como FullScreen ou false para apenas maximizar.
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities maximizeBrowser(WebDriver driver, boolean serFullScreen) {
		driver.manage().window().maximize();
		if (serFullScreen) {
			driver.manage().window().fullscreen();
		}
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Maximizar a janela do navegador e deixar como fullscreen.<br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * uiTools.maximizeBrowser(true);
	 * </code>
	 *	@param serFullScreen [boolean] = true para maximar como FullScreen ou false para apenas maximizar.
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities maximizeBrowser(boolean serFullScreen) {
		driver.manage().window().maximize();
		if (serFullScreen) {
			driver.manage().window().fullscreen();
		}
		return new UiUtilities();
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Esperar até que a janela esteja visivel na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campo = uiTools.locateWebElement(By.id("Pesquisar"));
	 * uiTools.waitField(driver, campo, 1500, false);
	 * </code>
	 * <br><br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 *	@param timeOut [int] = Tempo em milisegundos que a rotina levará em conta para a espera.
	 *	@param falhar [boolean] = Caso o elemento não for encontrado caso deverá falhar ? True para sim e False para não (True Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities waitField(WebDriver driver,By campo,int timeOut,Boolean falhar) {
		try {
			WebDriverWait esperar = new WebDriverWait(driver, timeOut);
			esperar.until(ExpectedConditions.presenceOfElementLocated(campo));
		}catch (Exception e) {
			if (falhar) {
				TestLogger.logInfo("Estouro de Tempo ao Tentar Localizar campo! /n Mensagem: " + e.getMessage());
			}
		}
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Esperar até que a janela esteja visivel na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campo = uiTools.locateWebElement(By.id("Pesquisar"));
	 * uiTools.waitField(campo, 1500, false);
	 * </code>
	 * <br><br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 *	@param timeOut [int] = Tempo em milisegundos que a rotina levará em conta para a espera.
	 *	@param falhar [boolean] = Caso o elemento não for encontrado caso deverá falhar ? True para sim e False para não (True Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities waitField(By campo,int timeOut,Boolean falhar) {
		try {
			WebDriverWait esperar = new WebDriverWait(driver, timeOut);
			esperar.until(ExpectedConditions.presenceOfElementLocated(campo));
		}catch (Exception e) {
			if (falhar) {
				TestLogger.logInfo("Estouro de Tempo ao Tentar Localizar campo! /n Mensagem: " + e.getMessage());
			}
		}
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Esperar até que a janela esteja visivel na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campo = uiTools.locateWebElement(By.id("Pesquisar"));
	 * uiTools.waitField(driver, campo, false);
	 * </code>
	 * <br><br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 *	@param falhar [boolean] = Caso o elemento não for encontrado caso deverá falhar ? True para sim e False para não (True Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities waitField(WebDriver driver, By campo, Boolean falhar) {
		int timeOut = Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime());
		try {
			WebDriverWait esperar = new WebDriverWait(driver, timeOut);
			esperar.until(ExpectedConditions.presenceOfElementLocated(campo));
		}catch (Exception e) {
			if (falhar) {
				TestLogger.logInfo("Estouro de Tempo ao Tentar Localizar campo! /n Mensagem: "+e.getMessage());
			}
		}
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Esperar até que a janela esteja visivel na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campo = uiTools.locateWebElement(By.id("Pesquisar"));
	 * uiTools.waitField(campo, false);
	 * </code>
	 * <br><br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 *	@param falhar [boolean] = Caso o elemento não for encontrado caso deverá falhar ? True para sim e False para não (True Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities waitField(By campo, Boolean falhar) {
		int timeOut = Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime());
		try {
			WebDriverWait esperar = new WebDriverWait(driver, timeOut);
			esperar.until(ExpectedConditions.presenceOfElementLocated(campo));
		}catch (Exception e) {
			if (falhar) {
				TestLogger.logInfo("Estouro de Tempo ao Tentar Localizar campo! /n Mensagem: "+e.getMessage());
			}
		}
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Esperar até que a janela esteja visivel na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campo = uiTools.locateWebElement(By.id("Pesquisar"));
	 * uiTools.waitField(driver, campo, false);
	 * </code>
	 * <br><br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 *	@param falhar [boolean] = Caso o elemento não for encontrado caso deverá falhar ? True para sim e False para não (True Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities waitField(WebDriver driver, WebElement campo, Boolean falhar) {
		try {
			waitFieldEnableOrDisplayed(campo);
			return new UiUtilities();
		}catch (Exception e) {
			if (falhar) {
				TestLogger.logInfo("Estouro de Tempo ao Tentar Localizar campo! /n Mensagem: "+e.getMessage());
			}
		}
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Esperar até que a janela esteja visivel na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campo = uiTools.locateWebElement(By.id("Pesquisar"));
	 * uiTools.waitField(campo, false);
	 * </code>
	 * <br><br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 *	@param falhar [boolean] = Caso o elemento não for encontrado caso deverá falhar ? True para sim e False para não (True Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities waitField(WebElement campo, Boolean falhar) {
		try {
			waitFieldEnableOrDisplayed(campo);
			return new UiUtilities();
		}catch (Exception e) {
			if (falhar) {
				TestLogger.logInfo("Estouro de Tempo ao Tentar Localizar campo! /n Mensagem: "+e.getMessage());
			}
		}
		return new UiUtilities();
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Esperar até que a janela esteja visivel e carregada na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * uiTools.waitPage(driver, 1500, false);
	 * </code>
	 * <br><br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 *	@param timeOut [int] = Tempo em milisegundos que a rotina levará em conta para a espera.
	 *	@param falhar [boolean] = Falha caso não encontre o campo. (True como Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities waitPage(WebDriver driver, int timeOut, Boolean falhar) {
		try {
			ExpectedCondition<Boolean> pageLoad = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver navegador) {
					return ((JavascriptExecutor) navegador).executeScript("return document.readyState").toString().equals("complete");
				};				
			};
			WebDriverWait esperar = new WebDriverWait(driver, timeOut);
			esperar.until(pageLoad);
		}catch (Exception e) {
			if (falhar) {
				TestLogger.logInfo("Estouro de Tempo ao esperar página! /n Mensagem: "+e.getMessage());
			}
		}
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Esperar até que a janela esteja visivel e carregada na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * uiTools.waitPage(1500, false);
	 * </code>
	 * <br><br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param timeOut [int] = Tempo em milisegundos que a rotina levará em conta para a espera.
	 *	@param falhar [boolean] = Falha caso não encontre o campo. (True como Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities waitPage(int timeOut, Boolean falhar) {
		try {
			ExpectedCondition<Boolean> pageLoad = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver navegador) {
					return ((JavascriptExecutor) navegador).executeScript("return document.readyState").toString().equals("complete");
				};				
			};
			WebDriverWait esperar = new WebDriverWait(driver, timeOut);
			esperar.until(pageLoad);
		}catch (Exception e) {
			if (falhar) {
				TestLogger.logInfo("Estouro de Tempo ao esperar página! /n Mensagem: "+e.getMessage());
			}
		}
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Esperar até que a janela esteja visivel e carregada na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * uiTools.waitPage(driver, false);
	 * </code>
	 * <br><br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 *	@param falhar [boolean] = Falha caso não encontre o campo. (True como Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities waitPage(WebDriver driver, Boolean falhar) {
		try {
			ExpectedCondition<Boolean> pageLoad = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver navegador) {
					return ((JavascriptExecutor) navegador).executeScript("return document.readyState").toString().equals("complete");
				};				
			};
			WebDriverWait esperar = new WebDriverWait(driver, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()));
			esperar.until(pageLoad);
		}catch (Exception e) {
			if (falhar) {
				TestLogger.logInfo("Estouro de Tempo ao esperar página! /n Mensagem: "+e.getMessage());
			}
		}
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Esperar até que a janela esteja visivel e carregada na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * uiTools.waitPage(false);
	 * </code>
	 * <br><br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param falhar [boolean] = Falha caso não encontre o campo. (True como Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities waitPage(Boolean falhar) {
		try {
			ExpectedCondition<Boolean> pageLoad = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver navegador) {
					return ((JavascriptExecutor) navegador).executeScript("return document.readyState").toString().equals("complete");
				};				
			};
			WebDriverWait esperar = new WebDriverWait(driver, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()));
			esperar.until(pageLoad);
		}catch (Exception e) {
			if (falhar) {
				TestLogger.logInfo("Estouro de Tempo ao esperar página! /n Mensagem: "+e.getMessage());
			}
		}
		return new UiUtilities();
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Clicar em algum elemento na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement botao = uiTools.locateWebElement(By.id("salvar")); <br>
	 * uiTools.click(driver, botao, false);
	 * </code>
	 * <br><br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 *	@param falhar [boolean] = Falha caso não encontre o campo. (True como Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities click(WebDriver driver, By campo, Boolean falhar) {
		WebElement field;
		waitField(driver, campo,Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), falhar);
		field = driver.findElement(campo);
		field.click();
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Clicar em algum elemento na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement botao = uiTools.locateWebElement(By.id("salvar")); <br>
	 * uiTools.click(driver, botao);
	 * </code>
	 *	@param driver [WebDriver] = O client que executará os testes, geralmente o Selenium.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities click(WebDriver driver, By campo) {
		WebElement field;
		boolean falhar = true;
		waitField(driver, campo, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), falhar);
		field = driver.findElement(campo);
		field.click();
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Clicar em algum elemento na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement botao = uiTools.locateWebElement(By.id("salvar"));<br>
	 * uiTools.click(botao);
	 * </code>
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities click(WebElement campo) {
		waitFieldEnableOrDisplayed(campo);
		campo.click();
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Clicar em algum elemento na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement botao = uiTools.locateWebElement(By.id("salvar"));<br>
	 * uiTools.click(botao, false);
	 * </code>
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 *	@param falhar [boolean] = Falha caso não encontre o campo. (True como Default).
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities click(By campo, Boolean falhar) {
		WebElement field;
		waitField(driver, campo,Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), falhar);
		field = driver.findElement(campo);
		field.click();
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Clicar em algum elemento na tela. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement botao = uiTools.locateWebElement(By.id("salvar"));<br>
	 * uiTools.click(botao);
	 * </code>
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities click(By campo) {
		WebElement field;
		boolean falhar = true;
		waitField(driver, campo, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), falhar);
		field = driver.findElement(campo);
		field.click();
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Pressionar Enter em algum campo. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement botao = uiTools.locateWebElement(By.id("salvar"));<br>
	 * uiTools.setKeyEnter(botao);
	 * </code>
	 * <br> <br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param driver [WebDriver] =  O client que executará os testes, geralmente o Selenium.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities setKeyEnter(WebDriver driver, By campo) {
		boolean falhar = true;
		waitField(driver, campo, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), falhar);
		driver.findElement(campo).sendKeys(Keys.ENTER);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Pressionar Enter em algum campo. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement botao = uiTools.locateWebElement(By.id("salvar"));<br>
	 * uiTools.setKeyEnter(botao);
	 * </code>
	 * <br> <br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities setKeyEnter(By campo) {
		boolean falhar = true;
		waitField(driver, campo, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), falhar);
		driver.findElement(campo).sendKeys(Keys.ENTER);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Preenche o campo com um valor ou texto. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement botao = uiTools.locateWebElement(By.id("salvar"));<br>
	 * uiTools.setKeys(driver, Keys.ARROW_UP, botao);
	 * </code>
	 * <br> <br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param driver [WebDriver] =  O client que executará os testes, geralmente o Selenium.
	 *	@param key [Keys] = Um caractere que represente uma Key.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities setKeys(WebDriver driver, Keys key, By campo) {
		boolean falhar = true;
		waitField(driver, campo, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), falhar);
		driver.findElement(campo).sendKeys(key);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Preenche o campo com um valor ou texto. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement botao = uiTools.locateWebElement(By.id("salvar"));<br>
	 * uiTools.setKeys(Keys.ARROW_UP, botao);
	 * </code>
	 * <br> <br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param key [Keys] = Um caractere que represente uma Key.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities setKeys(Keys key, By campo) {
		boolean falhar = true;
		waitField(driver, campo, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), falhar);
		driver.findElement(campo).sendKeys(key);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Preenche o campo com um valor ou texto. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campo = uiTools.locateWebElement(By.id("nome"));<br>
	 * uiTools.setKeys(driver, "Teste", campo);
	 * </code>
	 * <br> <br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param driver [WebDriver] =  O client que executará os testes, geralmente o Selenium.
	 *	@param key [String] =  Texto qual o campo receberá.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities setKeys(WebDriver driver, String key, By campo) {
		boolean falhar = true;
		waitField(driver, campo, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), falhar);
		driver.findElement(campo).sendKeys(key);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Preenche o campo com um valor ou texto. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campo = uiTools.locateWebElement(By.id("salvar"));<br>
	 * uiTools.setKeys("Teste", campo);
	 * </code>
	 * <br> <br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param key [String] =  Texto qual o campo receberá
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities setKeys(String key, By campo) {
		boolean falhar = true;
		waitField(driver, campo, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), falhar);
		driver.findElement(campo).sendKeys(key);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Preenche o campo com um valor ou texto. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campo = uiTools.locateWebElement(By.id("nome"));<br>
	 * uiTools.setKeys(Keys.ARROW ,campo);
	 * </code>
	 * <br> <br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param key [Keys] = Um caractere que represente uma Key.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities setKeys(Keys key, WebElement campo) {
		waitFieldEnableOrDisplayed(campo);
		campo.sendKeys(key);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	/**	
	 * <b> Definição: </b> <br>
	 * Preenche o campo com um valor ou texto. <br><br>
	 * <b>Exemplo</b> <br>
	 * <code>
	 * WebElement campo = uiTools.locateWebElement(By.id("nome"));<br>
	 * uiTools.setKeys("Teste" ,campo);
	 * </code>
	 * <br> <br> Links de Referencia: <a href="https://www.techbeamers.com/findelement-and-findelements-commands-examples/">Findelement and Findelements Commands Examples</a>.
	 *	@param key [String] =  Texto qual o campo receberá.
	 *	@param campo [By] = Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']") .
	 * @return Retorna o UiUtilities para uma nova chamada.
	**/
	public UiUtilities setKeys(String key, WebElement campo) {
		waitFieldEnableOrDisplayed(campo);
		campo.sendKeys(key);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}


	public UiUtilities selectOptionCombo(WebDriver driver, By campo, int indexOption) {
		WebElement c = locateWebElement(driver, campo);
		waitFieldEnableOrDisplayed(c);
		Select elemento = new Select(c);
		elemento.selectByIndex(indexOption);
		return new UiUtilities();
	}
	public UiUtilities selectOptionCombo(By campo, int indexOption) {
		WebElement c = locateWebElement(driver, campo);
		waitFieldEnableOrDisplayed(c);
		Select elemento = new Select(c);
		elemento.selectByIndex(indexOption);
		return new UiUtilities();
	}
	public UiUtilities selectOptionCombo(WebDriver driver, By campo, String nameOption) {
		WebElement c = locateWebElement(driver, campo);
		waitFieldEnableOrDisplayed(c);
		Select elemento = new Select(c);
		elemento.selectByValue(nameOption);
		return new UiUtilities();
	}
	public UiUtilities selectOptionCombo(By campo, String nameOption) {
		WebElement c = locateWebElement(driver, campo);
		waitFieldEnableOrDisplayed(c);
		Select elemento = new Select(c);
		elemento.selectByValue(nameOption);
		return new UiUtilities();
	}
	public UiUtilities selectOptionCombo(WebElement campo, int indexOption) {
		waitFieldEnableOrDisplayed(campo);
		Select elemento = new Select(campo);
		elemento.selectByIndex(indexOption);
		return new UiUtilities();
	}
	public UiUtilities selectOptionCombo(WebElement campo, String nameOption) {
		waitFieldEnableOrDisplayed(campo); 
		Select elemento = new Select(campo);
		elemento.selectByValue(nameOption);
		return new UiUtilities();
	}


	/**	Objetivo: Atualizar a pagina atual.
	 * 	<br>
	 *	@param driver = (WebDriver) O client que executará os testes, geralmente o Selenium.
	 *	@param timeout = (int) Número do frame, pode ser localizado ao usar o Xpath, por default 0.
	 *	@param falhar = (boolean) Caso o elemento não for encontrado caso deverá falhar ? True para sim e False para não (True Default).
	**/
	public UiUtilities refreshPage(WebDriver driver, int timeout, boolean falhar) {
		driver.navigate().refresh();
		waitPage(driver, timeout, true);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	public UiUtilities refreshPage(int timeout, boolean falhar) {
		driver.navigate().refresh();
		waitPage(driver, timeout, true);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	public UiUtilities refreshPage(WebDriver driver, boolean falhar) {
		driver.navigate().refresh();
		waitPage(driver, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), true);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	public UiUtilities refreshPage(boolean falhar) {
		driver.navigate().refresh();
		waitPage(driver, Integer.valueOf(environment.getUIEnvConfigs().getTimeOutTime()), true);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}

	/**	Objetivo: Trocar o frame para localizar os objetos do mesmo.
	 * 	<br>
	 *	@param driver = (WebDriver) O client que executará os testes, geralmente o Selenium..
	 *	@param frameId = (String) Id do frame, pode ser localizado ao usar o Xpath, por default seta 0 para retornar ao principal.
	**/
	public UiUtilities switchFrame(WebDriver driver, String frameId) {
		try {
			driver.switchTo().defaultContent();			
		}catch (Exception e) {
			TestLogger.logInfo("Erro ao trocar o Frame!");
		}
		driver.switchTo().frame(frameId);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	public UiUtilities switchFrame(String frameId) {
		try {
			driver.switchTo().defaultContent();			
		}catch (Exception e) {
			TestLogger.logInfo("Erro ao trocar o Frame!");
		}
		driver.switchTo().frame(frameId);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	public UiUtilities switchFrame(WebDriver driver, int frameNumber) {
		try {
			driver.switchTo().defaultContent();			
		}catch (Exception e) {
			TestLogger.logInfo("Erro ao trocar o Frame!");
		}
		driver.switchTo().frame(frameNumber);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	public UiUtilities switchFrame(int frameNumber) {
		try {
			driver.switchTo().defaultContent();			
		}catch (Exception e) {
			TestLogger.logInfo("Erro ao trocar o Frame!");
		}
		driver.switchTo().frame(frameNumber);
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	public UiUtilities switchFrame(WebDriver driver, WebElement elementoDoFrame) {
		try {
			driver.switchTo().defaultContent();			
			driver.switchTo().frame(elementoDoFrame);
		}catch (Exception e) {
			TestLogger.logInfo("Erro ao trocar o Frame!");
		}
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	public UiUtilities switchFrame(WebElement elementoDoFrame) {
		try {
			driver.switchTo().defaultContent();			
			driver.switchTo().frame(elementoDoFrame);
		}catch (Exception e) {
			TestLogger.logInfo("Erro ao trocar o Frame!");
		}
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	public UiUtilities switchDefaultFrame(WebDriver driver) {
		try {
			driver.switchTo().parentFrame();			
		}catch (Exception e) {
			TestLogger.logInfo("Erro ao trocar o Frame!");
		}
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}
	public UiUtilities switchDefaultFrame() {
		try {
			driver.switchTo().parentFrame();			
		}catch (Exception e) {
			TestLogger.logInfo("Erro ao trocar o Frame!");
		}
		sleep(Integer.valueOf(environment.getUIEnvConfigs().getSleepTime()));
		return new UiUtilities();
	}

	/**	Objetivo: Tempo de espera até executar outra ação.
	 * 	<br>
	**/
	public UiUtilities sleep() {
		int tempo = Integer.valueOf(environment.getUIEnvConfigs().getSleepTime());
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new UiUtilities();
	}
	public UiUtilities sleep(int timeout) {
		long tempo = timeout;
		if(tempo < 1) {
			tempo = Integer.valueOf(environment.getUIEnvConfigs().getSleepTime());
		}
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new UiUtilities();
	}


	/**	Objetivo: Retornar o texto ou valor de um campo.
	 *	<br>
	 * @param driver = (WebDriver) O client que executará os testes, geralmente o Selenium.
	 * @param campo = (By) Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 * @return Retorna uma string com o valor do campo.
	**/
	public String getTextField(WebDriver driver, By campo) {
		String texto;
		WebElement field;
		field = driver.findElement(campo);
		if (field.getAttribute("value").toString() == "" || field.getAttribute("value").toString() == null) {
			texto = field.getText();
			return texto;
		}
		texto = field.getAttribute("value").toString();
		return texto;
	}
	public String getTextField(By campo) {
		String texto;
		WebElement field;
		field = driver.findElement(campo);
		if (field.getAttribute("value").toString() == "" || field.getAttribute("value").toString() == null) {
			texto = field.getText();
			return texto;
		}
		texto = field.getAttribute("value").toString();
		return texto;
	}
	public String getTextField(WebElement campo) {
		if (campo.getAttribute("value").toString() == "" || campo.getAttribute("value").toString() == null) {
			return campo.getText();
		}
		return campo.getAttribute("value").toString();
	}


	/**	Objetivo: Retornar o se o campo existe e está visivel.
	 *	<br>
	 * @param driver = (WebDriver) O client que executará os testes, geralmente o Selenium.
	 * @param campo = (By) Campo a ser validade na definição de By, exemplo: By.xpath("//input[@title='Pesquisar']").
	 * @return Retorna o valor booleano true se o campo for visível e selecionavel e false se o campo não estiver em tela.
	**/
	public boolean isDisplayed(WebDriver driver, By campo) {
		WebElement field;
		if (driver.findElements(campo).size() == 0) {
			return false;
		}
		field = driver.findElement(campo);
		if (!field.isDisplayed()) {
			return false;
		}
		return true;
	}
	public boolean isDisplayed(By campo) {
		WebElement field;
		if (driver.findElements(campo).size() == 0) {
			return false;
		}
		field = driver.findElement(campo);
		if (!field.isDisplayed()) {
			return false;
		}
		return true;
	}
	public boolean isDisplayed(WebElement campo) {
		if (!campo.isDisplayed()) {
			return false;
		}
		return true;
	}


	public boolean isEnabled(WebDriver driver, By campo) {
		WebElement field;
		if (driver.findElements(campo).size() == 0) {
			return false;
		}
		field = driver.findElement(campo);
		if (!field.isEnabled()) {
			return false;
		}
		return true;
	}
	public boolean isEnabled(By campo) {
		WebElement field;
		if (driver.findElements(campo).size() == 0) {
			return false;
		}
		field = driver.findElement(campo);
		if (!field.isEnabled()) {
			return false;
		}
		return true;
	}
	public boolean isEnabled(WebElement campo) {
		if (!campo.isEnabled()) {
			return false;
		}
		return true;
	}


}