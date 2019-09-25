package test.api.core;

import java.sql.*;

/**	
 * Esta classe tem o objetivo de administrar as conexões com o banco de dados. A mesma poderá ser importada para criar novas conexões com informações diferentes das informações default.
 * <br>
 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/TestConnection#testconnection">TestConnection</a>
**/
public class TestConnection extends TestCoreCentralizer{
	private String local;
	private String usuario;
	private String senha;
	private Connection con;
	private Statement statement;
	private String str_con;
	private String driverjdbc;


	private void sendLog(Exception error) {
		TestLogger.logInfo("Erro ao se conectar a base de dados: " + error.getMessage());
	}

	public TestConnection(String datBase, String local, String porta, String banco, String schema, String usuario, String senha) {
		if (datBase.equals(dataBase.PostgresSQL.toString())) {
			setStr_con("jdbc:postgresql://"+ local +":" + porta +"/"+ banco + "?currentSchema=" + schema);
            setLocal(local);
            setSenha(senha);
            setUsuario(usuario);
            setDriverjdbc("org.postgresql.Driver");
		}
	}

	/**	
	 * Criar uma nova instância de conexão com o banco de dados.
	 * <br>
	 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/TestConnection#m%C3%A9todo-connecttenant-logindata-string-loginurl">connect(Tenant loginData, String loginURL)</a>
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

    //Desconexão com o Banco de Dados
    public void disconect(){
        try {
            getCon().close();
        }catch (SQLException ex) {
        	sendLog(ex);
        }
    }

    //Reusult Query
    public ResultSet query(String query){
        try {
            return getStatement().executeQuery(query);
        }catch (SQLException ex) {
        	sendLog(ex);
            return null;
        }
    }


    //Enums
	public enum dataBase {
		PostgresSQL
	}


    //Getter and Setters
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
