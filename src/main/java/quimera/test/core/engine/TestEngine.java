package quimera.test.core.engine;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import quimera.test.core.environment.TestEnvironment;
import quimera.test.core.environment.TestEnvironment.AmbientConfigs;
import quimera.test.core.environment.TestEnvironment.DataBasesConfig;
import quimera.test.core.environment.TestEnvironment.HttpConfigs;
import quimera.test.core.environment.TestEnvironment.UIEnvConfigs;
import quimera.test.core.log.TestLogger;

/**	
 * <b> Definição: </b> <br>
 * O TestEngine tem como responsabilidade dar o Start inicial para os testes, capturar as informações padrões do TestEnvironmentConfigurationFile.Json e armazenar em na variável "environment" da classe TestEnvironment. <br>
**/
public class TestEngine {
	protected static String jsonConfig = "TestEnvironmentConfigurationFile.Json";

	public static TestEnvironment environment;
	public static String urlApiDefault;
	public static String urlInitial;
	public static List<String> relatorTest;
	public static String tituloTest;
	public static List<String> conteudoTest;

	/**	
	 * <b> Definição: </b> <br>
	 * Usa o TestEnvironmentConfigurationFile.json para popular a variável environment. <br>
	 * Popula as variáveis:  
	 * <b>environment:</b> Possui todos os dados informados no TestEnvironmentConfigurationFile.Json <br>
	 * <b>urlApiDefault:</b> Possui a junção do environment.HttpConfigs onde é formada a url para chamada de APIs, sendo a construção: Protocol + "://" + Host + ":" + Port + Patch + Version + TypeRequest <br>
	 * <b>urlInitial:</b> URl incial para os testes de interface, onde o navegador abrirá inicialmente. <br>
	 * <br>
	**/
	protected static void getEnvironment() {
		environment = new TestEnvironment();
		getEnvironmentHttpConfigs(environment);
		getEnvironmentUIEnvConfigs(environment);
		getEnvironmentAmbinetConfigs(environment);
		getEnvironmentDataBasesConfig(environment);

        urlApiDefault = environment.getHttpConfigs().getProtocol() + "://" + environment.getHttpConfigs().getHost() + ":" + environment.getHttpConfigs().getPort() + environment.getHttpConfigs().getPatch() + environment.getHttpConfigs().getVersion() + environment.getHttpConfigs().getTypeRequest();
        urlInitial = environment.getUIEnvConfigs().getUrlInitial();
        TestLogger.printLog("urlApiDefault: " + urlApiDefault);
        TestLogger.printLog("urlInitial: " + urlInitial);
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Usa o TestEnvironmentConfigurationFile.Json para popular a variável httpConfig do environment. <br>
	 * @param environment Variável da classe TestEnvironment que será populada com as informações do httpConfig. 
	 * <br>
	**/
	protected static void getEnvironmentHttpConfigs(TestEnvironment environment) {
		TestEnvironment.HttpConfigs httpConfig = new HttpConfigs();
		ObjectMapper mapper = new ObjectMapper();
        try {
        	File jsonInputFile = new File(jsonConfig);
        	JsonNode noder = mapper.readTree(jsonInputFile);
        	httpConfig.setProtocol(noder.path("HttpConfigs").path("protocol").asText());
        	httpConfig.setHost(noder.path("HttpConfigs").path("host").asText());
        	httpConfig.setPort(noder.path("HttpConfigs").path("port").asText());
        	httpConfig.setPatch(noder.path("HttpConfigs").path("patch").asText());
        	httpConfig.setVersion(noder.path("HttpConfigs").path("version").asText());
    		httpConfig.setTypeRequest(noder.path("HttpConfigs").path("typeRequest").asText());
        }catch (Exception e) {
        	TestLogger.printLog("Erro ao tentar obter informação do ambiente de teste: " + e.getMessage());
		}
        environment.setHttpConfigs(httpConfig);
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Usa o TestEnvironmentConfigurationFile.Json para popular a variável uiEnvConfigs do environment. <br>
	 * @param environment Variável da classe TestEnvironment que será populada com as informações do uiEnvConfigs. 
	 * <br>
	**/
	protected static void getEnvironmentUIEnvConfigs(TestEnvironment environment) {
		TestEnvironment.UIEnvConfigs uIEnvConfigs = new UIEnvConfigs();
		ObjectMapper mapper = new ObjectMapper();
        try {
        	File jsonInputFile = new File(jsonConfig);
        	JsonNode noder = mapper.readTree(jsonInputFile);
        	uIEnvConfigs.setUrlInitial(noder.path("UIEnvConfigs").path("urlInitial").asText());
        	uIEnvConfigs.setNavegador(noder.path("UIEnvConfigs").path("navegador").asText());
        	uIEnvConfigs.setExibirNavegador(noder.path("UIEnvConfigs").path("exibirNavegador").asText());
        	uIEnvConfigs.setMaximizarNavegador(noder.path("UIEnvConfigs").path("maximizarNavegador").asText());
        	uIEnvConfigs.setSleepTime(noder.path("UIEnvConfigs").path("sleepTime").asText());
        	uIEnvConfigs.setTimeOutTime(noder.path("UIEnvConfigs").path("timeOutTime").asText());
        	uIEnvConfigs.setDriverPath(noder.path("UIEnvConfigs").path("driverPath").asText());
        }catch (Exception e) {
        	TestLogger.printLog("Erro ao tentar obter informação do ambiente de teste: " + e.getMessage());
		}
        environment.setUIEnvConfigs(uIEnvConfigs);
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Usa o TestEnvironmentConfigurationFile.Json para popular a variável ambinetConfigs do environment. <br>
	 * @param environment Variável da classe TestEnvironment que será populada com as informações do ambinetConfigs. 
	 * <br>
	**/
	protected static void getEnvironmentAmbinetConfigs(TestEnvironment environment) {
		TestEnvironment.AmbientConfigs ambinetConfigs = new AmbientConfigs();
		ObjectMapper mapper = new ObjectMapper();
        try {
        	File jsonInputFile = new File(jsonConfig);
        	JsonNode noder = mapper.readTree(jsonInputFile);
    		ambinetConfigs.setUsername(noder.path("ambinetConfigs").path("username").asText());
    		ambinetConfigs.setPassword(noder.path("ambinetConfigs").path("password").asText());
        }catch (Exception e) {
        	TestLogger.printLog("Erro ao tentar obter informação do ambiente de teste: " + e.getMessage());
		}
        environment.setAmbientConfigs(ambinetConfigs);
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Usa o TestEnvironmentConfigurationFile.Json para popular a variável dataBasesConfig do environment. <br>
	 * @param environment Variável da classe TestEnvironment que será populada com as informações do dataBasesConfig. 
	 * <br>
	**/
	protected static void getEnvironmentDataBasesConfig(TestEnvironment environment) {
		TestEnvironment.DataBasesConfig dataBasesConfig = new DataBasesConfig();
		ObjectMapper mapper = new ObjectMapper();
        try {
        	File jsonInputFile = new File(jsonConfig);
        	JsonNode noder = mapper.readTree(jsonInputFile);
    		dataBasesConfig.setDatabaseType(noder.path("dataBasesConfig").path("databaseType").asText());
    		dataBasesConfig.setBase(noder.path("dataBasesConfig").path("base").asText());
    		dataBasesConfig.setHost(noder.path("dataBasesConfig").path("host").asText());
    		dataBasesConfig.setPort(noder.path("dataBasesConfig").path("port").asText());
    		dataBasesConfig.setSchemaName(noder.path("dataBasesConfig").path("schemaPrefix").asText());
    		dataBasesConfig.setUsuario(noder.path("dataBasesConfig").path("user").asText());
    		dataBasesConfig.setSenha(noder.path("dataBasesConfig").path("password").asText());
        }catch (Exception e) {
        	TestLogger.printLog("Erro ao tentar obter informação do ambiente de teste: " + e.getMessage());
		}
        environment.setDataBasesConfig(dataBasesConfig);
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Busca o link padrão para as requisições das apis.
	 * @return Retorna o link formado pela fórmula: Protocol + "://" + Host + ":" + Port + Patch + Version + TypeRequest. 
	 * <br>
	**/
	protected static String getUrlAPI() {
		getEnvironment();
		return urlApiDefault;
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Busca o link padrão para os testes de Interface.
	 * @return Retorna o link informado no json de configuração referente a TAG urlInitial. 
	 * <br>
	**/
	protected static String getUrlInitial() {
		getEnvironment();
		return urlInitial;
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Transformar uma classe em um JSON.
	 * @param body [Object] = Deverá ser uma classe, ou um objeto passível a ser parseado em JSON.
	 * @return Retorna uma string com os dados informados no formato JSON. 
	 * <br>
	**/
	protected static String encodeJsonBody(Object body) {
		ObjectMapper mapper = new ObjectMapper();
		String bodyEncode = null;
		try {
			bodyEncode = mapper.writeValueAsString(body);
		} catch (JsonProcessingException e) {
			TestLogger.logInfo("Mensagem de Erro: " + e.getMessage());
		}
		return bodyEncode;
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Função para buscar o valor de um elementos Json dentro de um caminho específico.
	 * @param response [Response] = Deverá receber o retorno de uma requisição do RestAssured.io.
	 * @param caminho [String] = Conter o caminho de elementos até o json especifico.
	 * @return O valor encontrado para o elemento buscado. 
	 * <br>
	**/
	protected static String getJsonValue(Response response, String caminho) {
		String valor = null;
		try {
			valor = response.body().jsonPath().get(caminho).toString();
		}catch (Exception e) {
			TestLogger.logInfo("Mensagem de Erro: " + e.getMessage());
		}
		return valor;
	}

	/**	
	 * <b> Definição: </b> <br>
	 * Retornar a quantidade de elementos filhos de um elementos específico.
	 * @param responseBody [Response] = Deverá receber o retorno de uma requisição do RestAssured.io.
	 * @param caminho [String] = Conter o caminho de elementos até o json especifico.
	 * @return Numero da quantidade de elementos filhos do elemento buscado. 
	 * <br>
	**/
	protected static int getJsonTotalElements(Response responseBody, String caminho) {
		int size = 0;
		try {
			List<Map<String, String>> jsonObject = responseBody.getBody().jsonPath().getJsonObject(caminho);
			size = jsonObject.size();
		}catch (Exception e) {
			TestLogger.logInfo("Mensagem de Erro: " + e.getMessage());
		}
		return size;
	}
	
}