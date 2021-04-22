package ferias;

import java.time.LocalDate;

public class FeriasVendida extends Ferias {
	
	protected final short DIAS_MAXIMOS_A_VENDER = 30;

	/**
	 * Instancia um objeto FeriasVendida, que n�o tem data de inicio e data de fim;
	 * 
	 * @author SPRINT 2
	 * @param diasAVender - dias em creditos para f�rias
	 */
	public FeriasVendida(int diasAVender) {
		//this.dataInicio = null;
		//this.dataFim = null;
		
		this.setTipoFerias(TiposFerias.VENDIDA);
		this.setDiasTotaisRequisitados(0);
		
		int diasVendidos = (diasAVender > DIAS_MAXIMOS_A_VENDER)?  DIAS_MAXIMOS_A_VENDER : diasAVender;
		this.setDiasVendidos(diasVendidos);
	}
	
	// Overload para impedir que os m�todos que usam datas de inicio/fim de f�rias criem excessoes
	public void setDataInicio(LocalDate data) {}
	public void setDataFim(LocalDate data) {}
}
