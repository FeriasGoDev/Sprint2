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
//	 * Retorna valor total das f�rias vendidas.
//	 * 
//	 * Multiplica o parametro totalDiasTirados por valorUmDiaDeTrabalho.
//	 * 
//	 * @param totalDiasTirados     Quantidade de dias de f�rias tirado.
//	 * @param valorUmDiaDeTrabalho Valor total de um dia de trabalho.
//	 * @return
//	 */
//	public static double retornarValorDasFeriasVendidas(int totalDiasTirados, double valorUmDiaDeTrabalho) {
//		double valorTotal = totalDiasTirados * valorUmDiaDeTrabalho;
//		return valorTotal;
//	}


	/*
	 * Caso haja, o sistema retorna uma lista do nome dos colaboradores contendo:
	 * tipo de f�rias, data de in�cio e fim, solicita��o de f�rias em andamento
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
	 * Altera periodo de concess�o de f�rias parciais.
	 * 
	 * Altera o per�odo de concess�o de f�rias atrav�s da nova data de in�cio e
	 * t�rmino informadas.
	 * 
	 * @param idPeriodo       ID do per�odo a ser alterado.
	 * @param novaDataInicio  Nova data de in�cio do per�odo.
	 * @param novaDataTermino Nova data de t�rmino do per�odo.
	 * @return
	 */
//	public static void alterarPeriodoDeFeriasParciais(int idPeriodo, LocalDate novaDataInicio,
//			LocalDate novaDataTermino) {
//		long novoPeriodo = retornarIntervaloEmDiasEntreAsDatas(novaDataInicio, novaDataTermino);
//		feriasTiradas[idPeriodo] = (int) novoPeriodo;
//	}

	/**
	 * Informa o novo per�odo de concess�o de f�rias parciais.
	 * 
	 * Retorna uma mensagem do tipo String contendo quantidade de dias do novo
	 * per�odo e datas de in�cio e fim.
	 * 
	 * @param idTipoDePeriodo
	 * @param dataInicio      Nova data de in�cio do per�odo.
	 * @param dataTermino     Nova data de t�rmino do per�odo.
	 * @return
	 */
//	public static String informarNovoPeriodoDeConcessaoParcial(int idTipoDePeriodo, LocalDate dataInicio,
//			LocalDate dataTermino) {
//		int periodoEmDias = (int) retornarIntervaloEmDiasEntreAsDatas(dataInicio, dataTermino);
//		String mensagem = "Tipo de per�odo: " + tiposDePeriodo[idTipoDePeriodo] + ". Quantidade de dias tirados: "
//				+ periodoEmDias + ".";
//		return mensagem;
//	}

//	/**
//	 * Informa o novo per�odo de concess�o de f�rias totais.
//	 * 
//	 * Retorna uma mensagem do tipo String contendo quantidade de dias do novo
//	 * per�odo e data de in�cio.
//	 * 
//	 * @param idTipoDePeriodo ID referente ao tipo do per�odo.
//	 * @param idFeriasTiradas ID referente �s f�rias tiradas.
//	 * @return
//	 */
//	public static String informarNovoPeriodoDeConcessaoTotal(int idTipoDePeriodo, int idFeriasTiradas) {
//		int periodoEmDias = feriasTiradas[idFeriasTiradas];
//		String mensagem = "Tipo de per�odo: " + tiposDePeriodo[idTipoDePeriodo] + ". Quantidade de dias tirados: "
//				+ periodoEmDias + ".";
//		return mensagem;
//	}


	//// Janaina <<<<<<<<<< end

	// BRUNO START

	/**
	 * Verifica se poss�i colaboradores na equipe Verifica se o us�ario poss�i
	 * colaboradores em sua equipe atrav� de valor recebido
	 * 
	 * @author Bruno Marques
	 * @param id int Recebe um valor (quantidade de funcionarios) para fazer a
	 *           valida��o
	 * @return possuiColab true ou false
	 */

//	/**
//	 * Consulta f�rias de membros da equipe Ap�s verificar se o us�ario poss�i
//	 * colaboradores em sua equipe, o sistema retorna quais colaboradores s�o da
//	 * equipe e o saldo de f�rias de cada um
//	 * 
//	 * @author Bruno Marques
//	 * @param listaDeColaboradores int[] recebe vetor com lista de colaboradores
//	 * @param saldoDeFerias        int[] recebe vetor com saldo de f�rias por
//	 *                             colaborador
//	 * @return uma lista com uma lista de colaoradres da equipe e outra lista de
//	 *         saldo de f�rias de cada um
//	 */
//	public static ArrayList<Integer> consultaSituacaoDeFeriasDaEquipe(int[] listaDeColaboradores, int[] saldoDeFerias) {
//		ArrayList<Integer> lista = new ArrayList<Integer>();
//		if (consultarColaboraoresDaEquipe(recebeColaboradores)) {
//			System.out.println("Voc� possui " + listaDeColaboradores.length + " colaboradores em sua equipe.");
//			for (int c = 0; c < listaDeColaboradores.length; c++) {
//				int colab = listaDeColaboradores[c];
//				lista.add(saldoDeFerias[colab]);
//				System.out.println("O colaborador de id " + listaDeColaboradores[c] + " possui " + saldoDeFerias[c]
//						+ " dias de f�rias.");
//			}
//		} else {
//			System.out.println("O usu�rio n�o possui colaboradores em sua equipe");
//		}
//		return lista;
//	}

	// BRUNO END
