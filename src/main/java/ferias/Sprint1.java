//package ferias;
//
//import java.util.ArrayList;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
//
//public class Sprint1 {
//

//	/**
//	 * Retorna valor total das férias vendidas.
//	 * 
//	 * Multiplica o parametro totalDiasTirados por valorUmDiaDeTrabalho.
//	 * 
//	 * @param totalDiasTirados     Quantidade de dias de férias tirado.
//	 * @param valorUmDiaDeTrabalho Valor total de um dia de trabalho.
//	 * @return
//	 */
//	public static double retornarValorDasFeriasVendidas(int totalDiasTirados, double valorUmDiaDeTrabalho) {
//		double valorTotal = totalDiasTirados * valorUmDiaDeTrabalho;
//		return valorTotal;
//	}


	/*
	 * Caso haja, o sistema retorna uma lista do nome dos colaboradores contendo:
	 * tipo de férias, data de início e fim, solicitação de férias em andamento
	 */

	/**
	 * Retorna colaboradores do setor informado.
	 * 
	 * Retorna uma List contendo os colaboradores que trabalham no setor que possui
	 * o id informado.
	 * 
	 * @param idSetor ID do setor a ser consultado.
	 * @return
	 */
//	public static ArrayList<String> retornarColaboradoresDoSetor(int idSetor) {
//		ArrayList<String> colaboradoresDoSetorInformado = new ArrayList<String>();
//
//		for (String colaborador : colaboradores[idSetor]) {
//			colaboradoresDoSetorInformado.add(colaborador);
//		}
//
//		return colaboradoresDoSetorInformado;
//	}

	/**
	 * Altera periodo de concessão de férias parciais.
	 * 
	 * Altera o período de concessão de férias através da nova data de início e
	 * término informadas.
	 * 
	 * @param idPeriodo       ID do período a ser alterado.
	 * @param novaDataInicio  Nova data de início do período.
	 * @param novaDataTermino Nova data de término do período.
	 * @return
	 */
//	public static void alterarPeriodoDeFeriasParciais(int idPeriodo, LocalDate novaDataInicio,
//			LocalDate novaDataTermino) {
//		long novoPeriodo = retornarIntervaloEmDiasEntreAsDatas(novaDataInicio, novaDataTermino);
//		feriasTiradas[idPeriodo] = (int) novoPeriodo;
//	}

	/**
	 * Informa o novo período de concessão de férias parciais.
	 * 
	 * Retorna uma mensagem do tipo String contendo quantidade de dias do novo
	 * período e datas de início e fim.
	 * 
	 * @param idTipoDePeriodo
	 * @param dataInicio      Nova data de início do período.
	 * @param dataTermino     Nova data de término do período.
	 * @return
	 */
//	public static String informarNovoPeriodoDeConcessaoParcial(int idTipoDePeriodo, LocalDate dataInicio,
//			LocalDate dataTermino) {
//		int periodoEmDias = (int) retornarIntervaloEmDiasEntreAsDatas(dataInicio, dataTermino);
//		String mensagem = "Tipo de período: " + tiposDePeriodo[idTipoDePeriodo] + ". Quantidade de dias tirados: "
//				+ periodoEmDias + ".";
//		return mensagem;
//	}

//	/**
//	 * Informa o novo período de concessão de férias totais.
//	 * 
//	 * Retorna uma mensagem do tipo String contendo quantidade de dias do novo
//	 * período e data de início.
//	 * 
//	 * @param idTipoDePeriodo ID referente ao tipo do período.
//	 * @param idFeriasTiradas ID referente às férias tiradas.
//	 * @return
//	 */
//	public static String informarNovoPeriodoDeConcessaoTotal(int idTipoDePeriodo, int idFeriasTiradas) {
//		int periodoEmDias = feriasTiradas[idFeriasTiradas];
//		String mensagem = "Tipo de período: " + tiposDePeriodo[idTipoDePeriodo] + ". Quantidade de dias tirados: "
//				+ periodoEmDias + ".";
//		return mensagem;
//	}


	//// Janaina <<<<<<<<<< end

	// BRUNO START

	/**
	 * Verifica se possúi colaboradores na equipe Verifica se o usúario possúi
	 * colaboradores em sua equipe atravé de valor recebido
	 * 
	 * @author Bruno Marques
	 * @param id int Recebe um valor (quantidade de funcionarios) para fazer a
	 *           validação
	 * @return possuiColab true ou false
	 */

//	/**
//	 * Consulta férias de membros da equipe Após verificar se o usúario possúi
//	 * colaboradores em sua equipe, o sistema retorna quais colaboradores são da
//	 * equipe e o saldo de férias de cada um
//	 * 
//	 * @author Bruno Marques
//	 * @param listaDeColaboradores int[] recebe vetor com lista de colaboradores
//	 * @param saldoDeFerias        int[] recebe vetor com saldo de férias por
//	 *                             colaborador
//	 * @return uma lista com uma lista de colaoradres da equipe e outra lista de
//	 *         saldo de férias de cada um
//	 */
//	public static ArrayList<Integer> consultaSituacaoDeFeriasDaEquipe(int[] listaDeColaboradores, int[] saldoDeFerias) {
//		ArrayList<Integer> lista = new ArrayList<Integer>();
//		if (consultarColaboraoresDaEquipe(recebeColaboradores)) {
//			System.out.println("Você possui " + listaDeColaboradores.length + " colaboradores em sua equipe.");
//			for (int c = 0; c < listaDeColaboradores.length; c++) {
//				int colab = listaDeColaboradores[c];
//				lista.add(saldoDeFerias[colab]);
//				System.out.println("O colaborador de id " + listaDeColaboradores[c] + " possui " + saldoDeFerias[c]
//						+ " dias de férias.");
//			}
//		} else {
//			System.out.println("O usuário não possui colaboradores em sua equipe");
//		}
//		return lista;
//	}

	// BRUNO END
