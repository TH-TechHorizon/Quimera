package test.api.core;

import test.api.utilities.DataBaseUtilities;

/**	Engine inicial para AmbientDefault e validações primárias dos testes. **/

public class TestCoreCentralizer extends TestEngine {

	protected static String authorizationBearer;
	protected static TestAuthentication autenticacaoPlataforma = new TestAuthentication();
	protected static DataBaseUtilities.Select select = new DataBaseUtilities.Select();
	protected static DataBaseUtilities.Update update = new DataBaseUtilities.Update();

}