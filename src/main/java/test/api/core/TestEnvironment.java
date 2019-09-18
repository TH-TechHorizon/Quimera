package test.api.core;

/**
 * Dados para criar o JSon de Login
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

	public static class AmbinetConfigs{
		private String tenant;
		private String password;

		public String getTenant() {
			return tenant;
		}
		public void setTenant(String tenant) {
			this.tenant = tenant;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}

	public static class DataBasesConfig{
		private String databaseType;
		private String host;
		private String port;
		private String base;
		private String schemaPrefix;
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
		public String getSchemaPrefix() {
			return schemaPrefix;
		}
		public void setSchemaPrefix(String schemaPrefix) {
			this.schemaPrefix = schemaPrefix;
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
