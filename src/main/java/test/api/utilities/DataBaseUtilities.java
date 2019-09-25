package test.api.utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import test.api.core.TestConnection;
import test.api.core.TestCoreCentralizer;
import test.api.core.TestEnvironment;
import test.api.core.TestLogger;


/**	
 * O DataBaseUtilities tem como objetivo auxiliar a comunicação com o banco de dados.
 * <br>
 * Estas sub classes tem como objetivo ser lar de métodos facilitadores, como métodos para efetuar updates, deletes e métodos para selects mais facilitados onde não é necessário nem configurar as conexões.
 * <br>
 * Também permite configurar qual o banco a ser conectado, o usuário a ser utilizado entre outros.
 * <br>
 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities">DataBaseUtilities</a>
**/
public class DataBaseUtilities extends TestCoreCentralizer {

	private static void logInfoError(String error) {
		TestLogger.logInfo("Ocorreu erro ao tentar efetuar Select ou Update na base de dados: " + error);
	}
	private static ResultSet getResultSet(TestConnection con, String query) throws SQLException {
		return con.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(query);
	}
	private static TestConnection connectionDatabase(TestEnvironment.DataBasesConfig configuracaoDeConexao){
		TestEnvironment.DataBasesConfig db = configuracaoDeConexao;
		return new TestConnection(db.getDatabaseType(), db.getHost(), db.getPort(), db.getBase(), db.getSchemaName(), db.getUsuario(), db.getSenha());
	}
	private static void update(TestConnection con, String query) throws SQLException{
		con.connect();
		PreparedStatement update = con.getCon().prepareStatement(query);
		update.executeUpdate();
		con.disconect();
	}

	/**	
	 * A classe DataBaseUtilities.Select tem como o principal objetivo facilitar o uso do select no banco de dados.
	 * <br>
	 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Select">DataBaseUtilities.Select</a>
	**/
	public static class Select{
	
		/**	Objetivo: Busca um resultado de algum statement sql.
		 *	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Select#genericostring-query">generico(String query)</a>
		 * 	<br>
		 * 	@param query = [String] statement para a busca de informações.
		 *	@return Retorna um ResultSet contendo os dados obtidos do banco de dados.
		**/
		public static ResultSet generico(String query) {
			TestConnection con = connectionDatabase(environment.getDataBasesConfig());
	    	ResultSet result = null;
	    	try {
	    		con.connect();
	    		result = getResultSet(con, query);
	    		result.first();
	    		con.disconect();
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}
	    	return result;
		}

		/**	Objetivo: Busca um resultado de algum statement sql.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Select#genericostring-query-testenvironmentdatabasesconfig-configuracaodeconexao">generico(String query, TestEnvironment.DataBasesConfig configuracaoDeConexao)(String query)</a>
		 * 	<br>
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param configuracaoDeConexao = [AmbientDefault.dataBasesConfig] Classe com as configurações do banco de dados.
		 *	@return Retorna um ResultSet contendo os dados obtidos do banco de dados.
		**/
		public static ResultSet generico(String query, TestEnvironment.DataBasesConfig configuracaoDeConexao) {
			TestConnection con = connectionDatabase(configuracaoDeConexao);
	    	ResultSet result = null;
	    	try {
	    		con.connect();
	    		result = getResultSet(con, query);
	    		result.first();
	    		con.disconect();
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}
	    	return result;
		}
	
	
		/**	Objetivo: Busca o primeiro registro de uma coluna do resultado de algum statement sql.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Select#textoemcolunastring-query-string-coluna">textoEmColuna(String query, String coluna)</a>
		 * 	<br>
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 *	@return Retorna um valor único, um texto da primeira linha encontrada.
		**/
		public static String textoEmColuna(String query, String coluna) {
			TestConnection con = connectionDatabase(environment.getDataBasesConfig());
	    	ResultSet result = null;
	    	String valor = null;
	    	try {
	    		con.connect();
	    		result = getResultSet(con, query);
	    		result.first();
	    		valor = result.getString(coluna);
	    		con.disconect();
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}
	    	return valor;
		}
		/**	Objetivo: Busca o primeiro registro de uma coluna do resultado de algum statement sql.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Select#textoemcolunastring-query-string-coluna-testenvironmentdatabasesconfig-configuracaodeconexao">textoEmColuna(String query, String coluna, TestEnvironment.DataBasesConfig configuracaoDeConexao)</a>
		 * 	<br>
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 * 	@param configuracaoDeConexao = [AmbientDefault.dataBasesConfig] Classe com as configurações do banco de dados.
		 *	@return Retorna um valor único, um texto da primeira linha encontrada.
		**/
		public static String textoEmColuna(String query, String coluna, TestEnvironment.DataBasesConfig configuracaoDeConexao) {
			TestConnection con = connectionDatabase(configuracaoDeConexao);
	    	ResultSet result = null;
	    	String valor = null;
	    	try {
	    		con.connect();
	    		result = getResultSet(con, query);
	    		result.first();
	    		valor = result.getString(coluna);
	    		con.disconect();
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}
	    	return valor;
		}


		/**	Objetivo: Busca o primeiro registro de uma coluna do resultado de algum statement sql.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Select#numeroemcolunastring-query-string-coluna">numeroEmColuna(String query, String coluna)</a>
		 * 	<br>
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 *	@return Retorna um valor único, um integer da primeira linha encontrada.
		**/
		public static Integer numeroEmColuna(String query, String coluna) {
			TestConnection con = connectionDatabase(environment.getDataBasesConfig());
	    	ResultSet result = null;
	    	Integer valor = null;
	    	try {
	    		con.connect();
	    		result = getResultSet(con, query);
	    		result.first();
	    		valor = result.getInt(coluna);
	    		con.disconect();
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}
	    	return valor;
		}
		/**	Objetivo: Busca o primeiro registro de uma coluna do resultado de algum statement sql.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Select#numeroemcolunastring-query-string-coluna-testenvironmentdatabasesconfig-configuracaodeconexao">numeroEmColuna(String query, String coluna, TestEnvironment.DataBasesConfig configuracaoDeConexao)</a>
		 * 	<br>
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 * 	@param configuracaoDeConexao = [AmbientDefault.dataBasesConfig] Classe com as configurações do banco de dados.
		 *	@return Retorna um valor único, um integer da primeira linha encontrada.
		**/
		public static Integer numeroEmColuna(String query, String coluna, TestEnvironment.DataBasesConfig configuracaoDeConexao) {
			TestConnection con = connectionDatabase(configuracaoDeConexao);
	    	ResultSet result = null;
	    	Integer valor = null;
	    	try {
	    		con.connect();
	    		result = getResultSet(con, query);
	    		result.first();
	    		valor = result.getInt(coluna);
	    		con.disconect();
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}
	    	return valor;
		}
	
	
		/**	Objetivo: Busca o primeiro registro de uma coluna do resultado de algum statement sql.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Select#doubleemcolunastring-query-string-coluna">doubleEmColuna(String query, String coluna)</a>
		 * 	<br>
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 *	@return Retorna um valor único, um Double da primeira linha encontrada.
		**/
		public static Double doubleEmColuna(String query, String coluna) {
			TestConnection con = connectionDatabase(environment.getDataBasesConfig());
	    	ResultSet result = null;
	    	Double valor = null;
	    	try {
	    		con.connect();
	    		result = getResultSet(con, query);
	    		result.first();
	    		valor = result.getDouble(coluna);
	    		con.disconect();
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}
	    	return valor;
		}
		/**	Objetivo: Busca o primeiro registro de uma coluna do resultado de algum statement sql.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Select#doubleemcolunastring-query-string-coluna-testenvironmentdatabasesconfig-configuracaodeconexao">doubleEmColuna(String query, String coluna, TestEnvironment.DataBasesConfig configuracaoDeConexao)</a>
		 * 	<br>
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 * 	@param configuracaoDeConexao = [AmbientDefault.dataBasesConfig] Classe com as configurações do banco de dados.
		 *	@return Retorna um valor único, um Double da primeira linha encontrada.
		**/
		public static Double doubleEmColuna(String query, String coluna, TestEnvironment.DataBasesConfig configuracaoDeConexao) {
			TestConnection con = connectionDatabase(configuracaoDeConexao);
	    	ResultSet result = null;
	    	Double valor = null;
	    	try {
	    		con.connect();
	    		result = getResultSet(con, query);
	    		result.first();
	    		valor = result.getDouble(coluna);
	    		con.disconect();
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}
	    	return valor;
		}

	}

	/**	
	 * A classe DataBaseUtilities.Update tem como o principal objetivo facilitar o uso do Statements de ação como updates e deletes no banco de dados.
	 * <br>
	 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Update">DataBaseUtilities.Update</a>
	**/
	public static class Update{

	    /**	Efetuar uma ação no banco de dados, podendo ser updates, inserts e deletes, utilizando um Statement sql.
	     * 	<br>
	     *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Update#genericostring-query">generico(String query)</a> 	
	     * 	<br>
	     *	@param query = (String) Query que será executada no banco de dados.
	    **/
	    public static void generico(String query) {
	    	TestConnection con = connectionDatabase(environment.getDataBasesConfig());
	    	try {
	    		update(con, query);
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}    	
	    }
	    /**	Efetuar uma ação no banco de dados, podendo ser updates, inserts e deletes, utilizando um Statement sql.
	     * 	<br>
	     *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Update#genericostring-query-testenvironmentdatabasesconfig-configuracaodeconexao">generico(String query, TestEnvironment.DataBasesConfig configuracaoDeConexao)</a> 	
	     * 	<br>
	     *	@param query = (String) Query que será executada no banco de dados.
	     *	@param configuracaoDeConexao = (AmbientDefault.dataBasesConfig) Classe de contendo as configurações de conexão com o banco de dados.
	    **/
	    public static void generico(String query, TestEnvironment.DataBasesConfig configuracaoDeConexao) {
	    	TestConnection con = connectionDatabase(configuracaoDeConexao);
	    	try {
	    		update(con, query);
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}    	
	    }
	    /**	Efetuar uma ação no banco de dados, podendo ser Update, Insert e Delete, utilizando uma lista de Statement sql.
	     * 	<br>
	     *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Update#genericoliststring-query">generico(List<String> query)</a> 	
	     * 	<br>
	     *	@param query = (List < String >) Lista de Statements que serão executados no banco de dados.
	    **/
	    public static void generico(List<String> query) {
	    	TestConnection con = connectionDatabase(environment.getDataBasesConfig());
	    	try {
	    		for (String statement : query) {
	    			if(!statement.endsWith(";")) {
	    				statement = statement + ";";
	    			}
	    			update(con, statement);
				}
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}
	    }
	    /**	Efetuar uma ação no banco de dados, podendo ser Update, Insert e Delete, utilizando uma lista de Statement sql.
	     * 	<br>
	     *	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DataBaseUtilities.Update#genericoliststring-query-testenvironmentdatabasesconfig-configuracaodeconexao">generico(List<String> query, TestEnvironment.DataBasesConfig configuracaoDeConexao)</a> 	
	     * 	<br>
	     *	@param query = (List < String >) Lista de Statements que serão executados no banco de dados.
	     *	@param configuracaoDeConexao = (AmbientDefault.dataBasesConfig) Classe de contendo as configurações de conexão com o banco de dados.
	    **/
	    public static void generico(List<String> query, TestEnvironment.DataBasesConfig configuracaoDeConexao) {
	    	TestConnection con = connectionDatabase(configuracaoDeConexao);
	    	try {
	    		for (String statement : query) {
	    			if(!statement.endsWith(";")) {
	    				statement = statement + ";";
	    			}
	    			update(con, statement);
				}
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}    	
	    }

	}

}