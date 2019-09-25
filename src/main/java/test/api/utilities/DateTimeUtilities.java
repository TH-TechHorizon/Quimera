package test.api.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import test.api.core.TestCoreCentralizer;


/**	
 * A classe DateTimeUtilities tem como o principal objetivo facilitar o uso de datas na automação como um todo.
 * <br>
 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/datetimeutilities">DateTimeUtilities</a>
**/
public class DateTimeUtilities extends TestCoreCentralizer {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**	Objetivo: Pegar a data atual e formatar no padrão do banco de dados yyyy-MM-dd
	 * 	<br>
	 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/datetimeutilities#now">now()</a>
	 *	@return Retorna a data em String formatada no padrão "yyyy-MM-dd". <br> Exemplo: <code>String data = DataAtual();</code>
	**/
	public static String now() {
		LocalDate data = LocalDate.parse(LocalDate.now().toString(), formatter);
		return formatter.format(data).toString();
	}
	/**	Objetivo: Pegar a data atual e formatar pelo formatter definido no parâmetro.
	 * 	<br>
	 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/datetimeutilities#nowdatetimeformatter-format">now(DateTimeFormatter format)</a>
	 * 	@param format = [DateTimeFormatter] é o formato para qual a data atual será convertida. <br> Exemplo: <code>String data = DataAtual(DateTimeFormatter.ofPattern("yyyy-MM-dd"));</code>
	 *	@return Retorna a data em String formatada no formato definido no parâmetro.
	**/
	public static String now(DateTimeFormatter format) {
		String data = LocalDate.now().format(format).toString();
		return data;
	}
	/**	Objetivo: Formata datas para o formato parametrizado.
	 *	<br>
	 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/datetimeutilities#formatdatetimestring-date-datetimeformatter-format">formatDateTime(String date, DateTimeFormatter format)</a> 
	 * 	@param date = [String] Data da que será formatada.
	 * 	@param format = [DateTimeFormatter] Formato de data, o mais usado seria o <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
	 *	@return Retorna a data em String formatada no formato yyyy-MM-dd.
	**/
	public static String formatDateTime(String date, DateTimeFormatter format) {
		LocalDate data = LocalDate.parse(date);
		return data.format(format).toString();
	}


	/**	
	 * A classe DateTimeUtilities.Add possui métodos para acrescentar dias, semanas, meses e anos em datas atuais ou datas parametrizadas além de permitir escolher a formatação do retorno.
	 * <br>
	 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add">DateTimeUtilities.Add</a>
	**/
	public static class Add{
	
		/*----Dias----*/
	
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Dias</b> a partir da data atual.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#daysint-days">days(int days)</a>
		 * 	@param days = [Integer] Quantidade de <b>Dias</b> a serem adicionados.
		 *	@return Retorna a data em String com a quantidade de <b>Dias</b> adicionados e formatada no padrão yyyy-MM-dd.
		**/
		public static String days(int days) {
			LocalDate data = LocalDate.parse(now()).plusDays(days);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Dias</b> a partir da data parametrizada.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#daysstring-date-int-days">days(String date, int days)</a>
		 * 	@param date = [String] Data que será acrescentado a quantidade de <b>Dias</b>.
		 * 	@param days = [Integer] Quantidade de <b>Dias</b> a serem adicionados.
		 *	@return Retorna a data em String, com a quantidade de <b>Dias</b> adicionados e formatada no formato yyyy-MM-dd.
		**/
		public static String days(String date, int days) {
			LocalDate data = LocalDate.parse(date).plusDays(days);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Dias</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#daysstring-date-int-days-datetimeformatter-format">days(String date, int days, DateTimeFormatter format)</a>
		 * 	@param date = [String] Data que será acrescentado a quantidade de <b>Dias</b>.
		 * 	@param days = [Integer] Quantidade de <b>Dias</b> a serem adicionados.
		 * 	@param format = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Dias</b> adicionados em String, e formatada no padrão desejado.
		**/
		public static String days(String date, int days, DateTimeFormatter format) {
			LocalDate data = LocalDate.parse(date).plusDays(days);
			return formatDateTime(data.toString(), format);
		}
	
	
		/*----Semanas----*/
	
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Semanas</b> a partir da data atual.
		 *	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#weeksint-weeks">weeks(int weeks)</a> 
		 * 	@param weeks = [Integer] Quantidade de <b>Semanas</b> a serem adicionados.
		 *	@return Retorna a data em String com a quantidade de <b>Semanas</b> adicionados e formatada no padrão yyyy-MM-dd.
		**/
		public static String weeks(int weeks) {
			LocalDate data = LocalDate.parse(now()).plusWeeks(weeks);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Semanas</b> a partir da data parametrizada.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#weeksstring-date-int-weeks">weeks(String date, int weeks)</a>
		 * 	@param date = [String] Data que será acrescentado a quantidade de <b>Semanas</b>.
		 * 	@param weeks = [Integer] Quantidade de <b>Semanas</b> a serem adicionados.
		 *	@return Retorna a data em String, com a quantidade de <b>Semanas</b> adicionados e formatada no formato yyyy-MM-dd.
		**/
		public static String weeks(String date, int weeks) {
			LocalDate data = LocalDate.parse(date).plusWeeks(weeks);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Semanas</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#weeksstring-date-int-weeks-datetimeformatter-format">weeks(String date, int weeks, DateTimeFormatter format)</a>
		 * 	@param date = [String] Data que será acrescentado a quantidade de <b>Semanas</b>.
		 * 	@param weeks = [Integer] Quantidade de <b>Semanas</b> a serem adicionados.
		 * 	@param format = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Semanas</b> adicionados em String, e formatada no padrão desejado.
		**/
		public static String weeks(String date, int weeks, DateTimeFormatter format) {
			LocalDate data = LocalDate.parse(date).plusWeeks(weeks);
			return formatDateTime(data.toString(), format);
		}
	
	
		/*----Meses----*/
	
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Meses</b> a partir da data atual.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#monthsint-months">months(int months)</a>
		 * 	@param months = [Integer] Quantidade de <b>Meses</b> a serem adicionados.
		 *	@return Retorna a data em String com a quantidade de <b>Meses</b> adicionados e formatada no padrão yyyy-MM-dd.
		**/
		public static String months(int months) {
			LocalDate data = LocalDate.parse(now()).plusMonths(months);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Meses</b> a partir da data parametrizada.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#monthsstring-date-int-months">months(String date, int months)</a>
		 * 	@param date = [String] Data que será acrescentado a quantidade de <b>Meses</b>.
		 * 	@param months = [Integer] Quantidade de <b>Meses</b> a serem adicionados.
		 *	@return Retorna a data em String, com a quantidade de <b>Meses</b> adicionados e formatada no formato yyyy-MM-dd.
		**/
		public static String months(String date, int months) {
			LocalDate data = LocalDate.parse(date).plusMonths(months);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Meses</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#monthsstring-date-int-months-datetimeformatter-format">months(String date, int months, DateTimeFormatter format)</a>
		 * 	@param Data = [String] Data que será acrescentado a quantidade de <b>Meses</b>.
		 * 	@param months = [Integer] Quantidade de <b>Meses</b> a serem adicionados.
		 * 	@param format = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Meses</b> adicionados em String, e formatada no padrão desejado.
		**/
		public static String months(String date, int months, DateTimeFormatter format) {
			LocalDate data = LocalDate.parse(date).plusMonths(months);
			return formatDateTime(data.toString(), format);
		}
	
	
		/*----Anos----*/
	
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Anos</b> a partir da data atual.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#yearsint-years">years(int years)</a>
		 * 	@param years = [Integer] Quantidade de <b>Anos</b> a serem adicionados.
		 *	@return Retorna a data em String com a quantidade de <b>Anos</b> adicionados e formatada no padrão yyyy-MM-dd.
		**/
		public static String years(int years) {
			LocalDate data = LocalDate.parse(now()).plusYears(years);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Anos</b> a partir da data parametrizada.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#yearsstring-date-int-years">years(String date, int years)</a>
		 * 	@param date = [String] Data que será acrescentado a quantidade de <b>Anos</b>.
		 * 	@param years = [Integer] Quantidade de <b>Anos</b> a serem adicionados.
		 *	@return Retorna a data em String, com a quantidade de <b>Anos</b> adicionados e formatada no formato yyyy-MM-dd.
		**/
		public static String years(String date, int years) {
			LocalDate data = LocalDate.parse(date).plusYears(years);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Anos</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.Add#yearsstring-date-int-years-datetimeformatter-format">years(String date, int years, DateTimeFormatter format)</a>
		 * 	@param date = [String] Data que será acrescentado a quantidade de <b>Anos</b>.
		 * 	@param years = [Integer] Quantidade de <b>Anos</b> a serem adicionados.
		 * 	@param format = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Anos</b> adicionados em String, e formatada no padrão desejado.
		**/
		public static String years(String date, int years, DateTimeFormatter format) {
			LocalDate data = LocalDate.parse(date).plusYears(years);
			return formatDateTime(data.toString(), format);
		}
	
	}

	/**	
	 * A classe DateTimeUtilities.ToRemove possui métodos para remover dias, semanas, meses e anos em datas atuais ou datas parametrizadas além de permitir escolher a formatação do retorno.
	 * <br>
	 * @see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove">DateTimeUtilities.ToRemove</a>
	**/
	public static class ToRemove{
	
		/*----Dias----*/
	
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Dias</b> a partir da data atual.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#daysint-days">days(int days)</a>
		 * 	@param days = [Integer] Quantidade de <b>Dias</b> a serem removidos.
		 *	@return Retorna a data em String com a quantidade de <b>Dias</b> diminuidos e formatada no padrão yyyy-MM-dd.
		**/
		public static String days(int days) {
			LocalDate data = LocalDate.parse(now()).minusDays(days);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Dias</b> a partir da data parametrizada.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#daysstring-date-int-days">days(String date, int days)</a>
		 * 	@param date = [String] Data que será diminuido a quantidade de <b>Dias</b>.
		 * 	@param days = [Integer] Quantidade de <b>Dias</b> a serem diminuidos.
		 *	@return Retorna a data em String, com a quantidade de <b>Dias</b> diminuidos e formatada no formato yyyy-MM-dd.
		**/
		public static String days(String date, int days) {
			LocalDate data = LocalDate.parse(date).minusDays(days);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Dias</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#daysstring-date-int-days-datetimeformatter-format">days(String date, int days, DateTimeFormatter format)</a>
		 * 	@param date = [String] Data que será diminuido a quantidade de <b>Dias</b>.
		 * 	@param days = [Integer] Quantidade de <b>Dias</b> a serem diminuidos.
		 * 	@param format = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Dias</b> diminuidos em String, e formatada no padrão desejado.
		**/
		public static String days(String date, int days, DateTimeFormatter format) {
			LocalDate data = LocalDate.parse(date).minusDays(days);
			return formatDateTime(data.toString(), format);
		}
	
	
		/*----Semanas----*/
	
		/**	Objetivo: <b>Diminui</b> a quantidade de <b>Semanas</b> a partir da data atual.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#weeksint-weeks">weeks(int weeks)</a>
		 * 	@param weeks = [Integer] Quantidade de <b>Semanas</b> a serem removidas.
		 *	@return Retorna a data em String com a quantidade de <b>Semanas</b> diminuidos e formatada no padrão yyyy-MM-dd.
		**/
		public static String weeks(int weeks) {
			LocalDate data = LocalDate.parse(now()).minusWeeks(weeks);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Semanas</b> a partir da data parametrizada.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#weeksstring-date-int-weeks">weeks(String date, int weeks)</a>
		 * 	@param date = [String] Data que será diminuido a quantidade de <b>Semanas</b>.
		 * 	@param weeks = [Integer] Quantidade de <b>Semanas</b> a serem diminuidos.
		 *	@return Retorna a data em String, com a quantidade de <b>Semanas</b> diminuidos e formatada no formato yyyy-MM-dd.
		**/
		public static String weeks(String date, int weeks) {
			LocalDate data = LocalDate.parse(date).minusWeeks(weeks);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Semanas</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#weeksstring-date-int-weeks-datetimeformatter-format">weeks(String date, int weeks, DateTimeFormatter format)</a>
		 * 	@param date = [String] Data que será diminuido a quantidade de <b>Semanas</b>.
		 * 	@param weeks = [Integer] Quantidade de <b>Semanas</b> a serem diminuidos.
		 * 	@param format = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Semanas</b> diminuidos em String, e formatada no padrão desejado.
		**/
		public static String weeks(String date, int weeks, DateTimeFormatter format) {
			LocalDate data = LocalDate.parse(date).minusWeeks(weeks);
			return formatDateTime(data.toString(), format);
		}
	
	
		/*----Meses----*/
	
		/**	Objetivo: <b>Diminui</b> a quantidade de <b>Meses</b> a partir da data atual.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#monthsint-months">months(int months)</a>
		 * 	@param months = [Integer] Quantidade de <b>Meses</b> a serem removidos.
		 *	@return Retorna a data em String com a quantidade de <b>Meses</b> diminuidos e formatada no padrão yyyy-MM-dd.
		**/
		public static String months(int months) {
			LocalDate data = LocalDate.parse(now()).minusMonths(months);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Meses</b> a partir da data parametrizada.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#monthsstring-date-int-months">months(String date, int months)</a>
		 * 	@param date = [String] Data que será diminuido a quantidade de <b>Meses</b>.
		 * 	@param months = [Integer] Quantidade de <b>Meses</b> a serem diminuidos.
		 *	@return Retorna a data em String, com a quantidade de <b>Meses</b> diminuidos e formatada no formato yyyy-MM-dd.
		**/
		public static String months(String date, int months) {
			LocalDate data = LocalDate.parse(date).minusMonths(months);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Meses</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#monthsstring-date-int-months-datetimeformatter-format">months(String date, int months, DateTimeFormatter format)</a>
		 * 	@param date = [String] Data que será diminuido a quantidade de <b>Meses</b>.
		 * 	@param months = [Integer] Quantidade de <b>Meses</b> a serem diminuidos.
		 * 	@param format = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Meses</b> diminuidos em String, e formatada no padrão desejado.
		**/
		public static String months(String date, int months, DateTimeFormatter format) {
			LocalDate data = LocalDate.parse(date).minusMonths(months);
			return formatDateTime(data.toString(), format);
		}
	
	
		/*----Anos----*/
	
		/**	Objetivo: <b>Diminui</b> a quantidade de <b>Anos</b> a partir da data atual.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#yearsint-years">years(int years)</a>
		 * 	@param years = [Integer] Quantidade de <b>Anos</b> a serem removidas.
		 *	@return Retorna a data em String com a quantidade de <b>Anos</b> diminuidos e formatada no padrão yyyy-MM-dd.
		**/
		public static String years(int years) {
			LocalDate data = LocalDate.parse(now()).minusYears(years);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Anos</b> a partir da data parametrizada.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#yearsstring-date-int-years">years(String date, int years)</a>
		 * 	@param date = [String] Data que será diminuido a quantidade de <b>Anos</b>.
		 * 	@param years = [Integer] Quantidade de <b>Anos</b> a serem diminuidos.
		 *	@return Retorna a data em String, com a quantidade de <b>Anos</b> diminuidos e formatada no formato yyyy-MM-dd.
		**/
		public static String years(String date, int years) {
			LocalDate data = LocalDate.parse(date).minusYears(years);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Anos</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	<br>
		 * 	@see <a href="http://git.senior.com.br/gestao-empresarial/erpx-core-api-test/wikis/DateTimeUtilities.ToRemove#yearsstring-date-int-years-datetimeformatter-format">years(String date, int years, DateTimeFormatter format)</a>
		 * 	@param date = [String] Data que será diminuido a quantidade de <b>Anos</b>.
		 * 	@param years = [Integer] Quantidade de <b>Anos</b> a serem diminuidos.
		 * 	@param format = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Anos</b> diminuidos em String, e formatada no padrão desejado.
		**/
		public static String years(String date, int years, DateTimeFormatter format) {
			LocalDate data = LocalDate.parse(date).minusYears(years);
			return formatDateTime(data.toString(), format);
		}
	
	}

}