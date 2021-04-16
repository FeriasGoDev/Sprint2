package ferias;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Sprint1 {
	
	/**
	 * Verifica intervalo entre data da solicita��o e data de inicio das f�rias
	 * 
	 * Verifica se a data de in�cio das f�rias solicitada � 10 dias ap�s a data de solicita��o, retornando verdadeiro caso seja.
	 * 
	 * @param dataInicioFerias LocalDateTime - data de �nicio de f�rias solicitada
	 * @return boolean, de acordo com a condi��o (maior que 10 dias)
	 */
	public static boolean verificarDataSolicitacao(LocalDateTime dataInicioFerias) {
		boolean intervaloSuperior10dias = LocalDateTime.now().until(dataInicioFerias, ChronoUnit.DAYS) > 10? true : false;
		return intervaloSuperior10dias;
	}
//	/**
//	 * Verifica intervalo entre data inicio e data fim f�rias parciais
//	 * 
//	 * Verifica se o intervalo entre a data de in�cio e data de fim, considerando f�rias parciais, � inferior a 20 dias, retornando verdadeiro caso seja.
//	 * 
//	 * @param dataInicioFerias LocalDateTime - data de in�cio de f�rias solicitada pelo colaborador
//	 * @param dataFimFerias LocalDateTime - data do fim das f�rias solicitada pelo colaborador
//	 * @return boolean, de acordo com a condi��o (inferior a 20 dias)
//	 */
//	public static boolean verificarIntervaloFeriasParciais(LocalDateTime dataInicioFerias, LocalDateTime dataFimFerias) {
//		boolean intervaloInferior20dias = dataInicioFerias.until(dataFimFerias, ChronoUnit.DAYS) < 20? true : false;
//		return intervaloInferior20dias;
//	}
//
//	/**
//	 * Registra as datas de in�cio e fim das f�rias totais
//	 * 
//	 * Realiza o registro das datas de in�cio e fim de f�rias totais solicitadas pelo colaborador. 
//	 * A data fim � calculada 30 dias ap�s a data de in�cio solicitada.
//	 * O registro do pedido s� ocorre caso a data de in�cio das f�rias seja, pelo menos, ap�s 10 dias a data da solicita��o. 
//	 * 
//	 * @param dataInicioFerias LocalDateTime - data de in�cio de f�rias solicitada pelo colaborador
//	 */
//	public static void registraFeriasTotais(LocalDateTime dataInicioFerias){
//		if (verificarDataSolicitacao(dataInicioFerias)) {
//
//			LocalDateTime dataFimFerias = calculaDataFimFeriasTotais(dataInicioFerias);
//
//			registraDataInicioFerias(dataInicioFerias);
//			registraDataFimFerias(dataFimFerias);
//
//		} else {
//			System.out.println("A data da solicita��o � inferior a 10 dias deste chamado");
//		}
//	}
//
//	/**
//	 * Registra as datas de in�cio e fim das f�rias parciais
//	 * 
//	 * Realiza o registro das datas de in�cio e fim de f�rias parciais solicitadas pelo colaborador. 
//	 * Para solicitar f�rias parcial, o intervalo entre in�cio e fim n�o pode ser superior a 20 dias. 
//	 * O registro do pedido s� ocorre caso a data de in�cio das f�rias seja, pelo menos, ap�s 10 dias a data da solicita��o. 
//	 * 
//	 * @param dataInicioFerias LocalDateTime - data de in�cio de f�rias solicitada pelo colaborador
//	 * @param dataFimFerias LocalDateTime - data do fim das f�rias solicitada pelo colaborador
//	 */
//	public static void registraFeriasParciais(LocalDateTime dataInicioFerias, LocalDateTime dataFimFerias){
//		if (verificarDataSolicitacao(dataInicioFerias)) {
//
//			registraDataInicioFerias(dataInicioFerias);
//			registraDataFimFerias(dataFimFerias);
//		} else {
//			System.out.println("A data da solicita��o � inferior a 10 dias deste chamado");
//		}
//	}
//
//	/**
//	 * Calcula data fim das f�rias totais
//	 * 
//	 * Calcula a data fim das f�rias totais com base na data in�cio das f�rias solicitada pelo colaborador.
//	 * O c�lculo � realizado considerando que a data fim ser� 30 dias ap�s a data in�cio.
//	 * 
//	 * @param dataInicioFerias LocalDateTime - data de in�cio de f�rias solicitada pelo colaborador
//	 * @return data fim das f�rias totais
//	 */
//	public static LocalDateTime calculaDataFimFeriasTotais(LocalDateTime dataInicioFerias) {
//		LocalDateTime dataFimFerias = dataInicioFerias.plusDays(30);
//		return dataFimFerias;
//	}
//	
//	/**
//	 * Registro da data in�cio das f�rias
//	 * 
//	 * A SER IMPLEMENTADO
//	 * 
//	 * @param dataInicioFerias LocalDateTime - data de in�cio de f�rias solicitada pelo colaborador
//	 * @return
//	 */
//	static LocalDateTime registraDataInicioFerias(LocalDateTime dataInicioFerias) {
//		// TODO implementa��o
//		return dataInicioFerias;
//	}
//
//	/**
//	 * Registro da data fim das f�rias
//	 * 
//	 * A SER IMPLEMENTADO
//	 * 
//	 * @param dataFimFerias LocalDateTime - data do fim das f�rias solicitada pelo colaborador
//	 * @return
//	 */
//	static LocalDateTime registraDataFimFerias(LocalDateTime dataFimFerias) {
//		// TODO implementa��o
//		return dataFimFerias;
//	}

	//Janaina <<<<<<<<<< start
	
	static int[] saldoDeFerias = { 20, 30, 15, 10 };
	static String[][] colaboradores = new String[2][3];
	static LocalDate inicio = LocalDate.of(2019, 01, 15);
	static LocalDate termino = LocalDate.of(2019, 01, 01);
	static String[] tiposDeFerias = { "De direito", "Vendidas" };
	static String[] tiposDePeriodo = { "parcial", "total" };

	static int[] feriasTiradas = { 10, 15, 20, 30 };
	/*
	 * static LocalDate[] datasInicioDeFerias = { LocalDate.of(2020, 01, 01),
	 * LocalDate.of(2020, 02, 01), LocalDate.of(2020, 03, 01), LocalDate.of(2020,
	 * 04, 01) }; static LocalDate[] datasTerminoDeFerias = { LocalDate.of(2020, 01,
	 * 010), LocalDate.of(2020, 02, 15), LocalDate.of(2020, 07, 01),
	 * LocalDate.of(2020, 8, 01) };
	 */

	public static void gerarColaboradores() {
		colaboradores[0][0] = "Pessoa 1"; //categoria 0
		colaboradores[0][1] = "Pessoa 2";
		colaboradores[0][2] = "Pessoa 3";

		colaboradores[1][0] = "Pessoa 5"; //categoria 1
		colaboradores[1][1] = "Pessoa 6";
		colaboradores[1][2] = "Pessoa 7";
	}

	// O sistema recebe o colaborador e verifica se ele possui saldo de f�rias
	// positivo.
	
	/**
	 * Verifica se possui saldo positivo.
	 * 
	 * Consulta o cadastro do colaborador e verifica se ele possui saldo de f�rias
	 * dispon�vel.
	 * 
	 * @param idColaborador ID do colaborador a ser consultado.
	 * @return
	 */
	public static boolean verificarSePossuiSaldoPositivo(int idColaborador, int saldoFerias) {
		boolean podeTirarFerias = saldoFerias > 0 ? true : false;

		return podeTirarFerias;
	}

	// Se n�o, informa que n�o existe saldo positivo de f�rias.
	/**
	 * Informa se existe saldo de f�rias.
	 * 
	 * Retorna uma mensagem do tipo String que informa se existe saldo para o
	 * usu�rio informado no par�metro.
	 * 
	 * @param idColaborador ID do colaborador a ser consultado.
	 * @return
	 */
	public static String informarSaldo(boolean existeSaldo, int idColaborador) {
		String mensagem;

		if (existeSaldo) {
			mensagem = "Saldo positivo: " + pegarSaldo(idColaborador);
		} else {
			mensagem = "N�o existe saldo de f�rias dispon�vel para o usu�rio informado.";
		}
		return mensagem;
	}

	/**
	 * Retorna saldo.
	 * 
	 * Consulta o saldo de f�rias do Colaborador e retorna a quantidade de dias do
	 * tipo int.
	 * 
	 * @param idColaborador ID do colaborador a ser consultado.
	 * @return
	 */
	public static int pegarSaldo(int idColaborador) {
		int saldo = saldoDeFerias[idColaborador];
		return saldo;

	}

	/*
	 * Se sim, o sistema retorna rela��o de per�odos de f�rias tiradas, contendo o
	 * tipo: f�rias vendidas (quantidade de dias e valor) f�rias de direito
	 * (quantidade de dias, e data de in�cio e fim)
	 */

	/**
	 * Retorna tipo de f�rias.
	 * 
	 * Retorna uma String informando o tipo de f�rias.
	 * 
	 * @param tipoDeFerias
	 * @return
	 */
	public static String retornarTipoDeFerias(int tipoDeFerias) {
		return tiposDeFerias[tipoDeFerias];
	}

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

	/**
	 * Retorna quantidade de dias
	 * 
	 * Retorna a quantidade de dias em formato long, a partir das datas de in�cio e
	 * t�rmino informadas.
	 * 
	 * @param inicio  Data de in�cio.
	 * @param termino Data de t�rmino.
	 * @return
	 */
	public static long retornarIntervaloEmDiasEntreAsDatas(LocalDate inicio, LocalDate termino) {
		long dias = ChronoUnit.DAYS.between(inicio, termino);
		return dias;
	}

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
	public static ArrayList<String> retornarColaboradoresDoSetor(int idSetor) {
		ArrayList<String> colaboradoresDoSetorInformado = new ArrayList<String>();

		for (String colaborador : colaboradores[idSetor]) {
			colaboradoresDoSetorInformado.add(colaborador);
		}

		return colaboradoresDoSetorInformado;
	}

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
	public static void alterarPeriodoDeFeriasParciais(int idPeriodo, LocalDate novaDataInicio,
			LocalDate novaDataTermino) {
		long novoPeriodo = retornarIntervaloEmDiasEntreAsDatas(novaDataInicio, novaDataTermino);
		feriasTiradas[idPeriodo] = (int) novoPeriodo;
	}

	/**
	 * Informa o novo per�odo de concess�o de f�rias parciais.
	 * 
	 * Retorna uma mensagem do tipo String contendo quantidade de dias do novo
	 * per�odo e datas de in�cio e fim.
	 * 
	 * @param idTipoDePeriodo
	 * @param dataInicio Nova data de in�cio do per�odo.
	 * @param dataTermino Nova data de t�rmino do per�odo.
	 * @return
	 */
	public static String informarNovoPeriodoDeConcessaoParcial(int idTipoDePeriodo, LocalDate dataInicio,
			LocalDate dataTermino) {
		int periodoEmDias = (int) retornarIntervaloEmDiasEntreAsDatas(dataInicio, dataTermino);
		String mensagem = "Tipo de per�odo: " + tiposDePeriodo[idTipoDePeriodo] + ". Quantidade de dias tirados: "
				+ periodoEmDias + ".";
		return mensagem;
	}

	/**
	 * Informa o novo per�odo de concess�o de f�rias totais.
	 * 
	 * Retorna uma mensagem do tipo String contendo quantidade de dias do novo
	 * per�odo e data de in�cio.
	 * 
	 * @param idTipoDePeriodo ID referente ao tipo do per�odo.
	 * @param idFeriasTiradas ID referente �s f�rias tiradas.
	 * @return
	 */
	public static String informarNovoPeriodoDeConcessaoTotal(int idTipoDePeriodo, int idFeriasTiradas) {
		int periodoEmDias = feriasTiradas[idFeriasTiradas];
		String mensagem = "Tipo de per�odo: " + tiposDePeriodo[idTipoDePeriodo] + ". Quantidade de dias tirados: "
				+ periodoEmDias + ".";
		return mensagem;
	}

	/**
	 * Valida o novo periodo de concess�o de f�rias.
	 * 
	 * Verifica se o per�odo � valido com base na quantidade de dias do per�odo
	 * atual e do per�odo novo.
	 * 
	 * @param periodoAtual Quantidade de dias do per�odo atual a ser alterado.
	 * @param dataInicio Data de in�cio do per�odo.
	 * @param dataTermino Data de t�rmino do per�odo.
	 * @return
	 */
	public static boolean novoPeriodoEhValido(int periodoAtual, LocalDate dataInicio, LocalDate dataTermino) {
		boolean periodoValido = true;

		long periodoNovo = ChronoUnit.DAYS.between(dataInicio, dataTermino);
		if (periodoAtual < periodoNovo || periodoNovo == 0) {
			periodoValido = false;
		}
		return periodoValido;
	}
	
	////Janaina <<<<<<<<<< end
	
	// BRUNO START
	
	//Varaveis com dados que deveriam vir do banco de dados
	static int[] listaDeColaboradores = { 0, 1, 4 };// lista com id de colaboradores
	static int[] saldoDeFerias = { 30, 25, 40, 10, 5 }; // substituir por valor recebido do Banco de dados
	static int recebeColaboradores = 1; // recebe colaboradores do Banco de dados
	
	/**
	 * Consulta saldo de f�rias Recebe um id de colaborador e utiliza ele como
	 * parametro para encontrar o saldo de f�rias que est� em no vetor saldoDeFerias
	 *
	 * @author Bruno Marques
	 * @param id int Recebe um valor para selecionar intem do vetor
	 * @return saldo de f�rias
	 */
	public static int consultarSaldo(int id) {
		int saldo = saldoDeFerias[id];
		System.out.println("Voc� possui " + saldo + " dias de f�rias");
		return saldo;
	}

	/**
	 * Verifica se poss�i colaboradores na equipe 
	 * Verifica se o us�ario poss�i colaboradores em sua equipe atrav� de valor recebido
	 * 
	 * @author Bruno Marques
	 * @param id int Recebe um valor (quantidade de funcionarios) para fazer a valida��o
	 * @return possuiColab true ou false
	 */
	0
	}
/**
 * Consulta f�rias de membros da equipe
 * Ap�s verificar se o us�ario poss�i colaboradores em sua equipe, 
 * o sistema retorna quais colaboradores s�o da equipe e o saldo de f�rias de cada um
 * 
 * @author Bruno Marques
 * @param listaDeColaboradores int[] recebe vetor com lista de colaboradores
 * @param saldoDeFerias int[] recebe vetor com saldo de f�rias por colaborador
 * @return uma lista com uma lista de colaoradres da equipe e outra lista de saldo de f�rias de cada um
 */
	public static ArrayList<Integer>  consultaSituacaoDeFeriasDaEquipe(int[] listaDeColaboradores,
			int[] saldoDeFerias) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		if (consultarColaboraoresDaEquipe(recebeColaboradores)) {
			System.out.println("Voc� possui " + listaDeColaboradores.length + " colaboradores em sua equipe.");
			for (int c = 0; c < listaDeColaboradores.length; c++) {
				int colab = listaDeColaboradores[c];
				lista.add(saldoDeFerias[colab]);
				System.out.println("O colaborador de id " + listaDeColaboradores[c] + " possui " +
				saldoDeFerias[c] + " dias de f�rias." );
			}
		} else {
			System.out.println("O usu�rio n�o possui colaboradores em sua equipe");
		}
		return lista;
	}
	
	//BRUNO END
//DANI 
	public String[][] chamados = new String[4][3];
	
	/**
	 * Pegar lista de chamados pendentes.
	 * 
	 * Retorna uma lista de String contendo os chamados que possuem status de
	 * pendente.
	 * 
	 * @param listaChamados
	 * @return
	 */
	public String[] getChamados(int tipoChamado) {
		return chamados[tipoChamado];
	}

	/**
	 * Verificar se existem chamados pendentes.
	 * 
	 * Verifica se existem Strings no array listaChamados.
	 * 
	 * @param listaChamados Lista de chamados do tipo String.
	 * @return
	 */
	public static boolean verificaSeExistemChamados(String[] listaChamados) {
		int quantidadeChamados = 0;
		boolean existemChamados = false;
		for (String chamado : listaChamados) {
			quantidadeChamados++;
		}

		if (quantidadeChamados > 0) {
			existemChamados = true;
		}

		return existemChamados;
	}

	/**
	 * Informa que n�o existem chamados.
	 * 
	 * Retorna uma String contendo a mensagem de que n�o existe chamados.
	 * 
	 * @return
	 */
	public static String informaN�oExistemChamados() {
		return "N�o existem chamados com o status solicitado.";
	}

	public static String informaTipoChamado(int tipoChamado) {
		String nomeChamado = "Chamado";
		switch (tipoChamado) {
		case 0:
			nomeChamado = "Chamado pendente";
			break;
		case 1:
			nomeChamado = "Chamado deferido";
			break;
		case 2:
			nomeChamado = "Chamado finalizado";
			break;
		case 3:
			nomeChamado = "Chamado em atraso";
			break;
		}
		return nomeChamado;
	}
	
	public void criarChamados() {
		chamados[0][0] = "chamado 01";
		chamados[0][1] = "chamado 02";
		chamados[0][2] = "chamado 03";

		chamados[1][0] = "chamado 1";
		chamados[1][1] = "chamado 2";
		chamados[1][2] = "chamado 3";

		chamados[2][0] = "chamado 1";
		chamados[2][1] = "chamado 2";
		chamados[2][2] = "chamado 3";

		chamados[3][0] = "chamado 1";
		chamados[3][1] = "chamado 2";
		chamados[3][2] = "chamado 3";
	}

	public  void consultaChamadosPendentes() {
		// usu�rio clicou em consultar chamados pendentes
		int tipoChamado = 0;
		String[] chamados = getChamados(tipoChamado);
		if (verificaSeExistemChamados(chamados)) {
			System.out.println(informaTipoChamado(tipoChamado));
			for (String chamado : chamados) {
				System.out.println(chamado);
			}
		} else
			informaN�oExistemChamados();
	}
}
//DANI END
