package test.api.core;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import test.api.core.TestEnvironment.AmbinetConfigs;
import test.api.core.TestEnvironment.DataBasesConfig;
import test.api.core.TestEnvironment.HttpConfigs;

public class TestEngine {
	private static String jsonConfig = "TestEnvironmentConfigurationFile.Json";

	public static TestEnvironment environment;
	public static String urlApiDefault;
	public static List<String> relatorTest;
	public static String tituloTest;
	public static List<String> conteudoTest;

	/** [Rotinas Padroes do CORE] **/
	protected static void getAmbientClassDefaults() {
		environment = new TestEnvironment();
		TestEnvironment.HttpConfigs httpConfig = new HttpConfigs();
		TestEnvironment.AmbinetConfigs ambinetConfigs = new AmbinetConfigs();
		TestEnvironment.DataBasesConfig dataBasesConfig = new DataBasesConfig();
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
    		ambinetConfigs.setTenant(noder.path("ambinetConfigs").path("tenant").asText());
    		ambinetConfigs.setPassword(noder.path("ambinetConfigs").path("password").asText());
    		dataBasesConfig.setDatabaseType(noder.path("dataBasesConfig").path("databaseType").asText());
    		dataBasesConfig.setBase(noder.path("dataBasesConfig").path("base").asText());
    		dataBasesConfig.setHost(noder.path("dataBasesConfig").path("host").asText());
    		dataBasesConfig.setPort(noder.path("dataBasesConfig").path("port").asText());
    		dataBasesConfig.setSchemaPrefix(noder.path("dataBasesConfig").path("schemaPrefix").asText());
    		dataBasesConfig.setUsuario(noder.path("dataBasesConfig").path("user").asText());
    		dataBasesConfig.setSenha(noder.path("dataBasesConfig").path("password").asText());
        }catch (Exception e) {
        	TestLogger.printLog("Erro ao tentar obter informação do ambiente de teste: " + e.getMessage());
		}
        environment.setAmbinetConfigs(ambinetConfigs);
        environment.setDataBasesConfig(dataBasesConfig);
        environment.setHttpConfigs(httpConfig);
        urlApiDefault = httpConfig.getProtocol() + "://" + httpConfig.getHost() + ":" + httpConfig.getPort() + httpConfig.getPatch() + httpConfig.getVersion() + httpConfig.getTypeRequest();
        TestLogger.printLog("urlApiDefault: " + urlApiDefault);
	}

	protected static String getUrlAPIDefault() {
		getAmbientClassDefaults();
		return urlApiDefault;
	}

	/* [Rotinas Padroes do CORE] */

    /**	Função para encapsular um objeto para Json para usar nos requests!	[Já está sendo usado nos requestsJsons] **/
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

    /**	Função para buscar o valor de um elementos Json dentro de um caminho específico! **/
	protected static String getJsonValue(Response response, String caminho) {
		String valor = null;
		try {
			valor = response.body().jsonPath().get(caminho).toString();
		}catch (Exception e) {
			TestLogger.logInfo("Mensagem de Erro: " + e.getMessage());
		}
		return valor;
	}

    /**	Função para buscar a quantidade de elementos Json dentro de um caminho específico! **/
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