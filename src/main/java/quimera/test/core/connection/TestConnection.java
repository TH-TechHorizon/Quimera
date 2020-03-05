package quimera.test.core.connection;

import java.sql.*;

import quimera.test.core.TestCoreCentralizer;
import quimera.test.core.log.TestLogger;

/**	
 * <b> Definição: </b> <br>
 * Esta classe tem o objetivo de administrar as conexões com o banco de dados. A mesma poderá ser importada para criar novas conexões com informações diferentes das informações default.
 * <br>
**/
public class TestConnection extends TestCoreCentralizer{
	private String local;
	private String usuario;
	private String senha;
	private Connection con;
	private Statement statement;
	private String str_con;
	private String driverjdbc;


	/**	
	 * <b> Definição: </b> <br>
	 * Criação da string de conexão e da propria conexão em si.
	 * @param datBase [String] = Tipo de Base de dados, sendo: <li> PostgresSQL </li> <li> Oracle </li>
	 * @param local [String] = Host da base de dados.
	 * @param porta [String] = Porta do servidor do banco de dados.
	 * @param banco [String] = Nome do banco de dados.
	 * @param schema [String] = Schema do banco para setar como padrão (null se não possuir).
	 * @param usuario [String] = Usuário com as devidas permissões no banco de dados.
	 * @param senha [String] = Senha do usuário.
	 * @return Não possui nenhhum retorno. 
	 * <br>
	**/
	public TestConnection(String datBase, String local, String porta, String banco, String schema, String usuario, String senha) {
		if (datBase.equals(dataBase.PostgresSQL.toString())) {
			if(schema!=null)
				setStr_con("jdbc:postgresql://"+ local +":" + porta +"/"+ banco + "?currentSchema=" + schema);
			else
				setStr_con("jdbc:postgresql://"+ local +":" + porta +"/"+ banco);
            setLocal(local);
            setSenha(senha);
            setUsuario(usuario);
            setDriverjdbc("org.postgresql.Driver");
		}else if (datBase.equals(dataBase.Oracle.toString())) {
			setStr_con("jdbc:oracle:thin:"+ local +":" + porta +":"+ banco);
            setLocal(local);
            setSenha(senha);
            setUsuario(usuario);
            setDriverjdbc("oracle.jdbc.driver.OracleDriver");
		}
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Cria uma nova instância de conexão com o banco de dados.
	 * @return Não possui nenhhum retorno. 
	 * <br>
	**/
    public void connect(){
        try {
            Class.forName(getDriverjdbc());
            setCon(DriverManager.getConnection(getStr_con(), getUsuario(), getSenha()));
            setStatement(getCon().createStatement());
        }catch (Exception e) {
        	sendLog(e);
        }
    }

	/**	
	 * <b> Definição: </b> <br>
	 * Desconecta a instância de banco de dados.
	 * @return Não possui nenhhum retorno. 
	 * <br>
	**/
    public void disconect(){
        try {
            getCon().close();
        }catch (Exception ex) {
        	sendLog(ex);
        }
    }

	/**	
	 * <b> Definição: </b> <br>
	 * Executa uma query de select ou update no banco de dados gerando um retorno.
	 * @param query [ResultSet] = Um select, ou uma outra query.
	 * @return Retorna o resultado simplificado da query.
	 * <br>
	**/
    public ResultSet query(String query){
        try {
            return getStatement().executeQuery(query);
        }catch (Exception ex) {
        	sendLog(ex);
            return null;
        }
    }

	/**	
	 * <b> Definição: </b> <br>
	 * Enum com os tipos de configuração de conexão. 
	 * <br>
	**/
	public enum dataBase {
		PostgresSQL,
		Oracle
	}
	
	/**	
	 * <b> Definição: </b> <br>
	 * Função para gerar um Log quando ocorrer algum erro de conexão.
	 * @param error [Exception] = Retorno de algum exception ocorrido para que seja possível pegar o getMessage().
	 * <br>
	**/
	private void sendLog(Exception error) {
		TestLogger.logInfo("Erro ao se conectar a base de dados: " + error.getMessage());
	}

	
    /* Getter and Setters */
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public String getStr_con() {
		return str_con;
	}

	public void setStr_con(String str_con) {
		this.str_con = str_con;
	}

	public String getDriverjdbc() {
		return driverjdbc;
	}

	public void setDriverjdbc(String driverjdbc) {
		this.driverjdbc = driverjdbc;
	}
}
