package ferias;

import java.time.LocalDate;

public class FeriasVendida extends Ferias {

	/**
	 * Instancia um objeto FeriasVendida, que não tem data de inicio e data de fim;
	 * 
	 * @author SPRINT 2
	 * @param diasAVender - dias em creditos para férias
	 */
	public FeriasVendida(int diasAVender) {
		//this.dataInicio = null;
		//this.dataFim = null;
		
		this.setTipoFerias(TiposFerias.VENDIDA);
		this.setDiasTotaisRequisitados(0);
		this.setDiasVendidos(diasAVender);
	}
	
	// Overload para impedir que os métodos que usam datas de inicio/fim de férias criem excessoes
	public void setDataInicio(LocalDate data) {}
	public void setDataFim(LocalDate data) {}
}
