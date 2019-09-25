package test.api.core;

import org.testng.annotations.BeforeClass;

import test.api.utilities.DataBaseUtilities;

/**	
 * Classe de comunicação entre as classe TestApiExtension e o TestEngine.
 * <br>
 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/TestCoreCentralizer#testcorecentralizer">TestCoreCentralizer</a>
**/
public class TestCoreCentralizer extends TestEngine {

	protected static String authorizationBearer;
	protected static TestAuthentication autenticacaoPlataforma = new TestAuthentication();
	protected static DataBaseUtilities.Select select = new DataBaseUtilities.Select();
	protected static DataBaseUtilities.Update update = new DataBaseUtilities.Update();

	@BeforeClass
	public void initialEngine() {
		getEnvironmentDefaults();
	}
	
}