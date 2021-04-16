package ferias;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe que representa a estrutura de dados de uma "unidade" de F�rias.
 * Para instanciar uma nova F�rias, � necess�rio informar as datas de in�cio e fim da mesma.
 * O construtor calcula o Per�odo em dias entre as datas, calcula dias a serem vendidos se necess�rio
 * e classifica as f�rias em um dos tipos dispon�veis no sistema.
 * 
 * @author Sprint2
 *
 */
public class Ferias {
	LocalDate dataInicio;
	LocalDate datafim;
	int diasTotaisRequisitados;
	int diasVendidos;
	TiposFerias tipoFerias;
	
	public short DIAS_FERIAS_TOTAIS = 30;
	public short DIAS_MINIMOS_FERIAS_FRACIONADAS = 14;

	public Ferias(LocalDate dataInicio, LocalDate dataFim) {
		this.dataInicio = dataInicio;
		this.datafim = dataFim;
		this.diasTotaisRequisitados = calcularPeriodoFerias(dataInicio, dataFim);
		
		int get_diasDisponiveis = 30; //Vem do Saldos.diasDisponiveisParaFerias
		
		this.tipoFerias = classificarFerias(get_diasDisponiveis);
		this.diasVendidos =  calcularDiasVendidos(get_diasDisponiveis);
	}

	/**
	 * Calcula o intervalo em dias entre os per�odos solicitados.
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
	 * Classifica o tipo de f�rias com base nos dias de f�rias dispon�veis ao funcion�rio.
	 * � realizada uma compara��o entre os diasTotaisRequisitados para f�rias e os dias em cr�dito.
	 * Os tipos de ferias estao listados no ENUM TiposFerias
	 * 
	 * @param diasDisponiveisParaFerias - vem da classe SaldoFerias
	 * @return TiposFerias classifica��o
	 */
	public TiposFerias classificarFerias(int diasDisponiveisParaFerias) {
		// Para avaliar o tipo de f�rias, � necess�rio mais do que 1 dia dispon�vel para f�rias
		if (diasDisponiveisParaFerias==0) return TiposFerias.INVALIDA;
		
		// Verificando a quantidade de dias de f�rias que foram requisitadas para classifica��p;
		if ( this.diasTotaisRequisitados < diasDisponiveisParaFerias ) {
			return (
				diasDisponiveisParaFerias-this.diasTotaisRequisitados < DIAS_MINIMOS_FERIAS_FRACIONADAS
				? TiposFerias.PARCIAL : TiposFerias.FRACIONADA
			);
		}
		else if (this.diasTotaisRequisitados == diasDisponiveisParaFerias) {
			return TiposFerias.TOTAL;
		}	
		else if (this.diasTotaisRequisitados == 0) {
			return TiposFerias.VENDIDA;
		}
		else {
			return TiposFerias.INVALIDA;
		}
	}

	/*
	 * Calcula os dias a serem vendidos com base nos dias de f�rias dispon�veis ao funcion�rio e no
	 * tipo de f�rias;
	 * 
	 * @param diasDisponiveisParaFerias - vem da classe SaldoFerias
	 * @return int dias a serem vendidos
	 */
	public short calcularDiasVendidos(int diasDisponiveisParaFerias) {
		if (this.tipoFerias == TiposFerias.PARCIAL || this.tipoFerias == TiposFerias.VENDIDA) {
			return (short) (diasDisponiveisParaFerias - this.diasTotaisRequisitados);
		} else {
			return 0;
		}
		/*TODO: Quando essas f�rias s�o aceitas, devemos atualizar o Saldo.diasDisponiveisParaFerias
		* Essa atualiza��o vai ocorrer na classe que gerencia as solicita��es;
		*/

	}

}
