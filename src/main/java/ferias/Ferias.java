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
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private int diasTotaisRequisitados;
	private int diasVendidos;
	private TiposFerias tipoFerias;

	public short CREDITOS_MINIMOS_FERIAS_FRACIONADAS = 14;

	public Ferias() {
		this.tipoFerias = TiposFerias.INVALIDA;
	}
	
	// diasDisponiveis vem do Saldo
	public Ferias(LocalDate dataInicio, LocalDate dataFim, int diasDisponiveis) {
		setDataInicio(dataInicio);
		this.dataFim = dataFim;
		
		this.diasTotaisRequisitados = calcularPeriodoFerias(dataInicio, dataFim);
		
		this.tipoFerias = classificarFerias(diasDisponiveis);
		this.diasVendidos =  calcularDiasVendidos(diasDisponiveis);
	}
	/*TODO: Quando essas férias são aceitas, devemos atualizar o Saldo.diasDisponiveisParaFerias
	* Essa atualização vai ocorrer na classe que gerencia as solicitações;
	*/
	
	// Setters - Para fazer automaticamente, alt+shift+S
	public void setDataInicio(LocalDate data) {
		this.dataInicio = data;
	}
	public void setDataFim(LocalDate data) {
		this.dataFim = data;
	}
	public void setDiasTotaisRequisitados(int valor) {
		this.diasTotaisRequisitados = valor;
	}
	
	public void setDiasVendidos(int valor) {
		this.diasVendidos = valor;
	}
	
	public void setTipoFerias(TiposFerias tipo) {
		this.tipoFerias = tipo;
	}
	
	// Getters
	public LocalDate getDataInicio() {return this.dataInicio;}
	
	public LocalDate getDataFim() {return this.dataFim;}
	
	public int getDiasTotaisRequisitados() {return this.diasTotaisRequisitados;}
	
	public int getDiasVendidos() {return this.diasVendidos;}
	
	public TiposFerias getTipo() {return this.tipoFerias;}
	
	/**
	 * Calcula o intervalo em dias entre os períodos solicitados.
	 * 
	 * @param dataInicioFerias
	 * @param dataFimFerias
	 * @return intervalo em dias entre as datas, -1 se inválido;
	 */
	public static int calcularPeriodoFerias(LocalDate dataInicioFerias, LocalDate dataFimFerias) {
		// Checando a classe FeriasVendida, que não tem dataInicio e dataFim
		if(dataInicioFerias == null && dataFimFerias == null) {return 0;}
		// Checando a classe principal;
		if (periodoFeriasValido(dataInicioFerias, dataFimFerias)) {
			return (int) dataInicioFerias.until(dataFimFerias, ChronoUnit.DAYS);
		}
		else return -1;
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
		if (diasDisponiveisParaFerias==0) {
			return TiposFerias.INVALIDA;
		}
		
		// Verificando a quantidade de dias de férias que foram requisitadas para classificaçãp;
		if ( this.getDiasTotaisRequisitados() < diasDisponiveisParaFerias ) {
			return (
				diasDisponiveisParaFerias - this.getDiasTotaisRequisitados() <= CREDITOS_MINIMOS_FERIAS_FRACIONADAS
				? TiposFerias.PARCIAL : TiposFerias.FRACIONADA
			);
		}
		else if (this.getDiasTotaisRequisitados() == diasDisponiveisParaFerias) {
			return TiposFerias.TOTAL;
		}	
		else if (this.getDiasTotaisRequisitados() == 0) {
			return TiposFerias.VENDIDA;
		}
		else {
			return TiposFerias.INVALIDA;
		}
	}

	/**
	 * Calcula os dias a serem vendidos com base nos dias de férias disponíveis ao funcionário e no
	 * tipo de férias; Apenas os tipos PARCIAL e VENDIDA vão ter dias a serem vendidos.
	 * 
	 * @param diasDisponiveisParaFerias - vem da classe SaldoFerias
	 * @return int dias a serem vendidos
	 */
	public short calcularDiasVendidos(int diasDisponiveisParaFerias) {
		if (this.getTipo() == TiposFerias.PARCIAL || this.getTipo() == TiposFerias.VENDIDA) {
			return (short) (diasDisponiveisParaFerias - this.getDiasTotaisRequisitados());
		} else {
			return 0;
		}
	}
	
	/** Verifica se o objeto de férias é valido, se falhar as checagens o tipo é alterado para INVALIDO.
	 * 
	 * uso : 
	 * Ferias X = new Ferias(inicio, fim);
	 * boolean valido = X.isValid();
	 * 
	 * @return true/false
	 */
	public boolean checarValidade() {
		// Checagem específica para ferias Vendida
		if(this.getTipo() == TiposFerias.VENDIDA)
		{
			if (this.getDiasVendidos()>0 && this.getDiasTotaisRequisitados()==0) return true;
		}
		// Checagem dos outros tipos
		else {
			if(periodoFeriasValido(dataInicio, dataFim)) {
				switch(this.getTipo()) {
				case TOTAL:
					if(this.getDiasVendidos()==0 && this.getDiasTotaisRequisitados()>0) return true;
					break;
				case PARCIAL:
					if (this.getDiasVendidos()>0 && this.getDiasTotaisRequisitados()>0) return true;
					break;
				case FRACIONADA:
					if (this.getDiasVendidos()==0 && this.getDiasTotaisRequisitados()>0) return true;
					break;
				default:
					break;
				}
			} 
		}
		// Checagens falharam, retorna falso e invalida as férias;
		setTipoFerias(TiposFerias.INVALIDA);
		return false;	 
	 }
	
	/** Verifica se a data de inicio de férias vem antes da data de fim desejado.
	 * 
	 * @param dataInicio
	 * @param dataFim
	 * @return periodo valido/invalido
	 */
	public static boolean periodoFeriasValido(LocalDate dataInicio, LocalDate dataFim) {
		boolean check = dataInicio.isBefore(dataFim)? true : false;
		return check;
	}

}
