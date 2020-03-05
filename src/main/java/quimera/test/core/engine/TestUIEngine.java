package quimera.test.core.engine;

import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;

/**	
 * Este é o coração da automação, com os métodos e propriedades principais.
 * <br>
 * O TestEngine tem como responsabilidade dar o Start inicial para os testes, capturar as informações padrões do TestEnvironmentConfigurationFile.Json e armazenar em uma propriedade do tipo TestEnvironment.
 * <br>
**/
public class TestUIEngine extends TestCoreCentralizer {
	
	public static WebDriver iniciarNavegador(WebDriver driver) {
		if (environment.getUIEnvConfigs().getNavegador().contains("chrome")) {
			driver = beginChromeDriver(driver);
		}
		if (environment.getUIEnvConfigs().getNavegador().contains("firefox")) {
			driver = beginFirefoxDriver(driver);
		}
		uiTool.navegateTo(driver, environment.getUIEnvConfigs().getUrlInitial());
		if (environment.getUIEnvConfigs().getMaximizarNavegador().contains("true")) {
			uiTool.maximizeBrowser(driver);
		}
		return driver;
	}

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