package ferias;

//TODO: Documentar
public class FeriasRequerimento {
	String identificadorUsuario; //FK Foreign Key do usuário
	Ferias feriasRequisitada; // Instância de Férias
	String estadoRequisicao; // ENUM
	
	public FeriasRequerimento(String identificadorUsuario, Ferias feriasRequisitada) {
		this.identificadorUsuario = identificadorUsuario;
		this.feriasRequisitada = feriasRequisitada;
		this.estadoRequisicao = "Em Analise";
	}
	
	/* Atualiza o estado da requisição
	 * 
	 * Verifica se o novoEstado está registrado nas ENUMS do sistema
	 * Atualiza o estado do requerimento
	 * 
	 * @return true/false sucesso da operação.
	 */
	public boolean atualizarEstadoRequisicao(String novoEstado) {
		// Verificar se o estado é valido (dentro do ENUM);
		// se for, retornar falso
		
		// se nao for valido, verdadeiro
		this.estadoRequisicao = novoEstado;
		return true; 
	}
}


