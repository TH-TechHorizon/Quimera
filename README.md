## Quimera - Ecossistema de Teste Personalizado

Este projeto desenvolvido em Java, tem como objetivo servir como uma mãozinha para quem usa TestNG, Selenium WebDriver e Rest Assured para seus testes.

Este ecossistema oferece suporte para Testes de Interface WEB e de APIs.

Para isso são utilizados alguns recursos essenciais:
- [TestNG 7.0.0](https://testng.org/doc/download.html "TestNG")
- [RestAssured.io](http://rest-assured.io/ "RestAssured.io")
- [Selenium WebDriver](https://mvnrepository.com/artifact/org.seleniumhq.selenium "Selenium WebDriver")
- [AllureReport](http://allure.qatools.ru/ "AllureReport")

Mas nada disso precisará ser programado, o Quimera já possui tudo pronto para que você possa dar o start de sua automação, apenas sendo necessário configurar o arquivo de configuração e assim já se pode iniciar a automação.

------------

## Configurações

### Dependencia
#### Maven
Copie o código abaixo e cole no POM.xml de seu projeto.
```
<dependency>
  <groupId>com.github.nexengine</groupId>
  <artifactId>Quimera-Test-Framework-Ecosystem</artifactId>
  <version>1.3.8</version>
</dependency>
```

#### Arquivo de Configuração
Para a correta execução um arquivo .json deverá existir na raiz de seu projeto, o nome dele **Deverá** ser **TestEnvironmentConfigurationFile**.json.

###### HttpConfigs
São as informações que o framework irá usar para a comunicação dos testes de API.

-	**protocol**: http ou https exemplo:  **http**
-	**host**: Host do site, exemplo: **dummy.restapiexample.com**
-	**port**: Porta de comunicação com a API(Se possuir), exemplo: **1889**.
-	**patch**: Caminho para chegar até as chamadas de API, exemplo:  **/api/**
-	**version**: Versão da chamada de API (Se possuir), exemplo: **v1/**
-	**typeRequest**: Se necessário, o tipo de chamada, exemplo: **rest/**

Neste caso a url padrão de comunicação com as APIs seria: http://dummy.restapiexample.com:1889/api/v1/rest/ e você poderia obtêlas nos testes através da variável **urlApi** nos scripts de testes.

------------

###### UIEnvConfigs
Informações referente aos testes de Interface.

-	**driverPath**: Caminho onde os drivers estarão, o nome dos drivers deverá permanecer o padrão, por exemplo o do chrome, deverá ser **chromedriver.exe**.
-	**navegador**: Preencha com o navegador a sua escolha, podendo ser entre: 
	-	**chrome**
	-	**firefox**
	-	**edgeChromium**
-	**urlInitial**: A Url qual a automação irá abrir logo assim que começar.
-	**exibirNavegador**: Exibe ou não o navegar, escolha entre:
	-	**true** (Exibe)
	-	**false** (Não Exibe)
-	**maximizarNavegador**: Maximiza ou não o navegador ao iniciar, escolha entre:
	-	**true** (Exibe)
	-	**false** (Não Exibe)
-	**sleepTime**: Tempo padrão em milisegundos que as funções de interface esperarão algum elemento, exemplo: **5000** para 5 segundos.
-	**timeOutTime**: Tempo padro em segundos que algumas funções como espera de página utilizam, exemplo: **5** para 5 segundos.

Você poderá obter a urlInitial durante os testes através da variável **urlInitial**.

------------

###### ambinetConfigs
Informações que podem ser usados para o login, por exemplo, login de usuário em uma tela.

-	**username**: Nome de um usuário do sistema para um possível login.
-	**password**: Senha do usuário informado.

------------

###### dataBasesConfig
Informações de acesso ao banco de dados padrão.

-	**databaseType**: O tipo de base de dados que o sistema utiliza, hoje o framework suporta três tipos, sendo:
	-	**PostgresSQL**
	-	**SQLServer**
	-	**Oracle**
-	**host**: O host de conexão com a base de dados, exemplo: **localhost**.
-	**port**: A porta de acesso com a base de dados, exemplo: **5448**
-	**base**: O Nome da base, a qual o framework irá se conectar, exemplo: **usuarios**.
-	**schemaName**: Se seu SGDB possuir Schema, e você quiser se conectar a ele diretamente o informe aqui.
-	**user**:  Usuário de acesso a base (Com as permissões necessárias), exemplo: **root**
-	**password**: Senha para o usuário informado, exemplo: **root**

------------

Com os dados acima, o arquivo **TestEnvironmentConfigurationFile**.json deverá ficar assim:
```
{
	"HttpConfigs" : {
		"protocol" : "http",
		"host" : "dummy.restapiexample.com",
		"port" : "1889",
		"patch" : "/api/",
		"version" : "v1/",
		"typeRequest" : "rest/"
	},
	"UIEnvConfigs" : {
		"driverPath" : "c:\\driver\\",
		"navegador" : "chrome",
		"urlInitial" : "www.google.com.br",
		"exibirNavegador" : "false",
		"maximizarNavegador" : "false",
		"sleepTime" : "500",
		"timeOutTime" : "5"
	},
	"ambinetConfigs" : {
		"username" : "loginUser",
		"password" : "senhaLoginUser"
	},
	"dataBasesConfig" : {
		"databaseType" : "PostgresSQL",
		"host" : "localhost",
		"port" : "5448",
		"base" : "usuarios",
		"schemaName" : "",
		"user" : "root",
		"password" : "root"
	}
}
```

Você também poderá acessar os dados padrões através da variável **environment**, que conterá todos os dados do Json de configuração.

------------

## Extensões do Quimera

Para usar os recursos do Quimera, você terá de extender um pacote do Quimera, existem três deles, sendo um genérico (Serve para testes de API e Interface), um somente para testes de API e outro somente para testes de Interface.

#### Extendendo Para Testes de API.
O pacote de extensão de teste de API é `quimera.test.extension.api.TestExtension`, esta extensão não irá chamar o navegador ao iniciar os testes, ou seja é focado apenas nos testes de APIs.

###### Exemplo de script de teste
```
package SeuPacoteDeTestes;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import quimera.test.extension.api.TestExtension;
import quimera.test.utilities.DataBaseUtilities.Select;
import quimera.test.utilities.DataBaseUtilities.Update;
import quimera.test.utilities.assertion.AssertThat;

@Epic("Tela de Login")
public class ApiTestsTemplate extends TestExtension {
	
	/*	URL da API a ser Testada */
	String URLAPIs =  getUrlAPIDefault() +"create";  // Usar o getUrlAPIDefault() para buscar os dados do Json de configuração. */
	
	/*	Variáveis do Corpo do JSON	*/
	createData bodyData = new createData();

	@BeforeTest /*Se precisar crie um @BeforeTest para configurar os testes. */
	public void recarregarVariaveisDeTeste() {
		bodyData = new createData();
	}
	
	/* Chamada da API  */
	public Response createEmployee(createData bodyData) {
		Response resultData = TestRequest.request(HttpMethod.POST, false, bodyData, URLAPIs)
		return resultData;
	}

	/*	[Cenários De Testes] */
	@Test(	description = "Descrição Genérica do Teste", 
			suiteName = "Nome da Suite" /*Nome da Suite de Teste (Se possuir), caso não possua, pode usar o nome da classe*/ 
	)
	@Story("Template de Teste (Pode ser o mesmo nome da Descrição)")
	public void test000() throws JsonProcessingException {
		bodyData.setName("teste");
		bodyData.setSalary(1500);
		bodyData.setAge(25);
		Response respost = createEmployee(bodyData);
		AssertThat.rest()
			.isEqualStatusCode(respost, 200)
			.rest().isEqualSize(respost, 4 ,"data")
			.rest().isEqualText(respost, "success", "status")
		;
	}
}
```

------------

#### Extendendo Pacote para Testes de Interface.
O pacote para testes de Interface é `quimera.test.extension.ui.TestExtension`, ao extender este pacote, assim que o teste iniciar o navegador irá abrir na URL definida como padrão.

###### Exemplo de script de teste
```
package SeuPacoteDeTestes;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import quimera.test.extension.ui.TestExtension;
import quimera.test.utilities.DataBaseUtilities.Select;
import quimera.test.utilities.DataBaseUtilities.Update;
import quimera.test.utilities.assertion.AssertThat;

@Epic("Tela de Login")
public class ApiTestsTemplate extends TestExtension {

	@BeforeTest /*Se precisar crie um @BeforeTest para configurar os testes. */
	public void Setup() {
		Update.generico("insert into usuarios (name) values ('Quimera');");
	}
	
	@Test(	
		description = "Valida digitação do username de usuario", 
		suiteName = "Validação de Campos" /*Nome da Suite de Teste (Se possuir), caso não possua, pode usar o nome da classe*/
	)
	@Story("Login")
	public void test000() throws SQLException {
		String nomeUsuario = Select.textoEmColuna("select * from usuarios;", "name");
		uiTool
			.navegateTo("http://www.juliodelima.com.br//taskit")
			.waitPage(false)
			.waitField(By.linkText("Sign in"), false)
			.click(By.linkText("Sign in"))
			.waitField(By.xpath("//*[@id='signinbox']/div[1]/form/div[2]/div[1]/input"), false)
			.setKeys(nomeUsuario, By.xpath("//*[@id='signinbox']/div[1]/form/div[2]/div[1]/input"))
		;
		AssertThat.ui().isEqualValue(By.xpath("//*[@id='signinbox']/div[1]/form/div[2]/div[1]/input"), nomeUsuario);
	}

}
```

------------

#### Extendendo Pacote Genérico.
O pacote de extensão genérico é `quimera.test.extension.SimpleTestExtension`, esta extensão não irá chamar o navegador ao iniciar os testes, mas conterá tudo necessário para ambos os tipos de testes.

------------

## Utilitários

O Quimera possui alguns utilitários para os testes, estes servem para facilitar o dia a dia e melhorar a forma que a automação é construída.

#### uiTool
Possui diversas funcionalidades para os testes de interface, com a maioria dos comandos podendo chamar outros, por exemplo:

```
		uiTool
			.navegateTo("http://www.juliodelima.com.br//taskit")
			.waitPage(false)
			.waitField(By.linkText("Sign in"), false)
			.click(By.linkText("Sign in"))
			.waitField(By.xpath("//*[@id='signinbox']/div[1]/form/div[2]/div[1]/input"), false)
			.setKeys("Teste", By.xpath("//*[@id='signinbox']/div[1]/form/div[2]/div[1]/input"))
		;
```
Para saber mais sobre cada função do uiTool, acesse **uiTool**.

------------

#### DateTimeUtilities
Possui diversos facilitadores para se trabalhar com data e hora com o Java, por exemplo:

###### Adicionar 5 dias em uma data:
```
String data = DateTimeUtilities.Add.days(DateTimeUtilities.now(), 5);
```
###### Remover 5 dias em uma data:
```
String data = DateTimeUtilities.ToRemove.days(DateTimeUtilities.now(), 5);
```

Para saber mais sobre cada função do DateTimeUtilities, acesse **DateTimeUtilities**

------------

#### DataBaseUtilities
Possui facilitadores para a comunicação com o banco de dados. Nele temos duas variantes:

##### Select
Nesta variante, os facilitadores são para obter informação do banco de dados, podendo fazer selects genéricos ou buscando dados de certas colunas, exemplo:

###### Selecionar uma informação específica de um usuário 
```
String nomeUsuario = select.textoEmColuna("select * from usuarios;", "name");
```

------------

##### update
Nesta variante, os facilitadores são para inserir informações no banco, como inserts, updates, deletes e outras ações, como por exemplo:

###### Inserir um usuário
```
update.generico("insert into usuarios (name) values ('Quimera');");
```

------------

Para mais informações das funcionalidades do DataBaseUtilities, acesse **DataBaseUtilities**.

------------

## Assertions
Quimera possui facilitadores para os Assertions também, para tal você poderá usar alguns tipos de assertion que chama-se entre si.

#### AssertThat
O assertThat é o pai dos asserts do quimera, com ele iremos fazer os asserts de APIs e de itens de interface, além de outros tipos de asserts.

Nele temos alguns asserts padrões como exemplo:

###### Validar dois textos
```
string textoA = "Teste";
string textoB = "TesteInvalido";
AssertThat.isEqualText(textoA, textoB)
```

------------

###### Validar se texto é nulo
```
string textoInvalido = null;
AssertThat.isNotNullText(textoInvalido)
```

Dê uma olhada nas outras validações padrões em **AssertThat**, além disso temos validações específicas para os testes de API e de Interface.

##### rest
As validações do rest são referentes aos responses de retorno das APIs, temos alguns como.

###### Validar status do return
```
	@JsonAutoDetect(fieldVisibility = Visibility.ANY)
	public class user{
		String name;
		String salary;
		String age;
	};

	@Test(	
		description = "Valida Status de Cadastro", 
		suiteName = "Validações" 
	)
	@Story("Cadastrod de Usuario")
	public void test000() throws SQLException {
		String URLAPI = getUrlAPI() + "create";
		user usuario = new user();
		usuario.name = "Teste";
		usuario.salary = "123";
		usuario.age = "25";
		Response resposta = TestRequest.request(HttpMethod.POST, false, null, usuario, URLAPI);
		int status_esperado = 200;
		AssertThat.rest().isEqualStatusCode(resposta, status_esperado);
	}
```

Há outros assertions do tipo rest, acesse **AssertThat.rest()** para dar uma olhada.



##### UI
As validações de UI são referentes e elementos da tela, elementos de interface do usuário, tais como botões e campos exibidos nos navegadores.

###### Validar se campo está visivel
```
	@Test(description = "Valida Campo Nome", suiteName = "Validações")
	@Story("Valida Campo Nome")
	public void test000() throws SQLException {
		By botaoCriarUsuario = By.xpath("//a[@class='btn btn-primary btn-sm']");
		By campoNome = By.xpath("//input[@placeholder='Nome']");
		uiTool
			.navegateTo("http://yoble.us/login")
			.click(botaoCriarUsuario)
			.waitPage(false)
			.setKeys("Perfil BETA", campoNome);
		AssertThat.ui().isEqualValue(campoNome, "Perfil BETA");
	}
```

Há outros assertions do tipo ui, acesse **AssertThat.ui()** para dar uma olhada.
