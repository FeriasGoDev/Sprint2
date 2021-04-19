package ferias;

public class FeriasVendida extends Ferias {

	/**
	 * Instancia um objeto FeriasVendida, que não tem data de inicio e data de fim;
	 */
	public FeriasVendida() {
		//this.dataInicio = null;
		//this.dataFim = null;
		
		this.setTipoFerias(TiposFerias.VENDIDA);
		this.setDiasTotaisRequisitados(0);
		this.setDiasVendidos(getDiasDisponiveis());
	}
}
