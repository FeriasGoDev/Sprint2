package ferias;

import java.time.LocalDate;
import java.util.ArrayList;
//crtl+shift+O = AutoImport


/**
 * A classe que representa o saldo e hist�rico de f�rias.
 * 
 * Possui m�todos para calcular saldo, bem como a verifica��o de saldo.
 * 
 * Creditar dias de f�rias e controle de faltas atrav�s de ponto.
 * 
 * A classe possui constantes para melhor entendimento e manuten��o do c�digo.
 * 
 * @author SENIOR
 *
 */
public class SaldoFerias {
	//SCREAMING_SNAKE_CASE
	public short INTERVALO_ENTRE_FERIAS_EM_ANOS = 1;
	public short DIAS_DISPONIVEIS_PARA_FERIAS = 30;
	
	// Intervalos na posi��o [0] a [1] da array, inclusivos;
	public short[] INTERVALO_FALTAS_1 = {6, 14};
	public short[] INTERVALO_FALTAS_2 = {15, 23};
	public short[] INTERVALO_FALTAS_3 = {24, 32};
	public short[] INTERVALO_FALTAS_4 = {33}; // at� infinitos
	
	// Dias a serem creditados em rela��o aos intervalos de faltas;
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
	 * Func�o respons�vel por definir a data em que os dias dispon�veis para f�rias
	 * s�o creditados para os funcion�rios Quando a estrutura � iniciada, �
	 * utilizada a informa��o de admiss�o do funcion�rio para calcular o dia em que
	 * o mesmo recebe suas primeiras f�rias Para as pr�ximas f�rias, � utilizada a
	 * data do ultimo cr�dito de dias mais 365 anos;
	 * 
	 * @return Data dos pr�ximos dias de f�rias dispon�veis
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
	 * Fun��o respons�vel por creditar os dias dispon�veis para f�rias. Essa fun��o
	 * � chamada na data definida pela vari�vel "proximasFerias"
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
