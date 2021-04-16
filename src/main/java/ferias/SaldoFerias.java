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
	
	// Intervalos na posição [0] a [1] da array, inclusivos;
	public short[] INTERVALO_FALTAS_1 = {6, 14};
	public short[] INTERVALO_FALTAS_2 = {15, 23};
	public short[] INTERVALO_FALTAS_3 = {24, 32};
	public short[] INTERVALO_FALTAS_4 = {33}; // até infinitos
	
	// Dias a serem creditados em relação aos intervalos de faltas;
	public short CREDITOS_FALTAS_1 = 24;
	public short CREDITOS_FALTAS_2 = 18;
	public short CREDITOS_FALTAS_3 = 12;
	public short CREDITOS_FALTAS_4 = 0;
	
	LocalDate proximasFerias;
	int diasDisponiveisDeFerias = 0; // Vai ser preenchido na data "proximasFerias"
	ArrayList<Ferias> historicoFerias = new ArrayList<Ferias>();
	ArrayList<FeriasRequerimento> historicoRequimentos = new ArrayList<FeriasRequerimento>();
	// Adicionar metodos para adicionar e remover itens nas ArrayLists (getters e setters)

	public SaldoFerias() {
		proximasFerias = calcularProximasFerias();
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
		if (this.proximasFerias == null) {
			// puxar do sistema de cadastro de funcionarios
			LocalDate admissao = LocalDate.now();
			return (admissao.plusYears(INTERVALO_ENTRE_FERIAS_EM_ANOS));
		} else {
			return (proximasFerias.plusYears(INTERVALO_ENTRE_FERIAS_EM_ANOS));
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

		if (faltas >= INTERVALO_FALTAS_1[0] && faltas <= INTERVALO_FALTAS_1[1])
			creditos = CREDITOS_FALTAS_1;
		else if (faltas >= INTERVALO_FALTAS_2[0]  && faltas <= INTERVALO_FALTAS_2[1] )
			creditos = CREDITOS_FALTAS_2;
		else if (faltas >= INTERVALO_FALTAS_3[0]  && faltas <= INTERVALO_FALTAS_3[1] )
			creditos = CREDITOS_FALTAS_3;
		else if (faltas >= INTERVALO_FALTAS_4[0] )
			creditos = CREDITOS_FALTAS_4;
		return creditos;
	}

	public short receberFaltasDoControleDePontos() {
		return 10;
	} // vem de outra equipe - Controle de Pontos
}
