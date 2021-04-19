package ferias;

import java.time.LocalDate;

public class FeriasVendida extends Ferias {

	/**
	 * Instancia um objeto FeriasVendida, que n�o tem data de inicio e data de fim;
	 * 
	 * @author SPRINT 2
	 * @param diasDisponiveis - dias em creditos para f�rias
	 */
	public FeriasVendida(int diasDisponiveis) {
		//this.dataInicio = null;
		//this.dataFim = null;
		
		this.setTipoFerias(TiposFerias.VENDIDA);
		this.setDiasTotaisRequisitados(0);
		this.setDiasVendidos(diasDisponiveis);
	}
	
	// Overload para impedir que os m�todos que usam datas de inicio/fim de f�rias criem excessoes
	public void setDataInicio(LocalDate data) {}
	public void setDataFim(LocalDate data) {}
}
