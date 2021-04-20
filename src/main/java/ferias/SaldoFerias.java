package ferias;

import java.time.LocalDate;
import java.util.ArrayList;
//crtl+shift+O = AutoImport


/**
 * A classe que representa o saldo e histórico de férias.
 * 
 * Possui métodos para calcular saldo, bem como a verificação de saldo.
 * 
 * Creditar dias de férias e controle de faltas através de ponto.
 * 
 * A classe possui constantes para melhor entendimento e manutenção do código.
 * 
 * @author SENIOR
 *
 */
public class SaldoFerias {
	//SCREAMING_SNAKE_CASE
	public short INTERVALO_ENTRE_FERIAS_EM_ANOS = 1;
	public short DIAS_DISPONIVEIS_PARA_FERIAS = 30;

	// Intervalos na posi��o [0] a [1] da array, inclusivos;
	public short INTERVALO_FALTAS_1 = 6;
	public short INTERVALO_FALTAS_2 = 15;
	public short INTERVALO_FALTAS_3 = 24;
	public short INTERVALO_FALTAS_4 = 33; // at� infinitos

	
	public short CREDITOS_FALTAS_1 = 24;
	public short CREDITOS_FALTAS_2 = 18;
	public short CREDITOS_FALTAS_3 = 12;
	public short CREDITOS_FALTAS_4 = 0;

	private LocalDate proximasFerias;
	private int diasDisponiveisDeFerias; // Vai ser preenchido na data "proximasFerias"
	private ArrayList<Ferias> historicoFerias;
	private ArrayList<FeriasRequerimento> historicoRequimentos;
	// Adicionar metodos para adicionar e remover itens nas ArrayLists (getters e setters)



	public SaldoFerias() {
		proximasFerias = calcularProximasFerias();
		diasDisponiveisDeFerias = 0;
		historicoFerias = new ArrayList<Ferias>();
		historicoRequimentos = new ArrayList<FeriasRequerimento>();
	}



	public LocalDate getProximasFerias() {
		return proximasFerias;
	}



	public void setProximasFerias(LocalDate proximasFerias) {
		this.proximasFerias = proximasFerias;
	}



	public int getDiasDisponiveisDeFerias() {
		return diasDisponiveisDeFerias;
	}



	public void setDiasDisponiveisDeFerias(int diasDisponiveisDeFerias) {
		this.diasDisponiveisDeFerias = diasDisponiveisDeFerias;
	}



	public ArrayList<Ferias> getHistoricoFerias() {
		return historicoFerias;
	}

	public ArrayList<FeriasRequerimento>getHistoricoRequimentos() {
		return historicoRequimentos;
	}
	
	// Nao devemos substituir a lista, ela j� esta instanciada no construtor.

	//public void setHistoricoFerias(ArrayList<Ferias> historicoFerias) {
	//	this.historicoFerias = historicoFerias;
	//}

	//public void setHistoricoRequimentos(
	//		ArrayList<FeriasRequerimento> historicoRequimentos) {
	//	this.historicoRequimentos = historicoRequimentos;
	//}

	
	// Metodos para modificar as ArrayLists

	public void adicionarHistoricoFerias(Ferias ferias) {
		this.historicoFerias.add(ferias);
	}
	public void removerHistoricoFerias(Ferias ferias) {
		this.historicoFerias.remove(ferias);
	}

	public void adicionarHistoricoRequerimentos(FeriasRequerimento req) {
		this.historicoRequimentos.add(req);
	}
	public void removerHistoricoRequerimentos(FeriasRequerimento req) {
		this.historicoRequimentos.remove(req);
	}


	/*
	 * Funcão responsável por definir a data em que os dias disponíveis para férias
	 * são creditados para os funcionários Quando a estrutura é iniciada, é
	 * utilizada a informação de admissão do funcionário para calcular o dia em que
	 * o mesmo recebe suas primeiras férias Para as próximas férias, é utilizada a
	 * data do ultimo crédito de dias mais 365 anos;
	 * 
	 * @return Data dos próximos dias de férias disponíveis
	 */
	public LocalDate calcularProximasFerias() {
		if (this.getProximasFerias() == null) {
			// puxar do sistema de cadastro de funcionarios
			LocalDate admissao = LocalDate.now();
			return (admissao.plusYears(INTERVALO_ENTRE_FERIAS_EM_ANOS));
		} else {
			return (this.getProximasFerias().plusYears(INTERVALO_ENTRE_FERIAS_EM_ANOS));
		}
	}

	
	/*
	 * Função responsável por creditar os dias disponíveis para férias. Essa função
	 * é chamada na data definida pela variável "proximasFerias"
	 * 
	 */
	
	public short creditarDiasDeFerias() {
		short creditos = DIAS_DISPONIVEIS_PARA_FERIAS;
		short faltas = receberFaltasDoControleDePontos();

		if (faltas >= INTERVALO_FALTAS_1)
			creditos = CREDITOS_FALTAS_1;
		else if (faltas >= INTERVALO_FALTAS_2 )
			creditos = CREDITOS_FALTAS_2;
		else if (faltas >= INTERVALO_FALTAS_3 )
			creditos = CREDITOS_FALTAS_3;
		else if (faltas >= INTERVALO_FALTAS_4)
			creditos = CREDITOS_FALTAS_4;
		return creditos;
	}

	public short receberFaltasDoControleDePontos() {
		return 10;
	} // vem de outra equipe - Controle de Pontos


	/**
	 * Verifica se possui saldo positivo.
	 * 
	 * Consulta o valor de Saldo de Ferias e verifica se ele � positivo.
	 * 
	 * @param saldoFerias, da estrutura de dados.
	 * @return
	 */
	public static boolean verificarSePossuiSaldoDeFerias(int saldoFerias) {
		boolean podeTirarFerias = saldoFerias > 0 ? true : false;

		return podeTirarFerias;
	}
}
