package test.api.core;

import java.lang.reflect.Method;

import io.restassured.response.Response;

/**	Efetua os Logs. **/

public class TestLogger extends TestCoreCentralizer {

    /**	Função popular variável de relatório. **/
	public static void logInfo(Object infos) {
		conteudoTest.add(setEnter(2) + "--->" + infos.toString());
	}

    /**	Função receber a resposta da chamada e armazenar no log. **/
	public static void logResponse(Response response) {
		conteudoTest.add(setEnter(2) + "--->Resposta da chamada: " + response.asString());
	}

    /**	Função para exibir os dados de cada teste	[Não usar em outros locais]. **/
	public static void testInfoLogger(Method  testInfo) {
		tituloTest = setEnter(2) + "------------------------------------------------------------" + setEnter(1) + "Classe de Teste: " + testInfo.getName() + setEnter(1);
	}

    /**	Função para exibir os logs no console sem formatação. **/
	public static void printLog(Object infos) {
		System.out.println(infos.toString());
	}
	
	/**	Função para inserir uma ou mais linhas dentro de algum log. **/
	public static String setEnter(int quantidade) {
		String separadores = new String();
		while (quantidade > 0) {
			separadores = separadores + "\n";
			quantidade--;
		}
		return separadores;
	}

}