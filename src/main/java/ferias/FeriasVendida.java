package ferias;

import java.time.LocalDate;

public class FeriasVendida extends Ferias {

	/**
	 * Instancia um objeto FeriasVendida, que não tem data de inicio e data de fim;
	 * 
	 * @author SPRINT 2
	 * @param diasDisponiveis - dias em creditos para férias
	 */
	public FeriasVendida(int diasDisponiveis) {
		//this.dataInicio = null;
		//this.dataFim = null;
		
		this.setTipoFerias(TiposFerias.VENDIDA);
		this.setDiasTotaisRequisitados(0);
		this.setDiasVendidos(diasDisponiveis);
	}
	
	public void setDataInicio(LocalDate data) {
		
	}
	public void setDataFim(LocalDate data) {
		
	}
}
