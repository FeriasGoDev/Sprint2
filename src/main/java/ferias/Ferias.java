package ferias;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe que representa a estrutura de dados de uma "unidade" de Férias.
 * Para instanciar uma nova Férias, é necessário informar as datas de início e fim da mesma.
 * O construtor calcula o Período em dias entre as datas, calcula dias a serem vendidos se necessário
 * e classifica as férias em um dos tipos disponíveis no sistema.
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
	 * Classifica o tipo de férias com base nos dias de férias disponíveis ao funcionário.
	 * É realizada uma comparação entre os diasTotaisRequisitados para férias e os dias em crédito.
	 * Os tipos de ferias estao listados no ENUM TiposFerias
	 * 
	 * @param diasDisponiveisParaFerias - vem da classe SaldoFerias
	 * @return TiposFerias classificação
	 */
	public TiposFerias classificarFerias(int diasDisponiveisParaFerias) {
		// Para avaliar o tipo de férias, é necessário mais do que 1 dia disponível para férias
		if (diasDisponiveisParaFerias==0) return TiposFerias.INVALIDA;
		
		// Verificando a quantidade de dias de férias que foram requisitadas para classificaçãp;
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
	 * Calcula os dias a serem vendidos com base nos dias de férias disponíveis ao funcionário e no
	 * tipo de férias;
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
		/*TODO: Quando essas férias são aceitas, devemos atualizar o Saldo.diasDisponiveisParaFerias
		* Essa atualização vai ocorrer na classe que gerencia as solicitações;
		*/

	}

}
