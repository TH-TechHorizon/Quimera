package quimera.test.core.environment;

/**	
 * <b> Definição: </b> <br>
 * Esta classe tem o objetivo de administrar e manipular as informações do ambiente de teste.
 * <br>
**/
public class TestEnvironment {
	private HttpConfigs httpConfigs;
	private UIEnvConfigs uiEnvConfigs;
	private AmbientConfigs ambientConfigs;
	private DataBasesConfig dataBasesConfig;

	public HttpConfigs getHttpConfigs() {
		return httpConfigs;
	}

	public void setHttpConfigs(HttpConfigs httpConfig) {
		httpConfigs = httpConfig;
	}
	
	public UIEnvConfigs getUIEnvConfigs() {
		return uiEnvConfigs;
	}

	public void setUIEnvConfigs(UIEnvConfigs uiEnvConfig) {
		uiEnvConfigs = uiEnvConfig;
	}

	public AmbientConfigs getAmbientConfigs() {
		return ambientConfigs;
	}

	public void setAmbientConfigs(AmbientConfigs ambientConfigs) {
		this.ambientConfigs = ambientConfigs;
	}

	public DataBasesConfig getDataBasesConfig() {
		return dataBasesConfig;
	}

	public void setDataBasesConfig(DataBasesConfig dataBasesConfig) {
		this.dataBasesConfig = dataBasesConfig;
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Esta classe representa os dados de conexão para as requisições, por exemplo, o host, porta, o tipo de protocolo e outras informações.
	 * <br>
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
	 * <b> Definição: </b> <br>
	 * Esta classe representa as informações usadas para a execução de testes de interface.
	 * <br>
	**/
	public static class UIEnvConfigs{
		private String driverPath;
		private String navegador;
		private String urlInitial;
		private String exibirNavegador;
		private String maximizarNavegador;
		private String sleepTime;
		private String timeOutTime;

		
		public String getDriverPath() {
			return driverPath;
		}
		public void setDriverPath(String driverPath) {
			this.driverPath = driverPath;
		}
		public String getNavegador() {
			return navegador;
		}
		public void setNavegador(String navegador) {
			this.navegador = navegador;
		}
		public String getExibirNavegador() {
			return exibirNavegador;
		}
		public void setExibirNavegador(String exibirNavegador) {
			this.exibirNavegador = exibirNavegador;
		}
		public String getUrlInitial() {
			return urlInitial;
		}
		public void setUrlInitial(String urlInitial) {
			this.urlInitial = urlInitial;
		}
		public String getMaximizarNavegador() {
			return maximizarNavegador;
		}
		public void setMaximizarNavegador(String maximizarNavegador) {
			this.maximizarNavegador = maximizarNavegador;
		}
		public String getSleepTime() {
			return sleepTime;
		}
		public void setSleepTime(String sleepTime) {
			this.sleepTime = sleepTime;
		}
		public String getTimeOutTime() {
			return timeOutTime;
		}
		public void setTimeOutTime(String timeOutTime) {
			this.timeOutTime = timeOutTime;
		}

	}
	
	/**	
	 * <b> Definição: </b> <br>
	 * Esta classe representa as informações de login e usuário.
	 * <br>
	**/
	public static class AmbientConfigs{
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
	 * <b> Definição: </b> <br>
	 * Esta classe representa as informações de acesso ao banco de dados, as rotinas de acesso ao banco de dados podem receber subclasses personalizadas para outros tipos e outros acessos ao banco de dados.
	 * <br>
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
