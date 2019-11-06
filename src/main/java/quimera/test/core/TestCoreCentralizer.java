package quimera.test.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import quimera.test.core.engine.TestEngine;
import quimera.test.utilities.DataBaseUtilities;
import quimera.test.utilities.UiUtilities;

/**	
 * Classe de comunicação entre as classe TestApiExtension e o TestEngine.
 * <br>
**/
public class TestCoreCentralizer extends TestEngine {

	protected static String authorizationBearer;
	protected static WebDriver driver = null;
	protected static UiUtilities uiTool = new UiUtilities();
	protected static DataBaseUtilities.Select select = new DataBaseUtilities.Select();
	protected static DataBaseUtilities.Update update = new DataBaseUtilities.Update();

	@BeforeTest
	public void initialEngine() {
		getEnvironment();
	}
	
}