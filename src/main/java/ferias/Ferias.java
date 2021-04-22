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
	private String identificadorUsuario; // FK Foreign Key do usu�rio - Decidir quais classes tem
	
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private int diasTotaisRequisitados;
	private int diasVendidos;
	private TiposFerias tipoFerias;

	protected final short CREDITOS_MINIMOS_FERIAS_FRACIONADAS = 14;

	public Ferias() {
		this.tipoFerias = TiposFerias.INVALIDA;
	}
	
	// diasDisponiveis vem do Saldo
	public Ferias(LocalDate dataInicio, LocalDate dataFim, int diasDisponiveis) {
		setDataInicio(dataInicio);
		setDataFim(dataFim);
		
		setDiasTotaisRequisitados(calcularPeriodoFerias(dataInicio, dataFim));
		
		setTipoFerias(classificarFerias(diasDisponiveis));
		setDiasVendidos(calcularDiasVendidos(diasDisponiveis));
	}
	/*TODO: Quando essas f�rias s�o aceitas, devemos atualizar o Saldo.diasDisponiveisParaFerias
	* Essa atualiza��o vai ocorrer na classe que gerencia as solicita��es;
	*/
	
	public String getIdentificadorUsuario() {
		return identificadorUsuario;
	}

	public void setIdentificadorUsuario(String identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
	}
	
	
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
	 * Calcula o intervalo em dias entre os per�odos solicitados.
	 * 
	 * @param dataInicioFerias
	 * @param dataFimFerias
	 * @return intervalo em dias entre as datas, -1 se inv�lido;
	 */
	public int calcularPeriodoFerias(LocalDate dataInicioFerias, LocalDate dataFimFerias) {
		// Checando a classe FeriasVendida, que n�o tem dataInicio e dataFim
		if(dataInicioFerias == null || dataFimFerias == null) {return 0;}
		// Checando a classe principal;
		if (periodoFeriasValido(dataInicioFerias, dataFimFerias)) {
			return (int) dataInicioFerias.until(dataFimFerias, ChronoUnit.DAYS);
		}
		else {
			setTipoFerias(TiposFerias.INVALIDA);
			return -1; // -1 para dexar claro que o periodo � inv�lido;
		}
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
		if (diasDisponiveisParaFerias==0) {
			return TiposFerias.INVALIDA;
		}
		
		// Verificando a quantidade de dias de f�rias que foram requisitadas para classifica��o;
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
	 * Calcula os dias a serem vendidos com base nos dias de f�rias dispon�veis ao funcion�rio e no
	 * tipo de f�rias; Apenas os tipos PARCIAL e VENDIDA v�o ter dias a serem vendidos.
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
	
	/** Verifica se o objeto de f�rias � valido, se falhar as checagens o tipo � alterado para INVALIDO.
	 * 
	 * uso : 
	 * Ferias X = new Ferias(inicio, fim);
	 * boolean valido = X.checarValidade();
	 * 
	 * @return true/false
	 */
	public boolean checarValidade() {
		// Checagem espec�fica para ferias Vendida
		if(this.getTipo() == TiposFerias.VENDIDA)
		{
			if (this.getDiasVendidos()>0 && this.getDiasTotaisRequisitados()==0) return true;
		}
		// Checagem dos outros tipos
		else {
			if(periodoFeriasValido(dataInicio, dataFim)) {
				switch(this.getTipo()) {
				case TOTAL:
				case FRACIONADA:
					if(this.getDiasVendidos()==0 && this.getDiasTotaisRequisitados()>0) return true;
					break;
				case PARCIAL:
					if (this.getDiasVendidos()>0 && this.getDiasTotaisRequisitados()>0) return true;
					break;				
				default:
					break;
				}
			} 
		}
		// Checagens falharam, retorna falso e invalida as f�rias;
		setTipoFerias(TiposFerias.INVALIDA);
		return false;	 
	 }
	
	/** Verifica se a data de inicio de f�rias vem antes da data de fim desejado.
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
