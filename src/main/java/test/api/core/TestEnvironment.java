package test.api.core;

/**	
 * Esta classe tem o objetivo de administrar e manipular as informações do ambiente de teste.
 * <br>
 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/TestEnvironment#testenvironment">TestEnvironment</a>
**/
public class TestEnvironment {
	private HttpConfigs HttpConfigs;
	private AmbinetConfigs ambinetConfigs;
	private DataBasesConfig dataBasesConfig;

	public HttpConfigs getHttpConfigs() {
		return HttpConfigs;
	}

	public void setHttpConfigs(HttpConfigs httpConfigs) {
		HttpConfigs = httpConfigs;
	}

	public AmbinetConfigs getAmbinetConfigs() {
		return ambinetConfigs;
	}

	public void setAmbinetConfigs(AmbinetConfigs ambinetConfigs) {
		this.ambinetConfigs = ambinetConfigs;
	}

	public DataBasesConfig getDataBasesConfig() {
		return dataBasesConfig;
	}

	public void setDataBasesConfig(DataBasesConfig dataBasesConfig) {
		this.dataBasesConfig = dataBasesConfig;
	}

	/**	
	 * Esta classe representa os dados de conexão para as requisições, por exemplo, o host, porta, o tipo de protocolo e outras informações.
	 * <br>
	 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/TestEnvironment.HttpConfigs#httpconfigs">HttpConfigs</a>
	**/
	public static class HttpConfigs{
		private String protocol;
		private String host;
		private String port;
		private String patch;
		private String version;
		private String typeRequest;

		public String getProtocol() {
			return protocol;
		}
		public void setProtocol(String protocol) {
			this.protocol = protocol;
		}
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getPort() {
			return port;
		}
		public void setPort(String port) {
			this.port = port;
		}
		public String getPatch() {
			return patch;
		}
		public void setPatch(String patch) {
			this.patch = patch;
		}
		public String getVersion() {
			return version;
		}
		public void setVersion(String version) {
			this.version = version;
		}
		public String getTypeRequest() {
			return typeRequest;
		}
		public void setTypeRequest(String typeRequest) {
			this.typeRequest = typeRequest;
		}
	}

	/**	
	 * Esta classe representa as informações de login e usuário.
	 * <br>
	 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/testenvironment.ambinetconfigs#ambinetconfigs">AmbinetConfigs</a>
	**/
	public static class AmbinetConfigs{
		private String username;
		private String password;

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}

	/**	
	 * Esta classe representa as informações de acesso ao banco de dados, as rotinas de acesso ao banco de dados podem receber subclasses personalizadas para outros tipos e outros acessos ao banco de dados.
	 * <br>
	 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/testenvironment.DataBasesConfig#databasesconfig">DataBasesConfig</a>
	**/
	public static class DataBasesConfig{
		private String databaseType;
		private String host;
		private String port;
		private String base;
		private String schemaName;
		private String usuario;
		private String senha;

		public String getDatabaseType() {
			return databaseType;
		}
		public void setDatabaseType(String databaseType) {
			this.databaseType = databaseType;
		}
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getPort() {
			return port;
		}
		public void setPort(String port) {
			this.port = port;
		}
		public String getBase() {
			return base;
		}
		public void setBase(String base) {
			this.base = base;
		}
		public String getSchemaName() {
			return schemaName;
		}
		public void setSchemaName(String schemaName) {
			this.schemaName = schemaName;
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
	}

}
