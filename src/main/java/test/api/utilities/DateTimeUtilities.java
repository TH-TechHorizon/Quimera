package test.api.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import test.api.core.TestCoreCentralizer;


/**	Objetivo: Faciltiador para pegar datas no formato correto (yyyy-MM-dd) podendo alterar para o formato desejado. **/
public class DateTimeUtilities extends TestCoreCentralizer {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	/**	Objetivo: Pegar a data atual e formatar no padrão do banco de dados yyyy-MM-dd
	 *	@return Retorna a data em String formatada no padrão "yyyy-MM-dd". <br> Exemplo: <code>String data = DataAtual();</code>
	**/
	public static String now() {
		LocalDate data = LocalDate.parse(LocalDate.now().toString(), formatter);
		return formatter.format(data).toString();
	}
	/**	Objetivo: Pegar a data atual e formatar pelo formatter definido no parâmetro.
	 * 	@param Formato = [DateTimeFormatter] é o formato para qual a data atual será convertida. <br> Exemplo: <code>String data = DataAtual(DateTimeFormatter.ofPattern("yyyy-MM-dd"));</code>
	 *	@return Retorna a data em String formatada no formato definido no parâmetro.
	**/
	public static String now(DateTimeFormatter Formato) {
		String data = LocalDate.now().format(Formato).toString();
		return data;
	}
	/**	Objetivo: Formata datas para o formato parametrizado.
	 * 	@param Data = [String] Data da que será formatada.
	 * 	@param Formato = [DateTimeFormatter] Formato de data, o mais usado seria o <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
	 *	@return Retorna a data em String formatada no formato yyyy-MM-dd.
	**/
	public static String formatDateTime(String Data, DateTimeFormatter Formato) {
		LocalDate data = LocalDate.parse(Data);
		return data.format(Formato).toString();
	}
	
	
	public static class Add{
	
		/*----Dias----*/
	
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Dias</b> a partir da data atual.
		 * 	@param Dias = [Integer] Quantidade de <b>Dias</b> a serem adicionados.
		 *	@return Retorna a data em String com a quantidade de <b>Dias</b> adicionados e formatada no padrão yyyy-MM-dd.
		**/
		public static String days(int Dias) {
			LocalDate data = LocalDate.parse(now()).plusDays(Dias);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Dias</b> a partir da data parametrizada.
		 * 	@param Data = [String] Data que será acrescentado a quantidade de <b>Dias</b>.
		 * 	@param Dias = [Integer] Quantidade de <b>Dias</b> a serem adicionados.
		 *	@return Retorna a data em String, com a quantidade de <b>Dias</b> adicionados e formatada no formato yyyy-MM-dd.
		**/
		public static String days(String Data, int Dias) {
			LocalDate data = LocalDate.parse(Data).plusDays(Dias);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Dias</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	@param Data = [String] Data que será acrescentado a quantidade de <b>Dias</b>.
		 * 	@param Dias = [Integer] Quantidade de <b>Dias</b> a serem adicionados.
		 * 	@param Formato = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Dias</b> adicionados em String, e formatada no padrão desejado.
		**/
		public static String days(String Data, int Dias, DateTimeFormatter Formato) {
			LocalDate data = LocalDate.parse(Data).plusDays(Dias);
			return Formato.format(data).toString();
		}
	
	
		/*----Semanas----*/
	
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Semanas</b> a partir da data atual.
		 * 	@param Semanas = [Integer] Quantidade de <b>Semanas</b> a serem adicionados.
		 *	@return Retorna a data em String com a quantidade de <b>Semanas</b> adicionados e formatada no padrão yyyy-MM-dd.
		**/
		public static String weeks(int Semanas) {
			LocalDate data = LocalDate.parse(now()).plusWeeks(Semanas);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Semanas</b> a partir da data parametrizada.
		 * 	@param Data = [String] Data que será acrescentado a quantidade de <b>Semanas</b>.
		 * 	@param Semanas = [Integer] Quantidade de <b>Semanas</b> a serem adicionados.
		 *	@return Retorna a data em String, com a quantidade de <b>Semanas</b> adicionados e formatada no formato yyyy-MM-dd.
		**/
		public static String weeks(String Data, int Semanas) {
			LocalDate data = LocalDate.parse(Data).plusWeeks(Semanas);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Semanas</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	@param Data = [String] Data que será acrescentado a quantidade de <b>Semanas</b>.
		 * 	@param Semanas = [Integer] Quantidade de <b>Semanas</b> a serem adicionados.
		 * 	@param Formato = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Semanas</b> adicionados em String, e formatada no padrão desejado.
		**/
		public static String weeks(String Data, int Semanas, DateTimeFormatter Formato) {
			LocalDate data = LocalDate.parse(Data).plusWeeks(Semanas);
			return Formato.format(data).toString();
		}
	
	
		/*----Meses----*/
	
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Meses</b> a partir da data atual.
		 * 	@param Meses = [Integer] Quantidade de <b>Meses</b> a serem adicionados.
		 *	@return Retorna a data em String com a quantidade de <b>Meses</b> adicionados e formatada no padrão yyyy-MM-dd.
		**/
		public static String months(int Meses) {
			LocalDate data = LocalDate.parse(now()).plusMonths(Meses);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Meses</b> a partir da data parametrizada.
		 * 	@param Data = [String] Data que será acrescentado a quantidade de <b>Meses</b>.
		 * 	@param Meses = [Integer] Quantidade de <b>Meses</b> a serem adicionados.
		 *	@return Retorna a data em String, com a quantidade de <b>Meses</b> adicionados e formatada no formato yyyy-MM-dd.
		**/
		public static String months(String Data, int Meses) {
			LocalDate data = LocalDate.parse(Data).plusMonths(Meses);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Meses</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	@param Data = [String] Data que será acrescentado a quantidade de <b>Meses</b>.
		 * 	@param Meses = [Integer] Quantidade de <b>Meses</b> a serem adicionados.
		 * 	@param Formato = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Meses</b> adicionados em String, e formatada no padrão desejado.
		**/
		public static String months(String Data, int Meses, DateTimeFormatter Formato) {
			LocalDate data = LocalDate.parse(Data).plusMonths(Meses);
			return data.format(Formato).toString();
		}
	
	
		/*----Anos----*/
	
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Anos</b> a partir da data atual.
		 * 	@param Anos = [Integer] Quantidade de <b>Anos</b> a serem adicionados.
		 *	@return Retorna a data em String com a quantidade de <b>Anos</b> adicionados e formatada no padrão yyyy-MM-dd.
		**/
		public static String years(int Anos) {
			LocalDate data = LocalDate.parse(now()).plusYears(Anos);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> a quantidade de <b>Anos</b> a partir da data parametrizada.
		 * 	@param Data = [String] Data que será acrescentado a quantidade de <b>Anos</b>.
		 * 	@param Anos = [Integer] Quantidade de <b>Anos</b> a serem adicionados.
		 *	@return Retorna a data em String, com a quantidade de <b>Anos</b> adicionados e formatada no formato yyyy-MM-dd.
		**/
		public static String years(String Data, int Anos) {
			LocalDate data = LocalDate.parse(Data).plusYears(Anos);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Adiciona</b> uma quantidade de <b>Anos</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	@param Data = [String] Data que será acrescentado a quantidade de <b>Anos</b>.
		 * 	@param Anos = [Integer] Quantidade de <b>Anos</b> a serem adicionados.
		 * 	@param Formato = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Anos</b> adicionados em String, e formatada no padrão desejado.
		**/
		public static String years(String Data, int Anos, DateTimeFormatter Formato) {
			LocalDate data = LocalDate.parse(Data).plusYears(Anos);
			return Formato.format(data).toString();
		}
	
	}
	
	public static class ToRemove{
	
		/*----Dias----*/
	
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Dias</b> a partir da data atual.
		 * 	@param Dias = [Integer] Quantidade de <b>Dias</b> a serem removidos.
		 *	@return Retorna a data em String com a quantidade de <b>Dias</b> diminuidos e formatada no padrão yyyy-MM-dd.
		**/
		public static String days(int Dias) {
			LocalDate data = LocalDate.parse(now()).minusDays(Dias);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Dias</b> a partir da data parametrizada.
		 * 	@param Data = [String] Data que será diminuido a quantidade de <b>Dias</b>.
		 * 	@param Dias = [Integer] Quantidade de <b>Dias</b> a serem diminuidos.
		 *	@return Retorna a data em String, com a quantidade de <b>Dias</b> diminuidos e formatada no formato yyyy-MM-dd.
		**/
		public static String days(String Data, int Dias) {
			LocalDate data = LocalDate.parse(Data).minusDays(Dias);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Dias</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	@param Data = [String] Data que será diminuido a quantidade de <b>Dias</b>.
		 * 	@param Dias = [Integer] Quantidade de <b>Dias</b> a serem diminuidos.
		 * 	@param Formato = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Dias</b> diminuidos em String, e formatada no padrão desejado.
		**/
		public static String days(String Data, int Dias, DateTimeFormatter Formato) {
			LocalDate data = LocalDate.parse(Data).minusDays(Dias);
			return Formato.format(data).toString();
		}
	
	
		/*----Semanas----*/
	
		/**	Objetivo: <b>Diminui</b> a quantidade de <b>Semanas</b> a partir da data atual.
		 * 	@param int Semanas = [Integer] Quantidade de <b>Semanas</b> a serem removidas.
		 *	@return Retorna a data em String com a quantidade de <b>Semanas</b> diminuidos e formatada no padrão yyyy-MM-dd.
		**/
		public static String weeks(int Semanas) {
			LocalDate data = LocalDate.parse(now()).minusWeeks(Semanas);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Semanas</b> a partir da data parametrizada.
		 * 	@param Data = [String] Data que será diminuido a quantidade de <b>Semanas</b>.
		 * 	@param Dias = [Integer] Quantidade de <b>Semanas</b> a serem diminuidos.
		 *	@return Retorna a data em String, com a quantidade de <b>Semanas</b> diminuidos e formatada no formato yyyy-MM-dd.
		**/
		public static String weeks(String Data, int Semanas) {
			LocalDate data = LocalDate.parse(Data).minusWeeks(Semanas);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Semanas</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	@param Data = [String] Data que será diminuido a quantidade de <b>Semanas</b>.
		 * 	@param Dias = [Integer] Quantidade de <b>Semanas</b> a serem diminuidos.
		 * 	@param Formato = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Semanas</b> diminuidos em String, e formatada no padrão desejado.
		**/
		public static String weeks(String Data, int Semanas, DateTimeFormatter Formato) {
			LocalDate data = LocalDate.parse(Data).minusWeeks(Semanas);
			return Formato.format(data).toString();
		}
	
	
		/*----Meses----*/
	
		/**	Objetivo: <b>Diminui</b> a quantidade de <b>Meses</b> a partir da data atual.
		 * 	@param int Meses = [Integer] Quantidade de <b>Meses</b> a serem removidos.
		 *	@return Retorna a data em String com a quantidade de <b>Meses</b> diminuidos e formatada no padrão yyyy-MM-dd.
		**/
		public static String months(int Meses) {
			LocalDate data = LocalDate.parse(now()).minusMonths(Meses);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Meses</b> a partir da data parametrizada.
		 * 	@param Data = [String] Data que será diminuido a quantidade de <b>Meses</b>.
		 * 	@param Dias = [Integer] Quantidade de <b>Meses</b> a serem diminuidos.
		 *	@return Retorna a data em String, com a quantidade de <b>Meses</b> diminuidos e formatada no formato yyyy-MM-dd.
		**/
		public static String months(String Data, int Meses) {
			LocalDate data = LocalDate.parse(Data).minusMonths(Meses);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Meses</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	@param Data = [String] Data que será diminuido a quantidade de <b>Meses</b>.
		 * 	@param Dias = [Integer] Quantidade de <b>Meses</b> a serem diminuidos.
		 * 	@param Formato = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Meses</b> diminuidos em String, e formatada no padrão desejado.
		**/
		public static String months(String Data, int Meses, DateTimeFormatter Formato) {
			LocalDate data = LocalDate.parse(Data).minusMonths(Meses);
			return formatDateTime(data.toString(), Formato);
		}
	
	
		/*----Anos----*/
	
		/**	Objetivo: <b>Diminui</b> a quantidade de <b>Anos</b> a partir da data atual.
		 * 	@param int Anos = [Integer] Quantidade de <b>Anos</b> a serem removidas.
		 *	@return Retorna a data em String com a quantidade de <b>Anos</b> diminuidos e formatada no padrão yyyy-MM-dd.
		**/
		public static String years(int Anos) {
			LocalDate data = LocalDate.parse(now()).minusYears(Anos);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Anos</b> a partir da data parametrizada.
		 * 	@param Data = [String] Data que será diminuido a quantidade de <b>Anos</b>.
		 * 	@param Dias = [Integer] Quantidade de <b>Anos</b> a serem diminuidos.
		 *	@return Retorna a data em String, com a quantidade de <b>Anos</b> diminuidos e formatada no formato yyyy-MM-dd.
		**/
		public static String years(String Data, int Anos) {
			LocalDate data = LocalDate.parse(Data).minusYears(Anos);
			return formatter.format(data).toString();
		}
		/**	Objetivo: <b>Diminui</b> uma quantidade de <b>Anos</b> a partir da data parametrizada e formata no padrão desejado.
		 * 	@param Data = [String] Data que será diminuido a quantidade de <b>Anos</b>.
		 * 	@param Dias = [Integer] Quantidade de <b>Anos</b> a serem diminuidos.
		 * 	@param Formato = [DateTimeFormatter] Formato de data, o mais usado seria o: <code>DateTimeFormatter.ofPattern("yyyy-MM-dd")</code>.
		 *	@return Retorna a data com a quantidade de <b>Anos</b> diminuidos em String, e formatada no padrão desejado.
		**/
		public static String years(String Data, int Anos, DateTimeFormatter Formato) {
			LocalDate data = LocalDate.parse(Data).minusYears(Anos);
			return Formato.format(data).toString();
		}
	
	}

}