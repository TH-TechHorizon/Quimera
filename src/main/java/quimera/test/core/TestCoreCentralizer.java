package quimera.test.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import quimera.test.core.engine.TestEngine;
import quimera.test.utilities.DataBaseUtilities;
import quimera.test.utilities.UiUtilities;

/**	
 * <b> Definição: </b> <br>
 * Classe de comunicação entre as classe TestApiExtension e o TestEngine. 
 * <br>
**/
public class TestCoreCentralizer extends TestEngine {

	/**
	 * <b> Definição: </b> <br>
	 * Variável para autorização.
	 **/
	protected static String authorizationBearer;
	/**
	 * <b> Definição: </b> <br>
	 * WebDriver padrão utilizado durante os testes.
	 **/
	protected static WebDriver driver = null;
	/**
	 * <b> Definição: </b> <br>
	 * Biblioteca de utilitários para testes de interface.
	 **/
	protected static UiUtilities uiTool = new UiUtilities();
	/**
	 * <b> Definição: </b> <br>
	 * Utilitário para efetuar selects.
	 **/
	protected static DataBaseUtilities.Select select = new DataBaseUtilities.Select();
	/**
	 * <b> Definição: </b> <br>
	 * Utilitário para efetuar updates, deletes e outras actions.
	 **/
	protected static DataBaseUtilities.Update update = new DataBaseUtilities.Update();

	@BeforeTest
	public void initialEngine() {
		getEnvironment();
	}
	
}