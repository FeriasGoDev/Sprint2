package ferias;

//TODO: Documentar
public class FeriasRequerimento {
	String identificadorUsuario; //FK Foreign Key do usu�rio
	Ferias feriasRequisitada; // Inst�ncia de F�rias
	String estadoRequisicao; // ENUM
	
	public FeriasRequerimento(String identificadorUsuario, Ferias feriasRequisitada) {
		this.identificadorUsuario = identificadorUsuario;
		this.feriasRequisitada = feriasRequisitada;
		this.estadoRequisicao = "Em Analise";
	}
	
	/* Atualiza o estado da requisi��o
	 * 
	 * Verifica se o novoEstado est� registrado nas ENUMS do sistema
	 * Atualiza o estado do requerimento
	 * 
	 * @return true/false sucesso da opera��o.
	 */
	public boolean atualizarEstadoRequisicao(String novoEstado) {
		// Verificar se o estado � valido (dentro do ENUM);
		// se for, retornar falso
		
		// se nao for valido, verdadeiro
		this.estadoRequisicao = novoEstado;
		return true; 
	}
}


