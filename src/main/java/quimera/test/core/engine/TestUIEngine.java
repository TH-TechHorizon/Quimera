package quimera.test.core.engine;

import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;

/**	
 * <b> Definição: </b> <br>
 * Esta classe tem como objetivo ser a engrenagem por trás da incialização dos navegadores, além disso, é responsável por definir o caminho dos drivers para cada Sistema Operacional. 
 * <br>
**/
public class TestUIEngine extends TestCoreCentralizer {

	/**	
	 * <b> Definição: </b> <br>
	 * Função com o objetivo de iniciar o navegador definido nas configurações, usando os parâmetros também lá definidos.
	 * @param driver [WebDriver] = Driver do selenium, geralmente definido no  definido TestCoreCentralizer.
	 * @return retorna o driver atualizado com o navegador atualizado. 
	 * <br>
	**/
	public static WebDriver iniciarNavegador(WebDriver driver) {
		if (environment.getUIEnvConfigs().getNavegador().contains("chrome")) {
			driver = beginChromeDriver(driver);
		}
		if (environment.getUIEnvConfigs().getNavegador().contains("firefox")) {
			driver = beginFirefoxDriver(driver);
		}
		if (environment.getUIEnvConfigs().getNavegador().contains("edgeChromium")) {
			driver = beginEdgeChromiumDriver(driver);
		}
		uiTool.navegateTo(driver, environment.getUIEnvConfigs().getUrlInitial());
		if (environment.getUIEnvConfigs().getMaximizarNavegador().contains("true")) {
			uiTool.maximizeBrowser(driver);
		}
		return driver;
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Fecha o navegador, também o processo do driver atrelado ao mesmo.
	 * @param driver [WebDriver] = Driver do Selenium geralmente definido no TestCoreCentralizer. 
	 * @return Não possui retorno. 
	 * <br>
	**/
	public static void fecharNavegador(WebDriver driver) {
		try {
			driver.close();
			driver.quit();
		}catch (Exception e) {
			TestLogger.logInfo("Erro ao tentar fechar navegador: " + e.getMessage());
		}
	}

	private static WebDriver beginChromeDriver(WebDriver driver) {
		ChromeOptions chromeOptions = new ChromeOptions();
		if (!environment.getUIEnvConfigs().getExibirNavegador().toLowerCase().contains("true")) {
			chromeOptions.addArguments("--headless");
		}
		if (OsCheck.OSType.Windows.equals(OsCheck.getOperatingSystemType())) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			if (environment.getUIEnvConfigs().getChromeDriverPath() != "") {
				System.setProperty("webdriver.chrome.driver",environment.getUIEnvConfigs().getChromeDriverPath());
			}
		}else {
			System.setProperty("webdriver.chrome.driver","chromedriver");
			if (environment.getUIEnvConfigs().getChromeDriverPath() != "") {
				System.setProperty("webdriver.chrome.driver",environment.getUIEnvConfigs().getChromeDriverPath().replace(".exe", ""));				
			}
		}
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	private static WebDriver beginFirefoxDriver(WebDriver driver) {
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		FirefoxOptions firefoxOptions = new FirefoxOptions();

		if (!environment.getUIEnvConfigs().getExibirNavegador().toLowerCase().contains("true")) {
			firefoxBinary.addCommandLineOptions("--headless");
			firefoxOptions.setBinary(firefoxBinary);
		}
		if (OsCheck.OSType.Windows.equals(OsCheck.getOperatingSystemType())) {
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			if (environment.getUIEnvConfigs().getGeckoDriverPath() != "") {
				System.setProperty("webdriver.gecko.driver",environment.getUIEnvConfigs().getGeckoDriverPath());
			}
		}else {
			System.setProperty("webdriver.gecko.driver","geckodriver");
			if (environment.getUIEnvConfigs().getGeckoDriverPath() != "") {
				System.setProperty("webdriver.gecko.driver",environment.getUIEnvConfigs().getGeckoDriverPath().replace(".exe", ""));				
			}
		}
		driver = new FirefoxDriver(firefoxOptions);
		return driver;
	}
	
	private static WebDriver beginEdgeChromiumDriver(WebDriver driver) {
		EdgeOptions edgeOptions = new EdgeOptions();
		ChromeOptions chromiumOptions = new ChromeOptions();

		if (!environment.getUIEnvConfigs().getExibirNavegador().toLowerCase().contains("true")) {
			chromiumOptions.addArguments("--headless");
			edgeOptions.merge(chromiumOptions);
		}
		if (OsCheck.OSType.Windows.equals(OsCheck.getOperatingSystemType())) {
			if (environment.getUIEnvConfigs().getDriverPath() != "") {
				if (environment.getUIEnvConfigs().getDriverPath().endsWith("\\")){
					System.setProperty("webdriver.edge.driver", environment.getUIEnvConfigs().getDriverPath() + "msedgedriver.exe");					
				}else {
					System.setProperty("webdriver.edge.driver", environment.getUIEnvConfigs().getDriverPath() + "\\msedgedriver.exe");
				}
			}else {
				System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			}
		}else {
			if (environment.getUIEnvConfigs().getDriverPath() != "") {
				if (environment.getUIEnvConfigs().getDriverPath().endsWith("\\")){
					System.setProperty("webdriver.edge.driver", environment.getUIEnvConfigs().getDriverPath() + "msedgedriver");			
				}else {
					System.setProperty("webdriver.edge.driver", environment.getUIEnvConfigs().getDriverPath() + "\\msedgedriver");
				}
			}else {
				System.setProperty("webdriver.edge.driver","msedgedriver");	
			}
		}
		driver = new EdgeDriver(edgeOptions);
		return driver;
	}


	private static final class OsCheck {
		/**	Tipos de sistema operacional **/
		public enum OSType {
			Windows, MacOS, Linux, Other
		};
		protected static OSType detectedOS;
		/**	Detecta o sistema operacional, a partir da propriedade os.name
		 *	@returns - O sistema operacional
		**/
		public static OSType getOperatingSystemType() {
			if (detectedOS == null) {
				String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
				if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
					detectedOS = OSType.MacOS;
				} else if (OS.indexOf("win") >= 0) {
					detectedOS = OSType.Windows;
				} else if (OS.indexOf("nux") >= 0) {
					detectedOS = OSType.Linux;
				} else {
					detectedOS = OSType.Other;
				}
			}
			return detectedOS;
		  }
	}

}