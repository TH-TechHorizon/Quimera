package senior.quimera.core;

import org.openqa.selenium.WebDriver;

import senior.quimera.utilities.DataBaseUtilities;

/**	Engine inicial para AmbientDefault e validações primárias dos testes. **/

public class Core extends Engine {

	protected static String authorizationBearer;
	protected static TestAuthentication autenticacaoPlataforma = new TestAuthentication();
	protected static DataBaseUtilities.Select select = new DataBaseUtilities.Select();
	protected static DataBaseUtilities.Update update = new DataBaseUtilities.Update();

	protected static WebDriver driver = null;

}