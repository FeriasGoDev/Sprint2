package ferias;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//TODO: Documentar
public class FeriasRequerimento {
	String identificadorUsuario; // FK Foreign Key do usuário
	Ferias feriasRequisitada; // Instância de Férias
	String estadoRequisicao; // ENUM

	static short PRAZO_MINIMO_SOLICITACAO_FERIAS = 10;

	public FeriasRequerimento(String identificadorUsuario, Ferias feriasRequisitada) {
		this.identificadorUsuario = identificadorUsuario;
		this.feriasRequisitada = feriasRequisitada;
		this.estadoRequisicao = "Em Analise";
	}

	/*
	 * Atualiza o estado da requisição
	 * 
	 * Verifica se o novoEstado está registrado nas ENUMS do sistema Atualiza o
	 * estado do requerimento
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

	/**
	 * Retorna quantidade de dias
	 * 
	 * Retorna a quantidade de dias em formato short, a partir das datas de início e término informadas.
	 * 
	 * @param inicio  Data de início.
	 * @param termino Data de término.
	 * 
	 */
	public static short retornarIntervaloEmDiasEntreAsDatas(LocalDate inicio, LocalDate termino) {
		short dias = (short) ChronoUnit.DAYS.between(inicio, termino);
		return dias;
	}

	/**
	 * Retorna um boolean obtido atraves da comparacao entre a data de inicio de ferias e a variavel PRAZO_MINIMO_SOLICITACAO_FERIAS.
	 * Para o boolean retornar true, o (intervalo) deve ser maior que a variavel PRAZO_MINIMO_SOLICITACAO_FERIAS, neste caso aplicamos o short 10.
	 * 
	 * @param dataInicioFerias
	 * 
	 */
	public static boolean validacaoParaSolicitacaoDeFerias(LocalDate dataInicio) {
		int intervalo = retornarIntervaloEmDiasEntreAsDatas(LocalDate.now(), dataInicio);
		System.out.println(intervalo);
		if (intervalo > PRAZO_MINIMO_SOLICITACAO_FERIAS) {
			return true;
		} else {
			return false;

		}
	}
}