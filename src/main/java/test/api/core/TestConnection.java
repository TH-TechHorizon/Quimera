package test.api.core;

import java.sql.*;

public class TestConnection extends TestCoreCentralizer{
	private String local;
	private String usuario;
	private String senha;
	private Connection con;
	private Statement statement;
	private String str_con;
	private String driverjdbc;

	public TestConnection(String datBase, String local, String porta, String banco, String schema, String usuario, String senha) {
		if (datBase.equals(dataBase.PostgresSQL.toString())) {
			setStr_con("jdbc:postgresql://"+ local +":" + porta +"/"+ banco + "?currentSchema=" + schema);
            setLocal(local);
            setSenha(senha);
            setUsuario(usuario);
            setDriverjdbc("org.postgresql.Driver");
		}
	}

    //Conexão com o Banco de Dados
    public void connect(){
        try {
            Class.forName(getDriverjdbc());
            setCon(DriverManager.getConnection(getStr_con(), getUsuario(), getSenha()));
            setStatement(getCon().createStatement());
        }catch (Exception e) {
        	logInfo("Erro ao se conectar a base de dados: " + e.getMessage());
        }
    }

    //Desconexão com o Banco de Dados
    public void disconect(){
        try {
            getCon().close();
        }catch (SQLException ex) {
        	logInfo("Erro ao se conectar a base de dados: " + ex.getMessage());
        }
    }

    //Reusult Query
    public ResultSet query(String query){
        try {
            return getStatement().executeQuery(query);
        }catch (SQLException ex) {
        	logInfo("Erro ao se conectar a base de dados: " + ex.getMessage());
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
