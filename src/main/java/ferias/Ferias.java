package ferias;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//TODO: Documentar
public class Ferias {
	LocalDate dataInicio;
	LocalDate datafim;
	int diasTotais;
	int diasVendidos;
	String tipoFerias;

	public Ferias(LocalDate dataInicio, LocalDate dataFim) {
		this.dataInicio = dataInicio;
		this.datafim = dataFim;
		this.diasTotais = calcularPeriodoFerias(dataInicio, dataFim);
		calcularDiasVendidos(); //this.diasVendidos
		this.tipoFerias = classificarFerias();
	}

	/**
	 * Calcula o intervalo em dias entre os períodos solicitados.
	 * 
	 * @param dataInicioFerias
	 * @param dataFimFerias
	 * @return
	 */
	public static int calcularPeriodoFerias(LocalDate dataInicioFerias, LocalDate dataFimFerias) {
		int periodo = (int) dataInicioFerias.until(dataFimFerias, ChronoUnit.DAYS);
		return periodo;
	}

	/**
	 * Classifica o tipo de férias com base nos dias totais das férias requisitadas.
	 * 
	 * @return String classificação
	 */
	
	//TODO: Incluir ferias fracionadas, adicionar variaveis de referencia (igual fizemos no SaldoFerias)
	public String classificarFerias() {
		if (this.diasTotais < 30) {
			return "Parciais";
		} else if (this.diasTotais == 30) {
			return "Totais";
		} else {
			return "Inválido";
		}
	}

	/*
	 * 
	 */
	// TODO: Documentar, adicionar variaveis de referencia
	public void calcularDiasVendidos() {
		if (this.diasTotais >= 20 && this.diasTotais < 30) {
			this.diasVendidos = 30 - this.diasTotais;

		} else {
			System.out.println("O colaborador não possui dias para venda!");

		}

	}

}
