package test.api.utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import test.api.core.TestConnection;
import test.api.core.TestCoreCentralizer;
import test.api.core.TestEnvironment;


/**	Objetivo: Acesso e controle de SGBDs. **/
public class DataBaseUtilities extends TestCoreCentralizer {

	private static void logInfoError(String error) {
		logInfo("Ocorreu erro ao tentar efetuar Select ou Update na base de dados: " + error);
	}
	
	private static ResultSet getResultSet(TestConnection con, String query) throws SQLException {
		return con.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(query);
	}
	private static TestConnection connectionDatabase(TestEnvironment.DataBasesConfig configuracaoDeConexao, TestEnvironment.AmbinetConfigs configuracaoDeUsuario){
		TestEnvironment.DataBasesConfig db = configuracaoDeConexao;
		TestEnvironment.AmbinetConfigs user = configuracaoDeUsuario;
		return new TestConnection(db.getDatabaseType(), db.getHost(), db.getPort(), db.getBase(), db.getSchemaPrefix() + user.getTenant(), db.getUsuario(), db.getSenha());
	}
	private static void update(TestConnection con, String query) throws SQLException{
		con.connect();
		PreparedStatement update = con.getCon().prepareStatement(query);
		update.executeUpdate();
		con.disconect();
	}
	
	public static class Select{
	
		/**	Objetivo: Busca um resultado de algum statement sql.
		 * 	@param query = [String] statement para a busca de informações.
		 *	@return Retorna um ResultSet contendo os dados obtidos do banco de dados.
		**/
		public ResultSet generico(String query) {
			TestConnection con = connectionDatabase(environment.getDataBasesConfig(), environment.getAmbinetConfigs());
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
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param configuracaoDeConexao = [AmbientDefault.dataBasesConfig] Classe com as configurações do banco de dados.
		 * 	@param configuracaoDeUsuario = [AmbientDefault.ambinetConfigs] Classe com as configurações do usuario do banco de dados como usuario e senha.
		 *	@return Retorna um ResultSet contendo os dados obtidos do banco de dados.
		**/
		public ResultSet generico(String query, TestEnvironment.DataBasesConfig configuracaoDeConexao, TestEnvironment.AmbinetConfigs configuracaoDeUsuario) {
			TestConnection con = connectionDatabase(configuracaoDeConexao, configuracaoDeUsuario);
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
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 *	@return Retorna um valor único, um texto da primeira linha encontrada.
		**/
		public String textoEmColuna(String query, String coluna) {
			TestConnection con = connectionDatabase(environment.getDataBasesConfig(), environment.getAmbinetConfigs());
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
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 * 	@param configuracaoDeConexao = [AmbientDefault.dataBasesConfig] Classe com as configurações do banco de dados.
		 * 	@param configuracaoDeUsuario = [AmbientDefault.ambinetConfigs] Classe com as configurações do usuario do banco de dados como usuario e senha.
		 *	@return Retorna um valor único, um texto da primeira linha encontrada.
		**/
		public String textoEmColuna(String query, String coluna, TestEnvironment.DataBasesConfig configuracaoDeConexao, TestEnvironment.AmbinetConfigs configuracaoDeUsuario) {
			TestConnection con = connectionDatabase(configuracaoDeConexao, configuracaoDeUsuario);
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
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 *	@return Retorna um valor único, um integer da primeira linha encontrada.
		**/
		public Integer numeroEmColuna(String query, String coluna) {
			TestConnection con = connectionDatabase(environment.getDataBasesConfig(), environment.getAmbinetConfigs());
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
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 * 	@param configuracaoDeConexao = [AmbientDefault.dataBasesConfig] Classe com as configurações do banco de dados.
		 * 	@param configuracaoDeUsuario = [AmbientDefault.ambinetConfigs] Classe com as configurações do usuario do banco de dados como usuario e senha.
		 *	@return Retorna um valor único, um integer da primeira linha encontrada.
		**/
		public Integer numeroEmColuna(String query, String coluna, TestEnvironment.DataBasesConfig configuracaoDeConexao, TestEnvironment.AmbinetConfigs configuracaoDeUsuario) {
			TestConnection con = connectionDatabase(configuracaoDeConexao, configuracaoDeUsuario);
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
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 *	@return Retorna um valor único, um Double da primeira linha encontrada.
		**/
		public Double doubleEmColuna(String query, String coluna) {
			TestConnection con = connectionDatabase(environment.getDataBasesConfig(), environment.getAmbinetConfigs());
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
		 * 	@param query = [String] statement para a busca de informações.
		 * 	@param coluna = [String] Coluna buscada no statement.
		 * 	@param configuracaoDeConexao = [AmbientDefault.dataBasesConfig] Classe com as configurações do banco de dados.
		 * 	@param configuracaoDeUsuario = [AmbientDefault.ambinetConfigs] Classe com as configurações do usuario do banco de dados como usuario e senha.
		 *	@return Retorna um valor único, um Double da primeira linha encontrada.
		**/
		public Double doubleEmColuna(String query, String coluna, TestEnvironment.DataBasesConfig configuracaoDeConexao, TestEnvironment.AmbinetConfigs configuracaoDeUsuario) {
			TestConnection con = connectionDatabase(configuracaoDeConexao, configuracaoDeUsuario);
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
	
	public static class Update{
	
	    /**	Função para updates, deletes no banco de dados.
	     *	@param query = (String) Query que será executada no banco de dados.
	    **/
	    public void generico(String query) {
	    	TestConnection con = connectionDatabase(environment.getDataBasesConfig(), environment.getAmbinetConfigs());
	    	try {
	    		update(con, query);
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}    	
	    }
	    /**	Função para updates, deletes no banco de dados.
	     *	@param query = (String) Query que será executada no banco de dados.
	     *	@param configuracaoDeConexao = (AmbientDefault.dataBasesConfig) Classe de contendo as configurações de conexão com o banco de dados.
	     *	@param configuracaoDeUsuario = (AmbientDefault.ambinetConfigs) Classe de contendo as configurações usuário para conexão com o banco de dados.
	    **/
	    public void generico(String query, TestEnvironment.DataBasesConfig configuracaoDeConexao, TestEnvironment.AmbinetConfigs configuracaoDeUsuario) {
	    	TestConnection con = connectionDatabase(configuracaoDeConexao, configuracaoDeUsuario);
	    	try {
	    		update(con, query);
	    	}catch (Exception e) {
	    		con.disconect();
	    		logInfoError(e.getMessage());
			}    	
	    }
	    /**	Função para updates, deletes no banco de dados.
	     *	@param query = (List < String >) Lista de Statements que serão executados no banco de dados.
	    **/
	    public void generico(List<String> query) {
	    	TestConnection con = connectionDatabase(environment.getDataBasesConfig(), environment.getAmbinetConfigs());
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
	    /**	Função para updates, deletes no banco de dados.
	     *	@param query = (List < String >) Lista de Statements que serão executados no banco de dados.
	     *	@param configuracaoDeConexao = (AmbientDefault.dataBasesConfig) Classe de contendo as configurações de conexão com o banco de dados.
	     *	@param configuracaoDeUsuario = (AmbientDefault.ambinetConfigs) Classe de contendo as configurações usuário para conexão com o banco de dados.
	    **/
	    public void generico(List<String> query, TestEnvironment.DataBasesConfig configuracaoDeConexao, TestEnvironment.AmbinetConfigs configuracaoDeUsuario) {
	    	TestConnection con = connectionDatabase(configuracaoDeConexao, configuracaoDeUsuario);
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